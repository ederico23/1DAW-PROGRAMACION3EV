package ejercicios;

/**
 * Ejercicio 9
Crea un programa con interfaz gráfica con un campo de texto, de modo que al pulsar enter en
el campo de texto aparecerá una ventana emergente (JOptionPane) que nos dirá si el número
introducido en la caja de texto (JTextField) es par o impar
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ejercicio09 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumero;

	/**
	 * Create the frame.
	 */
	public Ejercicio09() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensaje = new JLabel("Introduce un numero");
		lblMensaje.setBounds(148, 53, 171, 22);
		contentPane.add(lblMensaje);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(148, 113, 96, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		txtNumero.addActionListener(e->{
			int numero;
			
			try {
				//cogemos el numero introducido
				numero = Integer.parseInt(txtNumero.getText());
				
				//par o impar
				if(numero%2 == 0) {
					JOptionPane.showMessageDialog(this,
							"El numero " + numero + " es par",
							"Mensaje", 
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, 
							"El numero " + numero + " es impar",
							"Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
				}//fin ifelse par o impar
				
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,
						"Error, introduce un numero", 
						"Ventana error",
						JOptionPane.ERROR_MESSAGE);
			}//fin trycatch
			
		});//fin txtNumero listener
		
	}//fin constructor

}//fin class
