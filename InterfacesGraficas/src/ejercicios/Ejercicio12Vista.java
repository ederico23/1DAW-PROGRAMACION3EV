package ejercicios;

/**
 * Ejercicio 12: Crear personas
Crea el siguiente programa:
• Hay que utilizar una lista de objetos de clase Persona para guardar las personas.
• Crea 3 paquetes: uno para los métodos y clases de la interfaz gráfica Swing, otro para la clase
Persona, y otro para la lógica (validaciones, manejo de listas...).
• El campo Nombre tendrá 10 caracteres como máximo, el campo Apellido tendrá 20
caracteres como máximo y el DNI debe ser correcto. En caso de que no se cumplan estas
condiciones, una ventana emergente (JOptionPane) nos avisará de nuestros errores. Si todo es
correcto, la persona se añadirá a una lista de personas
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ejercicio12Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Ejercicio12Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	}

}
