package ejercicios;

/**
 * Ejercicio 1
Crea una ventana con un botón en la parte de abajo y una etiqueta
 en el centro (borderlayout), de modo que cada vez que se pulse 
 el botón el fondo de la etiqueta cambie de rojo a verdeescribiendo 
 el color en la etiqueta.

 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

	

public class Ejercicio01 extends JFrame {

	JLabel lblCambioColor;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	//	/**
	//	 * Launch the application.
	//	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					Ejercicio01 frame = new Ejercicio01();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public Ejercicio01() {
		//predefinido
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		//creacion variables
		JButton btnCambiarColor = new JButton("Cambiar de color");
		contentPane.add(btnCambiarColor, BorderLayout.SOUTH);

		JLabel lblCambioColor = new JLabel("Esto va a cambiar de color");
		lblCambioColor.setForeground(new Color(255, 255, 255));
		lblCambioColor.setBackground(new Color(255, 0, 0));
		contentPane.add(lblCambioColor, BorderLayout.CENTER);
		lblCambioColor.setOpaque(true);

		//implementar acciones
		btnCambiarColor.addActionListener(e->cambiarColor(lblCambioColor, Color.green));

	}//fin Ejercicio01

	/**
	 * metodo para cambiar de color
	 * @param red 
	 * @param lblCambioColor
	 */
	private void cambiarColor(JLabel lblCambioColor, Color green) {
		
		lblCambioColor.setBackground(green);
		
	}//fin cambiarColor

}//fin class
