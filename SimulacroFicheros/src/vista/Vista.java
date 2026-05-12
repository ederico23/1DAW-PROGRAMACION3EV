package vista;

/**
 * Clase de la Vista
 * Clase donde estarán guardados todos los componentes de la vista y no habrá logica
 * 
 * @author Eder Gracia
 * @version 11/05/26 1.0
 */

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumero;
	private JButton btnMultiplos, btnGuardar;
	private JTextArea textArea;
	private JLabel lblMensajes;
	private JButton btnMostrar;
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInfo = new JLabel("Introduce un  numero");
		lblInfo.setBounds(39, 22, 113, 14);
		contentPane.add(lblInfo);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(162, 19, 99, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		btnGuardar = new JButton("Guardar numero");
		btnGuardar.setBounds(311, 18, 164, 23);
		contentPane.add(btnGuardar);
		
		btnMultiplos = new JButton("Multiplos de 3");
		btnMultiplos.setBounds(311, 63, 164, 23);
		contentPane.add(btnMultiplos);
		
		textArea = new JTextArea();
		textArea.setBounds(39, 62, 222, 152);
		contentPane.add(textArea);
		
		lblMensajes = new JLabel("");
		lblMensajes.setBounds(39, 225, 222, 70);
		contentPane.add(lblMensajes);
		
		btnMostrar = new JButton("Mostrar numeros");
		btnMostrar.setBounds(311, 110, 164, 23);
		contentPane.add(btnMostrar);

	}//fin Vista()
	
	public void setListenerGuardar(ActionListener l) {
		btnGuardar.addActionListener(l);
	}
	
	public void setListenerMultiplos3(ActionListener l) {
		btnMultiplos.addActionListener(l);
	}
	
	public String getNumero() {
		return txtNumero.getText();
	}
	
	public void setMensajes(String m) {
		lblMensajes.setText(m);
	}
	
	public void setNumeros(String n) {
		textArea.setText(n);
	}
	
	public void setListenerMostrar(ActionListener l) {
		btnMostrar.addActionListener(l);
	}
}//fin class
