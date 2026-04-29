package controlador;

import java.util.List;

import dao.UsuarioDAO;
import modelo.Usuario;
import vista.PanelListado;

public class UsuarioController {

	private PanelListado pl = new PanelListado();;
	private UsuarioDAO dao = new UsuarioDAO();

	/**
	 * @param pl
	 * @param dao
	 */
	public UsuarioController(PanelListado pl, UsuarioDAO dao) {
		this.pl = pl;
		this.dao = dao;
		iniciar();
	}


	private void iniciar() {
		//MOSTRAR DATOS
		try {
			pl.mostrarUsuarios(dao.listar());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//AÑADIR
		pl.setListenerAdd(e->{

		});	

		//EDITAR
		pl.setListenerMod(e->{

		});

		//BORRAR
		pl.setListenerDel(e->{

		});

	}//fin iniciar()


	public void añadir(Usuario u) {

	}//fin añadir()

	public void editar(Usuario u) {

	}//fin editar()


	public void eliminar(int id) {

	}//fin eliminar()



}//fin class
