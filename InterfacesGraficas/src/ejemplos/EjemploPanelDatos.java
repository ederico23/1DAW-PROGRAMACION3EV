package ejemplos;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class EjemploPanelDatos extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JTextField campoNombre = new JTextField();
	private JTextField campoCiudad = new JTextField();
	private JTextField campoEdad = new JTextField();

	
	/**
	 * Create the panel.
	 */
	public EjemploPanelDatos() {
		setLayout(new GridLayout(0,1));
		add(new Label("Nombre"));
		add(campoNombre);
		add(new Label("Edad"));
		add(campoEdad);
		add(new Label("Ciudad"));
		add(campoCiudad);
	}//fin constructor
	
	public void escribirDatos() {
		System.out.println("Nombre: " + campoNombre.getText());
		System.out.println("Edad: " + campoEdad.getText());
		System.out.println("Ciudad: " + campoCiudad.getText());
	}//fin escribirDatos()
	
	
}//fin class
