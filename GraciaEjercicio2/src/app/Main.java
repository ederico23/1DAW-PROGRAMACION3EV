package app;

import java.awt.EventQueue;

import controlador.ControladorVideoJuego;
import dao.VideojuegoDAO;
import vista.Vista;

/**
 * Ejercicio 2
 * @author Eder Gracia 25/05/26
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
					//controlador
					VideojuegoDAO dao = new VideojuegoDAO();
//					dao.crearTabla();
//					System.out.println("creada");
//					dao.insertarVideojuegosPrueba();
//					System.out.println("insertados");
					ControladorVideoJuego cvj = new ControladorVideoJuego(frame, dao);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}//fin class Main
