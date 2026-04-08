package ejercicios;

/**
 * Ejercicio 4
Realizar un programa que muestre una ventana como la siguiente:
Cada vez que se pulse sobre un botón deun
color, se debe incrementar el númerodel
mismo, a la derecha.
Pista: Usar arrays:
JButton [] botones;
JLabel [] etiquetas;
int [] contadores;
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;


import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ejercicio04 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int[] contadores = new int[6];
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ejercicio04 frame = new Ejercicio04();
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
	public Ejercicio04() {
		//predefinido
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//variables
		JButton btnRojo = new JButton("");
		btnRojo.setBackground(new Color(255, 0, 0));
		btnRojo.setBounds(24, 21, 170, 41);
		contentPane.add(btnRojo);
		
		JButton btnVerde = new JButton("");
		btnVerde.setBackground(new Color(0, 255, 0));
		btnVerde.setBounds(24, 94, 170, 41);
		contentPane.add(btnVerde);
		
		JButton btnAzul = new JButton("");
		btnAzul.setBackground(new Color(0, 0, 255));
		btnAzul.setBounds(24, 172, 170, 41);
		contentPane.add(btnAzul);
		
		JButton btnRosa = new JButton("");
		btnRosa.setBackground(new Color(255, 0, 128));
		btnRosa.setBounds(24, 257, 170, 41);
		contentPane.add(btnRosa);
		
		JButton btnAmarillo = new JButton("");
		btnAmarillo.setBackground(new Color(255, 255, 0));
		btnAmarillo.setBounds(24, 341, 170, 41);
		contentPane.add(btnAmarillo);
		
		JButton btnGris = new JButton("");
		btnGris.setBackground(new Color(128, 128, 128));
		btnGris.setBounds(24, 424, 170, 41);
		contentPane.add(btnGris);
		
		JLabel lblVerde = new JLabel("Veces pulsadas : 0");
		lblVerde.setBounds(363, 94, 180, 41);
		contentPane.add(lblVerde);
		
		JLabel lblAzul = new JLabel("Veces pulsadas : 0");
		lblAzul.setBounds(363, 172, 180, 41);
		contentPane.add(lblAzul);
		
		JLabel lblRosa = new JLabel("Veces pulsadas : 0");
		lblRosa.setBounds(363, 257, 180, 41);
		contentPane.add(lblRosa);
		
		JLabel lblAmarillo = new JLabel("Veces pulsadas : 0");
		lblAmarillo.setBounds(363, 341, 180, 41);
		contentPane.add(lblAmarillo);
		
		JLabel lblGris = new JLabel("Veces pulsadas : 0");
		lblGris.setBounds(363, 424, 180, 41);
		contentPane.add(lblGris);
		
		JLabel lblRojo = new JLabel("Veces pulsadas : 0");
		lblRojo.setBounds(363, 21, 180, 41);
		contentPane.add(lblRojo);

		//acciones
		//array de botones
		JButton[] botonesPulsados = {
			btnRojo,
			btnVerde,
			btnAzul,
			btnRosa,
			btnAmarillo,
			btnGris
		};
		
		//array de lbls
		JLabel[] coloresLbl = {
			lblRojo,
			lblVerde,
			lblAzul,
			lblRosa,
			lblAmarillo,
			lblGris
		};
		
		
		for(int i = 0; i <botonesPulsados.length; i++) {
			int index = i;
			botonesPulsados[i].addActionListener(e-> {
				contadores[index]++;
				coloresLbl[index].setText("Veces pulsadas : " + contadores[index]);
			});
		}//fin for
		
	}//fin Ejercicio04
}//fin class
