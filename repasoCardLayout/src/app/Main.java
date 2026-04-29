package app;

import controlador.Controller;
import vista.Vista;

public class Main {
	public static void main(String[] args) {
		Vista frame = new Vista();
		frame.setVisible(true);
		Controller c = new Controller(frame);
	}
}
