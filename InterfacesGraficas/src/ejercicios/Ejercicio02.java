package ejercicios;

/**
 * Ejercicio 2
Crear una ventana con dos botones: "Rojo” y "Azul”, y una etiqueta.
 Según el que se pulsesepondrá el color de fondo Opuesto de la etiqueta
 y el color pulsado en la etiqueta. Situar los botones en el norte y el sur, y en el
centro la etiqueta.

 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ejercicio02 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ejercicio02 frame = new Ejercicio02();
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
	public Ejercicio02() {
		//predefinido
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		//Variables
		JButton btnAzul = new JButton("Cambia a azul");
		contentPane.add(btnAzul, BorderLayout.SOUTH);
		
		JButton btnRojo = new JButton("Cambio a rojo");
		contentPane.add(btnRojo, BorderLayout.NORTH);
		
		JLabel lblCambio = new JLabel("ETIQUETA");
		lblCambio.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCambio, BorderLayout.CENTER);
		lblCambio.setOpaque(true);
		
		//Acciones
		btnAzul.addActionListener(e->lblCambio.setBackground(Color.BLUE));
		btnRojo.addActionListener(e->lblCambio.setBackground(Color.RED));		
		
	}//fin Ejercicio02

}//fin class
