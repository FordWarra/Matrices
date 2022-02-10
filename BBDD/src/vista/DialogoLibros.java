package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import controlador.Controlador;
import modelo.Editorial;
import modelo.Libro;

public class DialogoLibros extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogoLibros frame = new DialogoLibros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DialogoLibros() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Listado de Libros:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Isbn", "T\u00EDtulo", "Codigo Editorial", "A\u00F1o", "N\u00FAmero de P\u00E1ginas", "Precio", "Cantidad", "PrecioCD"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, Integer.class, Float.class, Integer.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnCerrar = new JButton("Cerrar");
		panel.add(btnCerrar, "cell 0 1,alignx right");
	}

	
	public void setListaLibros(ArrayList<Libro> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Libro libro : lista) {
			Object [] fila = {
					libro.getIsbn(), libro.getTitulo(), libro.getCodEditorial(), libro.getAño(), 
					libro.getNum_pags(), libro.getPrecio(), libro.getCantidad(), libro.getPrecioCD()
			};
			modelo.addRow(fila);
		}
	}
	
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}


	

}
