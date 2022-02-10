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
	private A�adirAutores a�adirAutores;
	
	public Controlador() {
		// Creamos las ventanas de la aplicaci�n
		ventanaPpal = new VentanaPpal();
		dialogoEditoriales = new DialogoEditoriales();
		dialogoLibros = new DialogoLibros();
		dialogoAutores = new DialogoAutores();
		a�adirAutores = new A�adirAutores();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoEditoriales.setControlador(this);
		dialogoLibros.setControlador(this);
		dialogoAutores.setControlador(this);
		a�adirAutores.setControlador(this);
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
	
	public void a�adirAutores(Autor a) {
		int res = FuncionesBD.a�adirAutor(a);
		if (res == 0) {
			JOptionPane.showMessageDialog(a�adirAutores, "Error no se ha podido insertar.");
		}
		else {
			JOptionPane.showMessageDialog(a�adirAutores, "Autor a�adido correctamente.");
			a�adirAutores.setVisible(false);
		}
	}
	
	public void mostrarA�adirAutores() {
		a�adirAutores.setVisible(true);
	}
}
