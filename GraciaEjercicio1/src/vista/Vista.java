package vista;

/**
 * Ejercicio 1
 * @author Eder Gracia Carmona 25/05/26
 */

import java.awt.EventQueue;
import java.awt.JobAttributes;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Alumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre, txtNota;
	private JButton btnGuardar, btnMostrarAprobados;
	private JTextArea textArea;

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
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 36, 67, 14);
		contentPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 33, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nota: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(25, 76, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNota = new JTextField();
		txtNota.setBounds(92, 73, 86, 20);
		contentPane.add(txtNota);
		txtNota.setColumns(10);
		
		btnGuardar = new JButton("Guardar en fichero");
		btnGuardar.setBounds(202, 32, 149, 23);
		contentPane.add(btnGuardar);
		
		btnMostrarAprobados = new JButton("Mostrar aprobados");
		btnMostrarAprobados.setBounds(202, 72, 149, 23);
		contentPane.add(btnMostrarAprobados);
		
		textArea = new JTextArea();
		textArea.setBounds(25, 119, 326, 119);
		contentPane.add(textArea);

	}//fin Vista()
	
	//GETTER & SETTER
	public String getNombre() {
		return txtNombre.getText();
	}//fin getNombre()
	
	public String getNota() {
		return txtNota.getText();
	}//fin getNota()
	
	public void vaciarNombre() {
		txtNombre.setText("");
	}//fin vaciarNombre()
	
	public void vaciarNota() {
		txtNota.setText("");
	}//fin vaciarNota()
	
	public void setTxtArea(String alumnos) {
		textArea.setText(alumnos);
	}//fin setTxtArea()
	
	//ACTION LISTENERS
	public void setListenerGuardarFichero(ActionListener l) {
		btnGuardar.addActionListener(l);
	}//fin setListenerGuardarFichero()
	
	public void setListenerMostrarAprobados(ActionListener l) {
		btnMostrarAprobados.addActionListener(l);
	}//fin setListenerMostrarAprobados()
	
	//MENSAJES
	public void mostrarInfo(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
	}//fin mostrarInfo()
	
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Informacion", JOptionPane.ERROR_MESSAGE);
	}//fin mostrarError()
}//fin class Vista
