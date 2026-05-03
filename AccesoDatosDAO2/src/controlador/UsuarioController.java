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
			e.printStackTrace();  //mostrarmensaje ERROR
		}//fin trycatch

		//PANELISTADO
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
		////////////////////////////////////////////////////////
		//PANEL FORMULARIO
		//GUARDAR
		guardar();

		//VOLVER
		volver();
		////////////////////////////////////////////////////////
	}//fin iniciar()

	public void volver() {
		PanelFormulario pf = v.getPanelFormulario();
		pf.setACtionListenerVolver(e->{
			v.mostrarListado();
		});
	}//fin volver()

	//PANELFORMULARIO
	public void guardar() {
		PanelFormulario pf = v.getPanelFormulario();
		pf.setActionListenerGuardar(e->{
			String nombre = pf.getNombre();
			Integer edad = Integer.parseInt(pf.getEdad());

			Usuario usuario = new Usuario(nombre, edad);
			try {
				dao.insertar(usuario);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); //mostrarmensaje ERROR
			}//fin trycatch

			pl.vaciarTabla();
			try {
				pl.mostrarUsuarios(dao.listar());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			v.mostrarListado();
		});
	}//fin guardar()


}//fin class
