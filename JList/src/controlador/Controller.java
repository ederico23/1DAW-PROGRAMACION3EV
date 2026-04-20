package controlador;

import modelo.ListaPersonasModelo;
import modelo.Persona;
import vista.VistaListaPersonas;

public class Controller {
	private ListaPersonasModelo modelo;
	private VistaListaPersonas vista;
	
	/**
	 * @param vista
	 * @param modelo
	 */
	public Controller() {
		modelo = new ListaPersonasModelo();
		vista = this.vista;
		iniciar(); //asigna listeners y el modelo
	}//fin constructor

	private void iniciar() {
		vista.setModelo(modelo.getModelo());
		vista.setListenerAdd(e-> {
			try {
			String nombre = vista.getNombre();
			String edad = vista.getEdad();
			modelo.agregarPersonas(new Persona(nombre, edad));
			} catch (Exception ex) {
				vista.mostrarMensaje("Datos erroneos");
			} finally {
				vista.limpiarCampos();
			}//fin trycatch
		});
		
	}//fin iniciar()
	
	
}//fin class
