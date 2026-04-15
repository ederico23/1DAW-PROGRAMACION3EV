package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControllerVistaRegistarse;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VistaRegistrarse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtNombre;
	private static JPasswordField fieldPassword;

	/**
	 * Create the frame.
	 */
	public VistaRegistrarse() {
		//PREDEFINIDO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//AÑADIDO
		JLabel lblMensaje = new JLabel("Registro");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(133, 11, 123, 14);
		contentPane.add(lblMensaje);
		
		JLabel lblUsuario = new JLabel("Nombre de usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(30, 77, 133, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Constraseña");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(30, 135, 123, 14);
		contentPane.add(lblPassword);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(231, 74, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		fieldPassword.setBounds(231, 132, 86, 20);
		contentPane.add(fieldPassword);
		
		JButton btnRegistro = new JButton("Aceptar");
		btnRegistro.setBounds(228, 189, 89, 23);
		contentPane.add(btnRegistro);

		//LISTENERS
		btnRegistro.addActionListener(e->{
			ControllerVistaRegistarse.comprobarUsuario();
			ControllerVistaRegistarse.comprobarPassword();
		});//fin btnRegistro listener
		
	}//fin construcor
}//fin class
