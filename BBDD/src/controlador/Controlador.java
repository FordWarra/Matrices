/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.FuncionesBD;
import modelo.*;
import vista.*;


/**
 * @author David
 *
 */
public class Controlador {
	
	private DialogoLibros dialogoLibros;
	private VentanaPpal ventanaPpal;
	private DialogoEditoriales dialogoEditoriales;
	private DialogoAutores dialogoAutores;
	private AñadirAutores añadirAutores;
	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		dialogoEditoriales = new DialogoEditoriales();
		dialogoLibros = new DialogoLibros();
		dialogoAutores = new DialogoAutores();
		añadirAutores = new AñadirAutores();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoEditoriales.setControlador(this);
		dialogoLibros.setControlador(this);
		dialogoAutores.setControlador(this);
		añadirAutores.setControlador(this);
	}
	
	public void iniciarPrograma() {
		ventanaPpal.setVisible(true);
	}
	
	public void mostrarEditoriales() {
		ArrayList<Editorial> lista = FuncionesBD.mostrarEditoriales();
		dialogoEditoriales.setListaEditoriales(lista);
		dialogoEditoriales.setVisible(true);
	}
	
	public void mostrarLibros() {
		ArrayList<Libro> lista = FuncionesBD.mostrarLibros();
		dialogoLibros.setListaLibros(lista);
		dialogoLibros.setVisible(true);
	}
	
	public void mostrarAutores() {
		ArrayList<Autor> lista = FuncionesBD.mostrarAutor();
		dialogoAutores.setListaAutores(lista);
		dialogoAutores.setVisible(true);
		
	}
	
	public void añadirAutores(Autor a) {
		int res = FuncionesBD.añadirAutor(a);
		if (res == 0) {
			JOptionPane.showMessageDialog(añadirAutores, "Error no se ha podido insertar.");
		}
		else {
			JOptionPane.showMessageDialog(añadirAutores, "Autor añadido correctamente.");
			añadirAutores.setVisible(false);
		}
	}
	
	public void mostrarAñadirAutores() {
		añadirAutores.setVisible(true);
	}
}
