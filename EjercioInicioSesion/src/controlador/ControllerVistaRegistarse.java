package controlador;

import javax.swing.JTextField;

import vista.VistaRegistrarse;

public class ControllerVistaRegistarse {
	
	static String nombre = vista.VistaRegistrarse.txtNombre.getText(); ;
	static char[] password = vista.VistaRegistrarse.fieldPassword.getPassword();
	
	public static boolean comprobarUsuario() {
		
		
		return true; //para que no salte error por ahora
		
	}//fin comprobarUsuario()
	
	

	public static boolean comprobarPassword() {
		
		
		return true; //para que no salte error por ahora
		
	}//fin comprobarPassword
	
	

	
}//fin class
