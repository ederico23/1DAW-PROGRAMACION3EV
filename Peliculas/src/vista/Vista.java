package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnCrear;
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		initGUI();
	}//fin constructor

	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 371);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBounds(0,0,497,261);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 487, 250);
		getContentPane().add(scrollPane);
		
		btnCrear = new JButton("Crear Archivo");
		btnCrear.setBounds(31, 298, 126, 23);
		getContentPane().add(btnCrear);
		
	}//fin initGUI

	//LISTENERS
	public void setListenerCrear(ActionListener l) {
		btnCrear.addActionListener(l);
	}//fin setListenerCrear
	
	public JTable getTable() {
		return table;
	}
}//fin class
