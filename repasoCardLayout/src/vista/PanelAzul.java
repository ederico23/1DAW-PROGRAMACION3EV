package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelAzul extends JPanel{

	private JButton btnRojo = new JButton();
	private JButton btnVerde = new JButton();
	
	public PanelAzul() {
		setBackground(new Color(0,0,255));
		
		btnRojo = new JButton("Rojo");
		btnRojo.setBounds(31, 132, 89, 23);
		add(btnRojo);
		btnRojo.setActionCommand("rojo");
		
		btnVerde = new JButton("Verde");
		btnVerde.setBounds(159, 132, 89, 23);
		add(btnVerde);
		btnVerde.setActionCommand("verde");
	}//fin constructor

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

	/**
	 * @return the btnVerde
	 */
	public JButton getBtnVerde() {
		return btnVerde;
	}

	/**
	 * @param btnVerde the btnVerde to set
	 */
	public void setBtnVerde(JButton btnVerde) {
		this.btnVerde = btnVerde;
	}
	
	
	
} //fin class
