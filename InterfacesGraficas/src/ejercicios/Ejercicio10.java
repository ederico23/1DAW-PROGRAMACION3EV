package ejercicios;

/**
 * Ejercicio10
Realizar una aplicación simple en donde implemente una interfaz con un campo de texto y un
botón. Debe simular la introducción de un password.
El password correcto se guardará en un atributo de la clase.
Dependiendo del valor introducido en la caja de texto (correcto - incorrecto) se debe desplegar
los mensajes de dialogo con los errores correspondientes.
El password es correcto si contiene:
•Al menos una mayúscula.
•Al menos una minúscula.
•Al menos un número.
•Longitud mínima 8.

 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Ejercicio10 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * ^ $ incio fin de la cadena
	 * (?=.*[a-z]) busca al menos una minus
	 * (?=.*[A-Z]) busca al menos una mayus
	 * (?=.*\\d) busca al menos un digito
	 * .{8,} minimo 8 caracteres
	 */
	
	private JPasswordField fieldPassword;
	
	
	/**
	 * Create the frame.
	 */
	public Ejercicio10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroduceContraseña = new JLabel("Introduce contraseña");
		lblIntroduceContraseña.setBounds(146, 57, 127, 14);
		contentPane.add(lblIntroduceContraseña);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setBounds(146, 102, 127, 20);
		contentPane.add(fieldPassword);
		
		JButton btnSavePassword = new JButton("Aceptar");
		btnSavePassword.setBounds(150, 154, 88, 22);
		contentPane.add(btnSavePassword);

		btnSavePassword.addActionListener(e->{
			verificarPassword();
		});//fin btnSavePassword listener
		
	}//fin construcor

	public void verificarPassword() {
		String passwordIntroducida = new String(fieldPassword.getPassword());
		String passwordCorrecta = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
		
		String mensajeCorrecto = "Contraseña incorrecta \nEl password es correcto si contiene:\r\n"
				+ "•Al menos una mayúscula.\r\n"
				+ "•Al menos una minúscula.\r\n"
				+ "•Al menos un número.\r\n"
				+ "•Longitud mínima 8.\r\n"
				+ "";
		
		try {
			
		if(passwordIntroducida.matches(passwordCorrecta)) {
			JOptionPane.showMessageDialog(this, "Contraseña correcta", "Verificado", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, mensajeCorrecto, "Constraseña incorrecta", JOptionPane.ERROR_MESSAGE);
		}//fin ifelse verificar

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Introduce un caracter valido", "Error", JOptionPane.ERROR_MESSAGE);
		}//fin trycatch
	}//fin verificarPassword()
}//fin class
