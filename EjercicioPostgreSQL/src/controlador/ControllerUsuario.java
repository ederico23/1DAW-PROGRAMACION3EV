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
		});//fin listenerFiltrarInicial
		
		v.setListenerFiltrarMail(e->{
			v.limpiarTabla();
			try {
				v.mostrarUsuarios(dao.filtrarEmail(v.filtrarPorMail()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});//fin listenerFiltrarMail
		
		v.setListenerBorrar(e->{
			borrar();
		});//fin listenerBorrar
		
		v.setListenerVolver(e->{
			v.limpiarTabla();
			try {
				v.mostrarUsuarios(dao.listarUsuarios());
			} catch (Exception e1) {
				v.mostrarError("Error");
			}
		});//fin listenerVolver
		
	}//fin iniciar()

	public void borrar() {

		if(v.getFilaSeleccionada() == -1) {
			v.mostrarError("Selecciona una fila");
			return;
		}//fin if
		
		try {
			dao.borrarUsuario((int) v.getValorSeleccionado());
		} catch (Exception ex) {
			v.mostrarError("Error");
		}
		

	}//fin borrar()
	
	
	
}//fin class
