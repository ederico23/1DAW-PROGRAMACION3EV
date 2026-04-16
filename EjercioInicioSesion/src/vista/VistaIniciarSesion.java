package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControllerFichero;
import controlador.ControllerInicioSesion;
import controlador.PasswordIncorrectaException;
import controlador.UsuarioNoEncontradoException;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VistaIniciarSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField fieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaIniciarSesion frame = new VistaIniciarSesion();
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
	public VistaIniciarSesion() {
		//PREDEFINIDO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//AÑADIDO
		JLabel lblMensaje = new JLabel("Bienvenido");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(91, 11, 229, 14);
		contentPane.add(lblMensaje);
		
		JLabel lblNombre = new JLabel("Nombre de usuario");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 78, 153, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(214, 75, 153, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(10, 136, 136, 14);
		contentPane.add(lblPassword);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		fieldPassword.setBounds(214, 133, 153, 20);
		contentPane.add(fieldPassword);
		
		JButton btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setBounds(214, 191, 153, 23);
		contentPane.add(btnIniciarSesion);

		//LISTENERS
		btnIniciarSesion.addActionListener(e -> {
			String nombre = txtNombre.getText();
		    String pass = new String(fieldPassword.getPassword());
		    
			Usuario user = new Usuario( nombre, pass);
			
			try{
				ControllerInicioSesion.comprobarDatos(user);
				
			} catch (UsuarioNoEncontradoException ex) {
		        JOptionPane.showMessageDialog(this, "Usuario no registrado", "Error" , JOptionPane.ERROR_MESSAGE);
		    } catch (PasswordIncorrectaException ex2) {
		        JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Error" , JOptionPane.ERROR_MESSAGE);
		    }
		});
		
		
		
	}//fin constructor

	/**
	 * @return the txtNombre
	 */
	public String getTxtNombre() {
		return txtNombre.getText();
	}

	/**
	 * @return the fieldPassword
	 */
	public String getFieldPassword() {
		String password = new String (fieldPassword.getPassword());
		return password;
	}

	
	
}//fin class
