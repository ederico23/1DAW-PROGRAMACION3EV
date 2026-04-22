package controlador;

import javax.swing.JButton;

import vista.Vista;

public class CalculadoraController {

	private Vista vista;

	/**
	 * @param vista
	 */
	public CalculadoraController(Vista vista) {
		this.vista = vista;
		
		for(JButton botonesNums : vista.getBotonesNumeros()) {
			botonesNums.addActionListener(e->{
				String numeroPulsado = vista.getNums();
				
			});
		}//fin for
		
	}//fin controlador
	
	
	
}//fin class
