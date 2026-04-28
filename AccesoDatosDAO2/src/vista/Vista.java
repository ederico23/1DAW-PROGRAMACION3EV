package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		//crear tablamodelo
		DefaultTableModel modelo = new DefaultTableModel();
		//añadir al modelo
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Edad");
		
		//creamos la tabla segun el modelo
		JTable tabla = new JTable(modelo);
		
		//meter en el panel, la tabla
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 0, 231, 261);
		contentPane.add(scrollPane);
		
		//BTN
		JButton btnAdd = new JButton("Añadir");
		btnAdd.setBounds(297, 43, 89, 23);
		contentPane.add(btnAdd);
		btnAdd.getActionCommand();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(297, 122, 89, 23);
		contentPane.add(btnEditar);
		btnEditar.getActionCommand();
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(297, 203, 89, 23);
		contentPane.add(btnBorrar);
		btnBorrar.getActionCommand();
		
	}//fin constructor

	
	
}//fin class
