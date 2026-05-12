package main;

import controlador.ControladorNumero;
import vista.Vista;

public class Main {

	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(true);
		ControladorNumero c = new ControladorNumero(v);
	}

}
