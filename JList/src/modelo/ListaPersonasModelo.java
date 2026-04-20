package modelo;

import javax.swing.DefaultListModel;

public class ListaPersonasModelo {

	private DefaultListModel<Persona> modelo;

	/**
	 * @param modelo
	 */
	public ListaPersonasModelo() {
		modelo = new DefaultListModel<Persona>();
	}
	
	public DefaultListModel<Persona> getModelo(){
		return modelo;
	}
	
	public void agregarPersonas(Persona p) {
		modelo.addElement(p);
	}
	
	public void eliminarPersona(int indicePersona) {
		if(indicePersona >= 0 && indicePersona < modelo.size()) {
			
		modelo.remove(indicePersona);
		}	
	}
	
	public void actualizarPersona(int indicePersona, Persona p) {
		if(indicePersona >= 0 && indicePersona < modelo.size()) {
			modelo.set(indicePersona, p);
			}
	}
}//fin class
