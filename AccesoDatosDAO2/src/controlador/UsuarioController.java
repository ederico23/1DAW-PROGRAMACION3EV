package controlador;

import java.util.List;
import vista.Vista;
import dao.UsuarioDAO;
import modelo.Usuario;
import vista.PanelEditar;
import vista.PanelFormulario;
import vista.PanelListado;

public class UsuarioController {

	private PanelListado pl;
	private UsuarioDAO dao;
	private Vista v;
	
	/**
	 * @param pl
	 * @param dao
	 */
	public UsuarioController(PanelListado pl, UsuarioDAO dao, Vista v) {
		this.pl = pl;
		this.dao = dao;
		this.v = v;
		iniciar();
	}


	private void iniciar() {
		//MOSTRAR DATOS
		try {
			pl.mostrarUsuarios(dao.listar());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fin trycatch
		
		//AÑADIR
		pl.setListenerAdd(e->{
			v.mostrarAdd(); //mostramos el PanelFormulario
		});	

		//EDITAR
		pl.setListenerMod(e->{
			v.mostrarEditar(); //mostramos el PanelEditar
		});

		//BORRAR
		pl.setListenerDel(e->{
			
		});

	}//fin iniciar()

	//PANELFORMULARIO
	public void guardar() {
		PanelFormulario pf = new PanelFormulario();
		pf.setActionListenerGuardar(e->{
			String nombre = pf.getNombre();
			String edad = pf.getEdad();
			
			new Usuario(nombre, edad);
		});
	}


}//fin class
