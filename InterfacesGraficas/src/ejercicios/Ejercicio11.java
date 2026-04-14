package ejercicios;

/**
 * Ejercicio 11
Diseña un programa que traduzca palabras del español al inglés.
Si la palabra no está en el diccionario o se ha dejado el campo en blanco, se debe informar de
ello mediante ventanas emergentes
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Ejercicio11 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPalabraSpain;
	private String[] palabrasEspañol= {};
	private String[] palabrasIngles= {};

	/**
	 * Create the frame.
	 */
	public Ejercicio11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPalabraSpain = new JTextField();
		txtPalabraSpain.setBounds(67, 40, 86, 20);
		contentPane.add(txtPalabraSpain);
		txtPalabraSpain.setColumns(10);
		
		JLabel lblMensaje = new JLabel("Palabra a traducir:");
		lblMensaje.setBounds(67, 11, 112, 14);
		contentPane.add(lblMensaje);
		
		JLabel lblTraducida = new JLabel("");
		lblTraducida.setBounds(214, 103, 180, 14);
		contentPane.add(lblTraducida);
		
		JButton btnTraductor = new JButton("TRADUCIR");
		btnTraductor.setBounds(67, 99, 89, 23);
		contentPane.add(btnTraductor);

		
		//LISTENERS
		btnTraductor.addActionListener(e->{
			String palabraATraducir = txtPalabraSpain.getText();
			
		});//fin btnTraductor() listener
	}//fin contructor
}//fin class
