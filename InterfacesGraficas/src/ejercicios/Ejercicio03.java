package ejercicios;

/**
 * Ejercicio 3
Realizar el juego de adivinar un número con interfaz gráfica de modo que en una ventanatengamos los
botones del 1 al 10 y una etiqueta sin texto. Cada vez que se pulse un botónlaetiqueta tiene que decir si se ha
adivinado el número o no.
Parte 2: Después implementarlo con 5 intentos para adivinar el número.
Parte 3: Después añade un botón "Repetir” que deje volver a empezar el juego.

 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class Ejercicio03 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int numeroAdivinar = (int)(Math.random() * 10) + 1;
	int contador = 5;
	boolean ganar = false;

	//	/**
	//	 * Launch the application.
	//	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					Ejercicio03 frame = new Ejercicio03();
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
	public Ejercicio03() {
		//predefinido
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		//Variables
		JLabel lblNumero = new JLabel("");
		lblNumero.setBackground(new Color(255, 128, 0));
		lblNumero.setBounds(84, 38, 272, 30);
		contentPane.add(lblNumero);
		lblNumero.setOpaque(true);

		JButton btn1 = new JButton("1");
		btn1.setBounds(7, 112, 68, 16);
		contentPane.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setBounds(99, 112, 68, 16);
		contentPane.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setBounds(184, 112, 68, 16);
		contentPane.add(btn3);

		JButton btn4 = new JButton("4");
		btn4.setBounds(275, 112, 68, 16);
		contentPane.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setBounds(361, 112, 68, 16);
		contentPane.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setBounds(7, 169, 68, 16);
		contentPane.add(btn6);

		JButton btn7 = new JButton("7");
		btn7.setBounds(99, 169, 68, 16);
		contentPane.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setBounds(184, 169, 68, 16);
		contentPane.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setBounds(275, 169, 68, 16);
		contentPane.add(btn9);

		JButton btn10 = new JButton("10");
		btn10.setBounds(361, 169, 68, 16);
		contentPane.add(btn10);
		
		JButton btnRepetir = new JButton("Volver a jugar");
		btnRepetir.setBounds(166, 233, 120, 30);
		contentPane.add(btnRepetir);
		
		JLabel lblTitulo = new JLabel("ADIVINA EL NUMERO");
		lblTitulo.setBounds(177, 7, 129, 16);
		contentPane.add(lblTitulo);


		//Acciones
		btn1.addActionListener(e->comprobarNumero(1, lblNumero));
		btn2.addActionListener(e->comprobarNumero(2, lblNumero));
		btn3.addActionListener(e->comprobarNumero(3, lblNumero));
		btn4.addActionListener(e->comprobarNumero(4, lblNumero));
		btn5.addActionListener(e->comprobarNumero(5, lblNumero));
		btn6.addActionListener(e->comprobarNumero(6, lblNumero));
		btn7.addActionListener(e->comprobarNumero(7, lblNumero));
		btn8.addActionListener(e->comprobarNumero(8, lblNumero));
		btn9.addActionListener(e->comprobarNumero(9, lblNumero));
		btn10.addActionListener(e->comprobarNumero(10, lblNumero));
		
		//VOLVER A JUGAR	
		btnRepetir.addActionListener(e-> {
			//resetear todo
			numeroAdivinar = (int) (Math.random() * 10 ) + 1;
			contentPane.setBackground(Color.WHITE);
			contador = 5;
			ganar = false;
			
			lblNumero.setText("Nueva partida");
			
		});

	}//fin Ejercicio03

	private void comprobarNumero(int numeroPulsado, JLabel lbl) {
		
		if(contador == 0 || ganar) {
			lbl.setText("Game Over. No tienes vidas");
			return;
		}//fin if contador==0
		
		if(numeroPulsado == numeroAdivinar) {
			lbl.setText("Has adivinado el numero!!!!");
			contentPane.setBackground(Color.GREEN);
			ganar = true;
		} else {
			contador--;
			
			if(contador == 0) {
				lbl.setText("Game Over. No tienes vidas");
				contentPane.setBackground(Color.RED);
				return;
			} else {
				lbl.setText("Error. Prueba de nuevo. Te quedan " + contador + " intentos");
				}//fin ifelse contador == 0
			} //fin ifelse numero correcto
		
		
	}//fin comprobarNumero


}//fin class
