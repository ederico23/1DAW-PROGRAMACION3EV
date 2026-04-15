package ejercicios;

/**
 * Ejercicio 11
Diseña un programa que traduzca palabras del español al inglés.
Si la palabra no está en el diccionario o se ha dejado el campo en blanco, se debe informar de
ello mediante ventanas emergentes
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Ejercicio11 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPalabraSpain;
	private String[] palabrasEspañol= {"Perro", "Gato", "Casa", "Coche", "Árbol", "Libro", "Mesa", "Silla", "Sol", "Luna", "Agua", "Comida", "Manzana", "Niño", "Niña", "Feliz", "Grande", "Pequeño", "Correr", "Comer"};
	private String[] palabrasIngles= {"Dog", "Cat", "House", "Car", "Tree", "Book", "Table", "Chair", "Sun", "Moon", "Water", "Food", "Apple", "Boy", "Girl", "Happy", "Big", "Small", "Run", "Eat"};

	/**
	 * Create the frame.
	 */
	public Ejercicio11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtPalabraSpain = new JTextField();
		txtPalabraSpain.setBounds(67, 40, 86, 20);
		contentPane.add(txtPalabraSpain);
		txtPalabraSpain.setColumns(10);

		JLabel lblMensaje = new JLabel("Palabra a traducir:");
		lblMensaje.setBounds(67, 11, 112, 14);
		contentPane.add(lblMensaje);

		JLabel lblTraducida = new JLabel("");
		lblTraducida.setBounds(214, 103, 180, 14);
		contentPane.add(lblTraducida);

		JButton btnTraductor = new JButton("TRADUCIR");
		btnTraductor.setBounds(67, 99, 89, 23);
		contentPane.add(btnTraductor);


		//LISTENERS
		btnTraductor.addActionListener(e->{
			String palabraATraducir = txtPalabraSpain.getText();
			boolean encontrada = false;
			try {

				if(palabraATraducir.isEmpty()) {
					JOptionPane.showMessageDialog(
							this,
							"Introduce una palabra",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					
					for(int i = 0; i < palabrasEspañol.length; i++) {
						if(palabraATraducir.equalsIgnoreCase(palabrasEspañol[i])) {
							lblTraducida.setText(palabrasIngles[i]);
							encontrada = true;
							break;
						}//fin ifelse palabras iguales
					}//fin for palabrasEspañol
					
					if(!encontrada) {
						JOptionPane.showMessageDialog(
								this, 
								"Palabra no encontrada en el diccionario", 
								"Palabra no encontrada",
								JOptionPane.WARNING_MESSAGE);
						lblTraducida.setText("");
					}//fin if no encontrada
					
				} //fin ifelse vacio


			}catch (NumberFormatException ex) {

				JOptionPane.showMessageDialog(
						this,
						"Introduce una palabra valida",
						"Error",
						JOptionPane.ERROR_MESSAGE);

			}//fin trycatch


		});//fin btnTraductor() listener
	}//fin contructor
}//fin class
