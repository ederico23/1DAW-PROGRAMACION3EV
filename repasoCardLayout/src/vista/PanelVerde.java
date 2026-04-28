package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelVerde extends JPanel{

	private JButton btnAzul = new JButton();
	private JButton btnRojo = new JButton();
	
	public PanelVerde() {
		setBackground(new Color(0,255,0));
		
		btnAzul = new JButton("Azul");
		btnAzul.setBounds(31, 132, 89, 23);
		add(btnAzul);
		btnAzul.setActionCommand("azul");
		
		btnRojo = new JButton("Rojo");
		btnRojo.setBounds(159, 132, 89, 23);
		add(btnRojo);
		btnRojo.setActionCommand("rojo");
	}//fin constructor

	/**
	 * @return the btnAzul
	 */
	public JButton getBtnAzul() {
		return btnAzul;
	}

	/**
	 * @param btnAzul the btnAzul to set
	 */
	public void setBtnAzul(JButton btnAzul) {
		this.btnAzul = btnAzul;
	}

	/**
	 * @return the btnRojo
	 */
	public JButton getBtnRojo() {
		return btnRojo;
	}

	/**
	 * @param btnRojo the btnRojo to set
	 */
	public void setBtnRojo(JButton btnRojo) {
		this.btnRojo = btnRojo;
	}
	
	
} //fin class
