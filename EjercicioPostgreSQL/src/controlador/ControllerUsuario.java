package controlador;

import dao.UsuarioDAO;
import vista.Vista;

public class ControllerUsuario {

	private Vista v;
	private UsuarioDAO dao;
	/**
	 * @param v
	 * @param dao
	 */
	public ControllerUsuario(Vista v, UsuarioDAO dao) {
		this.v = v;
		this.dao = dao;
		iniciar();
	}//fin ControllerUsuario()
	
	public void iniciar() {
		//MOSTRAR USUARIOS
		try {
			v.mostrarUsuarios(dao.listarUsuarios());
		} catch (Exception e) {
			v.mostrarError("Error");
		}//fin try catch
		
		//LISTENERS
		v.setListenerFiltrarLetra(e->{
			try {
				v.limpiarTabla();
				v.mostrarUsuarios(dao.filtrarInicial(v.filtrarPorInicial()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});//fin listenerFiltrarLetras
		
		//v.setLis
		
	}//fin iniciar()
	
	
	
	
}//fin class
