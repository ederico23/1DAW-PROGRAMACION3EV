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
import javax.swing.JOptionPane;
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
		setBounds(100, 100, 397, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		//variables
		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setBounds(10, 14, 49, 20);
		contentPane.add(lblCelsius);

		JLabel lblFare = new JLabel("Farenheit");
		lblFare.setBounds(10, 101, 65, 20);
		contentPane.add(lblFare);

		JLabel lblError = new JLabel("");
		lblError.setBounds(134, 24, 0, 0);
		contentPane.add(lblError);

		txtCelsius = new JTextField();
		txtCelsius.setBounds(201, 11, 146, 26);
		contentPane.add(txtCelsius);
		txtCelsius.setColumns(10);

		txtFare = new JTextField();
		txtFare.setColumns(10);
		txtFare.setBounds(201, 98, 146, 26);
		contentPane.add(txtFare);

		JButton btnCelsius = new JButton("CELSIUS");
		btnCelsius.setBounds(15, 223, 95, 29);
		contentPane.add(btnCelsius);

		JButton btnFare = new JButton("FARENHEIT");
		btnFare.setBounds(214, 223, 117, 29);
		contentPane.add(btnFare);


		//Acciones

		btnCelsius.addActionListener(e->{
			try {
				camposVacios(lblCelsius);
				double f = Double.parseDouble(txtFare.getText());
				double resultado = aCelsius(f);
				confirmacionACelsius();
				txtCelsius.setText("" + resultado);
				lblError.setText("");
				txtFare.setText("");
			}catch (NumberFormatException ex) {
				lblError.setText("Error, introduce un numero valido");
			}//fin catch
		});//fin ActionListenerCelsius

		
		btnFare.addActionListener(e->{
			try {
			camposVacios(lblFare);
			double c = Double.parseDouble(txtCelsius.getText());
			double resultado = aFarenheit(c);
			confirmacionAFarenheit();
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

	private void confirmacionACelsius() {
		JOptionPane.showMessageDialog(this, "Vas a convertir de grados Farenheit a Celsius");
	}//fin confirmacionACeslsius
	
	private void confirmacionAFarenheit() {
		JOptionPane.showMessageDialog(this, "Vas a convertir de grados Celsius a Farenheit");
	
	}//fin confirmacionAFarenheit
	
	private void camposVacios(JLabel campos) {
		
		if(campos.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, rellene uno de los dos campos");			
		}
	}//fin camposVacios
}//fin class
