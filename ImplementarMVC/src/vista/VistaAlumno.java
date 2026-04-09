package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VistaAlumno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JButton btnAceptar;
	private JTextArea txtAreaAlumnos;
	private JScrollPane scrollPanelAreaAlumnos;
	private JButton btnBorrar;

	/**
	 * Create the frame.
	 */
	public VistaAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setBounds(69, 11, 123, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setBounds(202, 11, 45, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);

		btnAceptar = new JButton("Agregar");
		btnAceptar.setBounds(257, 10, 89, 23);
		contentPane.add(btnAceptar);

		txtAreaAlumnos = new JTextArea(10,30);
		scrollPanelAreaAlumnos = new JScrollPane(txtAreaAlumnos);
		scrollPanelAreaAlumnos.setBounds(72, 53, 274, 197);
		contentPane.add(scrollPanelAreaAlumnos);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(345, 130, 89, 23);
		contentPane.add(btnBorrar);

	}//fin constructor

	//COGER DATOS
	public String getNombre() {
		return txtNombre.getText();
	}//fin getNombre()

	public String getEdad() {
		return txtEdad.getText();
	}//fin getEdad()

	//VACIAR DATOS
	public void limpiarDatos() {
		txtNombre.setText("");
		txtEdad.setText("");
	}//fin limpiarDatos()

	//MOSTRAR MENSAJES
	public void mostrarMensaje(String mensaje) { //ESTO ES LA VENTANA EMERGENTE 
		JOptionPane.showMessageDialog(this, mensaje); //(THIS = DENTRO VENTANA, NULL = MITAD PANTALLA)
	}//fin mostrarMensaje

	public void actualizarLista(String texto) {
		txtAreaAlumnos.setText(texto);
	}//fin actualizarLista

	//LISTENERS
	public void agregarListenerAceptar(ActionListener listener) { //cogera del controlador "listener"
		btnAceptar.addActionListener(listener);	
	}

	public void agregarListenerBorrar(ActionListener listener) {
		btnBorrar.addActionListener(listener);
	}

}//fin class
