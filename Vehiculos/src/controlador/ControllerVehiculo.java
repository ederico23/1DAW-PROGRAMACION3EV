package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.swing.JOptionPane;

import dao.VehiculoDAO;
import modelo.Vehiculo;
import vista.Vista;

public class ControllerVehiculo {

	private Vista v;
	private VehiculoDAO dao;
	private Path path;


	/**
	 * @param v
	 * @param dao
	 */
	public ControllerVehiculo(Vista v, VehiculoDAO dao) {
		this.v = v;
		this.dao = dao;
		iniciar();
	}//fin construrctor

	public void iniciar() {

		//LISTENER DEL BOTON GUARDAR
		v.setListenerGuardar(e->{
			guardarEnFichero();
		});//fin listenerGuardar

		v.setListenerFiltrarKm(e->{
			filtrarKMS();
		});//fin listenerFiltrar

		v.setListenerBorrar(e->{
			borrar();
		});//fin listenerBorrar

		v.setListenerVolver(e->{

			v.limpiarTabla();

			try {
				v.mostrarVehiculos(dao.listar());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				v.mostrarError("Error");
			}
		});//fin listenerVolver

		v.setListenerFiltrarProv(e->{
			filtrarProvincias();
		});//fin listenerFiltrarProv

		v.setListenerLeer(e->{
			leerFichero();
		});//fin listenerLeer
	}//fin iniciar()

	public void guardarEnFichero() {
		path = Path.of("vehiculos.txt");

		if(!Files.exists(path)) {
			v.mostrarError("Archivo no encontrado");
			return;
		}//fin if

		try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING)){

			List<Vehiculo> vehiculos = dao.listar();

			for (Vehiculo ve : vehiculos) {
				bw.write(ve.getMarca() + ";" + ve.getVehiculo() + ";" + ve.getProvincia() + ";" + ve.getMatricula() + ";" + ve.getKm());
				bw.newLine();
				bw.flush();//vaciar el buffer y "acabar la tarea"
			}//fin for

			v.mostrarMensajes("Archivo guardado");

		} catch (Exception ex) {
			v.mostrarError("Error");
		}//fin trycatch

	}//fin guardarEnFichero()

	public void borrar() {

		if(v.getFilaSeleccionada() == -1) {
			v.mostrarError("Selecciona una fila");
			return;
		}//fin if

		try {
			dao.borrarVehiculo((String)v.getValorSeleccionado());
			v.borrarFila(v.getFilaSeleccionada());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			v.mostrarError("Error");
		}//fin trycatch

	}//fin borrar()

	public void filtrarKMS() {

		String respuesta = JOptionPane.showInputDialog(v, "Filtrar por KM", "Filtro" , JOptionPane.QUESTION_MESSAGE);

		if(respuesta == null ||respuesta.isEmpty()) {
			return;
		}//fin if 

		Integer km = Integer.parseInt(respuesta); 

		v.limpiarTabla();

		try {
			v.mostrarVehiculos(dao.filtrarKm(km));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //fin trycatch
	}//fin filtrarKMS()

	public void filtrarProvincias() {
		List<String> provs;
		String[] provincias;
		try {
			provs = dao.getProvincias();
			provincias = provs.toArray(new String[0]);

			String respuesta = v.mostrarProvincias(provincias);

			if(respuesta == null ||respuesta.isEmpty()) {
				return;
			}//fin if 

			v.limpiarTabla();
			v.mostrarVehiculos(dao.filtrarProvincia(respuesta));			

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			v.mostrarError("Error");
		}//fin trycatch
	}//fin filtrarProvincias()

	public void leerFichero() {
		path = Path.of("datosNuevos.txt");

		if(!Files.exists(path)) {
			v.mostrarError("Archivo no encontrado");
			return;
		}//fin if

		try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
			String linea;
			boolean salir = false;
			while ((linea = br.readLine()) != null) {
				//creamos array para separar los valores de la linea del fichero
				//y coger cada valor, modelo, matricula,...
				String[] coche = linea.split(";");
				//creamos un vehiculo nuevo por cada linea que leamos
				Vehiculo vehiculo = 
						new Vehiculo(coche[0], coche[1], coche[2], coche[3], Integer.parseInt(coche[4]));
				//la insertamos		
				dao.insertar(vehiculo);
				
			}//fin while
			v.limpiarTabla();
			v.mostrarVehiculos(dao.listar());

		} catch (Exception ex) {
			v.mostrarError("No hay datos nuevos");
			ex.printStackTrace();
		}//fin trycatch

	}//fin leerFichero()

}//fin class
