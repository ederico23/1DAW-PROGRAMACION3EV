package vista;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Vista extends JFrame {
	
	private JPanel panel = new JPanel();
	private CardLayout cardLayout = new CardLayout();
	private PanelRojo panelRojo = new PanelRojo();
	private PanelAzul panelAzul = new PanelAzul();
	private PanelVerde panelVerde = new PanelVerde();
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		panel = new JPanel(cardLayout);
		add(panel);
		panel.add(panelRojo, "rojo");
		panel.add(panelAzul, "azul");
		panel.add(panelVerde, "verde");
		
		cardLayout.show(panel,"verde");
	}//fin constructor

	
	public void mostrarContenedor(String contenedor) {
		
		cardLayout.show(panel, contenedor);
		
	}//fin mostrarContenedor
	
	public void setLitener(ActionListener l) {
		//panel azul
		panelAzul.getBtnRojo().addActionListener(l);
		panelAzul.getBtnVerde().addActionListener(l);
		
		//panel rojo
		panelRojo.getBtnAzul().addActionListener(l);
		panelRojo.getBtnVerde().addActionListener(l);
		
		//panel verde
		panelVerde.getBtnAzul().addActionListener(l);
		panelVerde.getBtnRojo().addActionListener(l);
	}
	
//	public void setListenerAzul(ActionListener l) {
//		panelRojo.getBtnAzul().addActionListener(l);
//		panelVerde.getBtnAzul().addActionListener(l);
//	}//fin setListenerAzul
//	
//	public void setListenerRojo(ActionListener l) {
//		panelVerde.getBtnRojo().addActionListener(l);
//		panelAzul.getBtnRojo().addActionListener(l);
//	}//fin setListenerRojo
//	
//	public void setListenerVerde(ActionListener l) {
//		panelRojo.getBtnVerde().addActionListener(l);
//		panelAzul.getBtnVerde().addActionListener(l);
//	}//fin setListenerVerde
}//fin class
