package controlador;

import dao.VehiculoDAO;
import vista.Vista;

public class ControllerVehiculo {

	private Vista v;
	private VehiculoDAO dao;

	/**
	 * @param v
	 * @param dao
	 */
	public ControllerVehiculo(Vista v, VehiculoDAO dao) {
		this.v = v;
		this.dao = dao;
	}//fin construrctor

	
	
	
}//fin class
