package controlador;

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
	
}//fin class
