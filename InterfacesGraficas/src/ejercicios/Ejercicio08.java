package ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ejercicio08 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Ejercicio08() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//primera ventana
		String nombre = JOptionPane.showInputDialog(
				null, //centro pantalla
				"Dime tu nombre", //texto
				"Titulo",//titulo ventana
				JOptionPane.QUESTION_MESSAGE); //icono
		
		//si el nombre es valido, pasamos a la siguiente ventana
		if(nombre!= null && !nombre.trim().isEmpty()) {
			
			//Array de colores para las opciones del menu
			String[] colores = {"Verde", "Azul", "Rojo"};
			
			//Creamos la ventana
			String colorElegido = (String) JOptionPane.showInputDialog(
					null, //centro pantalla 
					"Elige tu color favorito de los 3",
					"Titulo opciones",
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					colores, 
					colores[0]);
			
			
			//tercera ventana 
			if(colorElegido != null) {
				String mensajeFinal = "Te llamas " + nombre + " y tu color es " + colorElegido;
				JOptionPane.showMessageDialog(
						null, //centro
						mensajeFinal,  //mensaje 
						"Informacion resumida", //titulo
						JOptionPane.INFORMATION_MESSAGE); //icono
				
			}//fin if color elegido valido
			
		} else {
			JOptionPane.showMessageDialog(null, "No has introducido un nombre valido", "Error", JOptionPane.ERROR_MESSAGE);
		}//fin if nombre valido
		
		System.exit(0);
		
		
	}//fin constructor

}//finclass

