package app;

import controlador.ControllerVehiculo;
import dao.VehiculoDAO;
import vista.Vista;

public class Main {
	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(true);
		VehiculoDAO dao = new VehiculoDAO();
		ControllerVehiculo c = new ControllerVehiculo(v, dao);
		try {
			v.mostrarVehiculos(dao.listar());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//fin main
}//fin class
