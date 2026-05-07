package app;

import controlador.ControllerPelicula;
import dao.CrearBBDD;
import vista.Vista;

public class Main {

	public static void main(String[] args) {
		
		Vista v = new Vista();
		v.setVisible(true);
		ControllerPelicula c = new ControllerPelicula(v);

	}//fin main

}//fin class
