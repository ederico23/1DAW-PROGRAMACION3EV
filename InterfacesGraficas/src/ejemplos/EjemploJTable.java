package ejemplos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class EjemploJTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploJTable frame = new EjemploJTable();
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
	public EjemploJTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//crear tablamodelo
		DefaultTableModel modelo = new DefaultTableModel();
		//añadir a modelo
		modelo.addColumn("Nombre");
		modelo.addColumn("Edad");
		modelo.addRow(new Object[] {"El nano" , 33});
		modelo.addRow(new Object[] {"Ana" , 19});
		
		//crear table segun modelo
		JTable table = new JTable(modelo);
		
		//meter en el panel la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(150, 0, 274, 261);
		contentPane.add(scrollPane);
		
		JButton btnBorrarFila = new JButton("Borrar Fila");
		btnBorrarFila.setBounds(10, 11, 130, 23);
		contentPane.add(btnBorrarFila);
		
		JButton btnAddAlumno = new JButton("Añadir alumno");
		btnAddAlumno.setBounds(10, 60, 130, 23);
		contentPane.add(btnAddAlumno);
		
		//listners
		btnBorrarFila.addActionListener(e->{
			int fila = table.getSelectedRow(); //si no seleccionas fila y le das a borrar te devuelve -1
			if(fila != -1) { //por eso diferente de -1, para que borre todas las selecciondas
				modelo.removeRow(fila);
			}
		});// fin btnBorrarFila listener
		
		btnAddAlumno.addActionListener(e->{
			String nombre = JOptionPane.showInputDialog(
					this,
					"Introduce nombre del alumno", 
					"Añadir alumno",
					JOptionPane.OK_CANCEL_OPTION);
			
			String edad = JOptionPane.showInputDialog(
					this,
					"Introduce la edad del alumno", 
					"Añadir alumno",
					JOptionPane.OK_CANCEL_OPTION);
			
			modelo.addRow(new Object[] {nombre, edad});
		});//fin btnAddAlumno()
		
		
	}//fin constructor
	
	
	
}//fin class
