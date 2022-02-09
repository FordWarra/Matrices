/**
 * 
 */
package conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author David
 *
 */
public class FuncionesBD {
	
	private static ConexionBD conexion = new ConexionBD();
	
	public static void mostrarEditoriales() {
		// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from editoriales");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				int codEditorial = resultado.getInt("codeditorial");
				String nombre = resultado.getString("nombre");
				int a�o = resultado.getInt("a�o");
				
				System.out.printf("codEDitorial: %d\tNombre: %s\tA�o: %d\n",
						codEditorial, nombre, a�o);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
	}
	
	public static void mostrarLibros() {
		// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from libros\r\n"
					+ "order by num_pags DESC");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				String isbn = resultado.getString("isbn");
				String titulo = resultado.getString("t�tulo");
				int codigo = resultado.getInt("codeditorial");
				int a�o = resultado.getInt("a�o");
				int num = resultado.getInt("num_pags");
				float precio = resultado.getFloat("precio");
				int cantidad = resultado.getInt("cantidad");
				float precioCD = resultado.getFloat("precioCD");
				
				System.out.printf("isbn: %s\tT�tulo: %s\tC�digo: %d\tA�o: %d\n"
						+ "Num P�ginas: %d\tPrecio: %.2f\tCAntidad: %d\tPRecioCD:%.2f\n",
						isbn,titulo,codigo, a�o, num, precio, cantidad, precioCD);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
	}
	
}
