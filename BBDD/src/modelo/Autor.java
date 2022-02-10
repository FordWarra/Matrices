/**
 * 
 */
package modelo;

import java.util.Objects;

/**
 * @author Fernando
 *
 */
public class Autor {

	private int idAutor;
	private String nombre;
	private String apellidos;
	
	/**
	 * 
	 */
	public Autor() {
		this.nombre="";
		this.apellidos="";
		// TODO Esbozo de constructor generado automáticamente
	}

	public Autor(int idAutor, String nombre, String apellidos) {
		super();
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAutor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return idAutor == other.idAutor;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	

}
