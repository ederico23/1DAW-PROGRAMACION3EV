package vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelRojo extends JPanel{

	private JButton btnAzul = new JButton();
	private JButton btnVerde = new JButton();
	
	public PanelRojo() {
		setBackground(new Color(255,0,0));
		setLayout(null);
		
		btnAzul = new JButton("Azul");
		btnAzul.setBounds(31, 132, 89, 23);
		add(btnAzul);
		btnAzul.setActionCommand("azul");
		
		btnVerde = new JButton("Verde");
		btnVerde.setBounds(159, 132, 89, 23);
		add(btnVerde);
		btnVerde.setActionCommand("verde");
		
		
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
