package controlador;

import javax.swing.JFrame;

import vista.VistaIniciarSesion;
import vista.VistaRegistrarse;

public class ControllerVistaPrincipal {

	//REGISTRARSE
	public static void registrarse(JFrame ventanaActual) {
		VistaRegistrarse ViewSignUp = new VistaRegistrarse();
		ViewSignUp.setVisible(true);
		ventanaActual.dispose(); //cierra la ventana
	}//fin registrarse()
	
	//INCIAR SESION
	public static void iniciarSesion(JFrame ventanaActual) {
		VistaIniciarSesion ViewLogIn = new VistaIniciarSesion();
		ViewLogIn.setVisible(true);
		ventanaActual.dispose();
	}//fin iniciarSesion()
	
}//fin class
