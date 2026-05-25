package controlador;

import java.util.ArrayList;
import java.util.List;

import dao.VideojuegoDAO;
import modelo.VideoJuego;
import vista.Vista;
import vista.VistaFormulario;

/**
 * Ejercicio 2
 * @author Eder Gracia 25/05/26
 */

public class ControladorVideoJuego {
	private Vista v;
	private VideojuegoDAO dao;
	private VistaFormulario vf;
	
	/**
	 * Constructor
	 * @param v
	 * @param dao
	 */
	public ControladorVideoJuego(Vista v, VideojuegoDAO dao) {
		this.v = v;
		this.dao = dao;
		iniciar();
	}//fin ControladorVideoJuego()

	public void iniciar() {
		try {
			System.out.println("hola");
			v.mostrarVideojuegos(dao.listarVideoJuegos());
		} catch (Exception e) {
			v.mostrarError("Error al cargar los videojuegos");
		}
		
		v.setListenerGuardar(e->{
			v.irFormulario();
			guardarVideojuego();
		});
	}//fin iniciar()
	
	//GUARDAR DATOS NUEVOS
	public void comprobarDatos() {
		String nombre = vf.getNombre();
		String plataforma = vf.getPlataforma();
		String genero = vf.getGenero();
		
		if (nombre.isEmpty() || plataforma.isEmpty() || genero.isEmpty()
				|| vf.getPrecio().isEmpty() || vf.getStock().isEmpty()) {
			v.mostrarError("Complete todos los campos");	
			System.exit(0);
		}
		Double precio = Double.parseDouble(vf.getPrecio());
		Integer stock = Integer.parseInt(vf.getStock());
		
		if(precio < 0 || stock < 0) {
			v.mostrarError("No puede haber valores negativos");
			System.exit(0);
		}
		
	}//fin comprobarDatos
	
	public void guardarVideojuego() {
		comprobarDatos();
		String nombre = vf.getNombre();
		String plataforma = vf.getPlataforma();
		String genero = vf.getGenero();
		Double precio = Double.parseDouble(vf.getPrecio());
		Integer stock = Integer.parseInt(vf.getStock());
		
		VideoJuego videojuegos = new VideoJuego(nombre, plataforma, precio, stock, genero);
		//videojuegos.add(null);
		try {
			dao.insertar(videojuegos);
			vf.irPrincipal();
		} catch (Exception ex) {
			v.mostrarError("Error al insertar videojuego");
		}
		
	}//fin guardarVideojuego
	
	public void filtrarPlataformas() {

		try {
			String respuesta = (String) v.plataformaSeleccionada();

			if(respuesta == null ||respuesta.isEmpty()) {
				return;
			}//fin if 

			v.limpiarTabla();
			v.mostrarVideojuegos(dao.listarPlataformas(respuesta));			

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			v.mostrarError("Error");
		}//fin trycatch
	}//fin filtrarProvincias()

	
	public void cargarPlataformas() {
		String[] plataformas;
		try {
			List<String> plats = dao.getPlataformas();
			plataformas = plats.toArray(new String[0]);
			v.cargarPlataformas(plataformas);
		} catch (Exception e1) {
			v.mostrarError("Error");
		}
	}
}//fin class ControladorVideoJuego
