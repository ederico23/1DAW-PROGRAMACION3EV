package app;

import java.awt.EventQueue;

import controlador.ControllerUsuario;
import dao.UsuarioDAO;
import vista.Vista;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista v = new Vista();
					UsuarioDAO dao = new UsuarioDAO();
					ControllerUsuario c = new ControllerUsuario(v, dao);
					v.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}//fin main

}//fin main
