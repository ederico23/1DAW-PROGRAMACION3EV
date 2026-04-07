package ejemplos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Ejemplo01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;

	//separar el main para tener la logica en otro lado
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ejemplo01 frame = new Ejemplo01();
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
	public Ejemplo01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setForeground(new Color(255, 0, 0));
		setTitle("Primera ventana");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		lblNombre.setBounds(71, 14, 37, 14);
		contentPane.add(lblNombre);
		
		txt1 = new JTextField();
		txt1.setBounds(163, 11, 86, 20);
		txt1.setToolTipText("");
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JButton boton1 = new JButton("Accept");
		boton1.addActionListener(e->System.out.println("Accion capturada"));
		boton1.setBounds(279, 10, 94, 23);
		contentPane.add(boton1);
		
		JButton boton2 = new JButton("New button");
		boton2.addActionListener(e->lblNombre.setText("Pon tu nombre"));
		boton2.setBounds(268, 140, 89, 23);
		contentPane.add(boton2);

	}//fin Ejemplo01

}//fin class
