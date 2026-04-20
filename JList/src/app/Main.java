package app;

import java.awt.EventQueue;

import controlador.Controller;
import vista.VistaListaPersonas;

public class Main {
	public static void main(String[] args) {

		VistaListaPersonas vista = new VistaListaPersonas();
		vista.setVisible(true);
		Controller controlador = new Controller();
	}
}
