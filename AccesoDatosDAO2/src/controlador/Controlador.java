package controlador;

import dao.UsuarioDAO;
import modeloTabla.Usuario;
import vista.Vista;

public class Controlador {

	private Vista v;
	private UsuarioDAO dao;
	
	public Controlador(Vista v, UsuarioDAO dao) {
		this.v = v;
		this.dao = dao;
		
		inicializarListeners();
	}//fin Controlador()
	
	private void inicializarListeners() {
		//AÑADIR
		v.setListenerAdd(e->{
			
		});	
		
		//EDITAR
		v.setListenerMod(e->{
			
		});
		
		//BORRAR
		v.setListenerDel(e->{
			
		});
	}//fin inicializarListeners()

	public void listar() {
				
	}//fin listar()

	public void añadir(Usuario u) {
		
	}//fin añadir()
	
	public void editar(Usuario u) {
		
	}//fin editar()
	
	
	public void eliminar(int id) {
		
	}//fin eliminar()
	
	
	
}//fin class
