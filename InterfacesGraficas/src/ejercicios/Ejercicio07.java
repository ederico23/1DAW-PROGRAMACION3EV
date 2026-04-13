package ejercicios;

/**
 * Ejercicio 7
A partir del ejercicio 6, pon paneles emergentes en el conversor, de tal manera que si
introduzco grados Celsius y pulso grados farenheit me pida confirmación ( y viceversa).
Además, si no hay nada escrito en los cuadros de texto debe salir una ventana de error que me
indique que debo introducir datos.

 */

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ejercicio07 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCelsius;
	private JTextField txtFare;

	/**
	 * Create the frame.
	 */
	public Ejercicio07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		//variables
		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(38, 50, 76, 17);
		contentPane.add(lblCelsius);

		JLabel lblFare = new JLabel("Farenheit");
		lblFare.setBounds(38, 113, 96, 17);
		contentPane.add(lblFare);

		JLabel lblError = new JLabel("");
		lblError.setBounds(38, 238, 339, 14);
		contentPane.add(lblError);

		txtCelsius = new JTextField();
		txtCelsius.setBounds(256, 48, 96, 20);
		contentPane.add(txtCelsius);
		txtCelsius.setColumns(10);

		txtFare = new JTextField();
		txtFare.setColumns(10);
		txtFare.setBounds(256, 111, 96, 20);
		contentPane.add(txtFare);

		JButton btnCelsius = new JButton("CELSIUS");
		btnCelsius.setBounds(23, 185, 88, 22);
		contentPane.add(btnCelsius);

		JButton btnFare = new JButton("FARENHEIT");
		btnFare.setBounds(256, 185, 96, 22);
		contentPane.add(btnFare);


		//Acciones

		btnCelsius.addActionListener(e->{
			try {
				double f = Double.parseDouble(txtFare.getText());
				double resultado = aCelsius(f);
				txtCelsius.setText("" + resultado);
				lblError.setText("");
				txtFare.setText("");
			}catch (NumberFormatException ex) {
				lblError.setText("Error, introduce un numero valido");
			}//fin catch
		});//fin ActionListenerCelsius

		
		btnFare.addActionListener(e->{
			try {
			double c = Double.parseDouble(txtCelsius.getText());
			double resultado = aFarenheit(c);
			txtFare.setText(String.format("" + resultado));
			lblError.setText("");
			txtCelsius.setText("");
			} catch (NumberFormatException ex){
				lblError.setText("Error, introduce un numero valido");
			}//fin trycatch
		});//fin ActionListenerFare

	}//fin Ejercicio06()

	private double aFarenheit(Double celsius) {
		return (celsius * 1.8) + 32;
	}//fin aFarenheit


	private double aCelsius(Double fare) {
		return (fare - 32)/1.8;	
	}//fin aCelsius
	
	
}//fin class
