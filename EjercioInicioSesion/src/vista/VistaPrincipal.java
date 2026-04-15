package vista;

import java.awt.EventQueue;
import java.lang.ModuleLayer.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControllerVistaPrincipal;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		//PREDETERMINADA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//AÑADIDO
		JLabel lblBienvenida = new JLabel("Bienvenido!!");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(110, 31, 222, 14);
		contentPane.add(lblBienvenida);
		
		JButton btnLogIn = new JButton("Iniciar sesión");
		btnLogIn.setBounds(52, 144, 138, 23);
		contentPane.add(btnLogIn);
		
		JLabel lblInicioSesion = new JLabel("¿No es tu primera vez aqui?");
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setBounds(32, 119, 172, 14);
		contentPane.add(lblInicioSesion);
		
		JButton btnSignUp = new JButton("Registrasrse");
		btnSignUp.setBounds(240, 144, 138, 23);
		contentPane.add(btnSignUp);
		
		JLabel lblRegistrarse = new JLabel("¿Eres nuevo?");
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setBounds(240, 119, 138, 14);
		contentPane.add(lblRegistrarse);

		//LISTENERS
		btnLogIn.addActionListener(e->{
			ControllerVistaPrincipal.iniciarSesion();
		});//fin btnLogIn listener;
		
		btnSignUp.addActionListener(e->{
			ControllerVistaPrincipal.registrarse();
		});//fin btnSignUp listener
		
		
	} //fin construcor
}//fin class
