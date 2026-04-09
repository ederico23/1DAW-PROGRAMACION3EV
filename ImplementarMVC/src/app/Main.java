package app;

import controlador.ControladorAlumno;
import vista.VistaAlumno;

public class Main {
	public static void main(String[] args) {
		VistaAlumno vista = new VistaAlumno();
		vista.setVisible(true);
		ControladorAlumno c = new ControladorAlumno(vista);
	}
}
