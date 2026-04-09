package controlador;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Alumno;
import vista.VistaAlumno;

public class ControladorAlumno {

	private VistaAlumno vista;
	private ArrayList<Alumno> listaAlumnos = new ArrayList<>();
	
	public ControladorAlumno(VistaAlumno vista) {
		this.vista = vista;
		vista.agregarListenerAceptar(e-> aceptar());
		vista.agregarListenerBorrar(e-> borrarLista());
	}//fin controlador

	/**
	 * Accion al presionar el boton "Aceptar"
	 * @return
	 */
	private void aceptar() {
		try {
		String nombre = vista.getNombre();
		Integer edad = Integer.parseInt(vista.getEdad());
		Alumno a = new Alumno(nombre,edad);
		listaAlumnos.add(a);
		vista.limpiarDatos();
		actualizarLista();
				
		} catch (Exception ex) {
			vista.mostrarMensaje("La edad debe ser un numero entero");
			vista.limpiarDatos();
		}//fin trycatch
	}//fin aceptar()

	
	private void actualizarLista() {
		String resultado = "";
		for (Alumno a : listaAlumnos) {
			resultado = resultado + a + "\n";
		}//fin for
		vista.actualizarLista(resultado);
	}//fin actualizarLista
	
	private void borrarLista() {
		listaAlumnos.clear();
		vista.actualizarLista("");
	}//fin borrarLista
	
}//fin class
