package app;

import controlador.UsuarioController;
import dao.UsuarioDAO;
import vista.PanelListado;
import vista.Vista;

public class Main {
	
	public static void main(String[] args) {
		PanelListado pl = new PanelListado();
		UsuarioDAO dao = new UsuarioDAO();
		//Vista v = 
		UsuarioController c = new UsuarioController(pl, dao);
		
	}
}
