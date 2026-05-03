package app;

import controlador.UsuarioController;
import dao.UsuarioDAO;
import vista.PanelListado;
import vista.Vista;

public class Main {
	
	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(true);
		PanelListado pl = v.getPanelListado();  //tenia varios PanelListado creados. aqui volvia a crear uno que estaba vacio
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioController c = new UsuarioController(pl, dao, v);
	}
}
