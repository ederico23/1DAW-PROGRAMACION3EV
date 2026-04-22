package controlador;

import java.awt.event.ActionListener;

import modelo.ModeloDiccionario;
import vista.Vista;

public class Controller {
	Vista vista = new Vista();
	ModeloDiccionario modelo = new ModeloDiccionario();
	
	/**
	 * @param vista
	 * @param modelo
	 */
	public Controller(Vista vista, ModeloDiccionario modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		vista.setListenerTraducir(traducir());
	}

	private ActionListener traducir() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}//fin class
