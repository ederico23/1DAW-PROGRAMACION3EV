package controlador;

import vista.VistaIniciarSesion;
import vista.VistaRegistrarse;

public class ControllerVistaPrincipal {

	//REGISTRARSE
	public static void registrarse() {
		VistaRegistrarse ViewSignUp = new VistaRegistrarse();
		ViewSignUp.setVisible(true);
	}//fin registrarse()
	
	//INCIAR SESION
	public static void iniciarSesion() {
		VistaIniciarSesion ViewLogIn = new VistaIniciarSesion();
		ViewLogIn.setVisible(true);
	}//fin iniciarSesion()
	
}//fin class
