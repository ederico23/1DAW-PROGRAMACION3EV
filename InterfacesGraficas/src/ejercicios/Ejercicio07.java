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
	private JLabel lblError;

	/**
	 * Create the frame.
	 */
	public Ejercicio07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		//variables
		JLabel lblCelsius = new JLabel("A Celsius");
		lblCelsius.setBounds(10, 14, 49, 20);
		contentPane.add(lblCelsius);

		JLabel lblFare = new JLabel("A Farenheit");
		lblFare.setBounds(10, 101, 65, 20);
		contentPane.add(lblFare);

		JLabel lblError = new JLabel("");
		lblError.setBounds(69, 298, 227, 61);
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

		btnFare.addActionListener(e -> {
			try {
				int opcion = JOptionPane.showConfirmDialog(
						this, 
						"¿Quieres convertir de grados Celsius a Farenheit?",
						"Confrmacion", 
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (opcion == 0) {

					double c = Double.parseDouble(txtCelsius.getText());
					txtFare.setText(String.format("%.2f", aFarenheit(c)));
				} else if(opcion == 1) {
					int opcion2 =JOptionPane.showConfirmDialog(
							null,
							"¿ESTAS TOTALMENTE SEGURO?", 
							"2ª Confirmacion", 
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE);
					if(opcion2 == 0) {
						JOptionPane.showMessageDialog(null, "vale. ADIOS");
					} else {
						int opcion3 = JOptionPane.showConfirmDialog(
								this, 
								"¿Quieres convertir de grados Celsius a Farenheit?",
								"3ª Confrmacion", 
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.WARNING_MESSAGE);
						if(opcion3 == 0) {
							double c = Double.parseDouble(txtCelsius.getText());
							txtFare.setText(String.format("%.2f", aFarenheit(c)));
						} if (opcion3 == 1){
							JOptionPane.showConfirmDialog(null, "ADIOS");					
						}
					}//fin if anidado1

				}//fin if principal
			} catch (NumberFormatException ex) {
				lanzarErrorNumero(); 
			}
		});//fin ActionListenerCelsius


		btnCelsius.addActionListener(e -> {
			try {
				int opcion = JOptionPane.showConfirmDialog(
						this, 
						"¿Quieres convertir de grados Farenheit a Celsius?",
						"Confrmacion", 
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (opcion == 0) {
					double f = Double.parseDouble(txtFare.getText());
					txtCelsius.setText(String.format("%.2f", aCelsius(f)));
				} else if(opcion == 1) {
					int opcion2 =JOptionPane.showConfirmDialog(
							null,
							"¿ESTAS TOTALMENTE SEGURO?", 
							"2ª Confirmacion", 
							JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE);
					if(opcion2 == 0) {
						JOptionPane.showMessageDialog(null, "vale. ADIOS");
					} else {
						int opcion3 = JOptionPane.showConfirmDialog(
								this, 
								"Vas a convertir de grados Farenheit a Celsius",
								"3ª Confrmacion", 
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.WARNING_MESSAGE);
						if(opcion3 == 0) {
							double f = Double.parseDouble(txtFare.getText());
							txtCelsius.setText(String.format("%.2f", aCelsius(f)));
						} else if (opcion3 == 1) {
							JOptionPane.showConfirmDialog(null, "ADIOS");
						}
					}//fin if anidado1

				}//fin confirmacion

			} catch (NumberFormatException ex) {
				lanzarErrorNumero();
			}//fin try catch
		});//fin ActionListenerFare

	}//fin Ejercicio06()

	private double aFarenheit(double c) {
		return (c * 1.8) + 32; 
	}
	private double aCelsius(double f) {
		return (f - 32) / 1.8; 
	}

	private void lanzarErrorNumero() {
		JOptionPane.showMessageDialog(this,
				"Introduce un número válido", 
				"Error", 
				JOptionPane.ERROR_MESSAGE);
		lblError.setText("Error: Caracteres no válidos");
	}

	private void confirmacionACelsius() {
		//JOptionPane.showMessageDialog(this, "Vas a convertir de grados Farenheit a Celsius");
		int opcion = JOptionPane.showConfirmDialog(
				this, 
				"Vas a convertir de grados Farenheit a Celsius",
				"Confrmacion", 
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (opcion == 0) {

		}//fin if opcion
	}//fin confirmacionACeslsius

	private void confirmacionAFarenheit() {
		JOptionPane.showMessageDialog(this, "Vas a convertir de grados Celsius a Farenheit");

	}//fin confirmacionAFarenheit

	//	private void camposVacios(JTextField campos) {
	//		
	//		if(campos.getText().isEmpty()) {
	//			JOptionPane.showMessageDialog(this, "Por favor, rellene uno de los dos campos");			
	//		}
	//	}//fin camposVacios
}//fin class
