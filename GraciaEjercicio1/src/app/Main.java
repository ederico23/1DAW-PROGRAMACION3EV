package app;

import java.awt.EventQueue;

import controlador.ControladorAlumno;
import vista.Vista;

/**
 * Ejercicio 1
 * @author Eder Gracia Carmona 25/05/26
 */

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					ControladorAlumno c = new ControladorAlumno(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//fin main

}//fin class Main
