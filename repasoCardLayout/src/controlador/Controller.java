package controlador;

import vista.Vista;

public class Controller {
	
	private Vista v = new Vista();
	
	public Controller(Vista v) {
		this.v = v;
		
		//activar listeners
//		v.setListenerAzul(e-> v.mostrarContenedor("azul"));
//		v.setListenerRojo(e-> v.mostrarContenedor("rojo"));
//		v.setListenerVerde(e-> v.mostrarContenedor("verde"));
		
		v.setLitener(e-> {
			v.mostrarContenedor(e.getActionCommand());
		});
	}//fin constructor
	
	
	
}
