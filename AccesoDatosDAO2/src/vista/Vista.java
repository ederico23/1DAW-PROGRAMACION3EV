package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Vista extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout = new CardLayout();

	//paneles
	private PanelListado panelListado = new PanelListado();
	private PanelFormulario panelFormulario = new PanelFormulario();
	private PanelEditar panelEditar = new PanelEditar();

	
	/**
	 * Create the frame.
	 */
	public Vista() {

		//para que tenga un tamaño la ventana y se cierre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 505);

		//iniciar cardLayout y contenedor
//		cardLayout = new CardLayout();
		contentPane = new JPanel(cardLayout);
		setContentPane(contentPane);

		//añadir paneles
		contentPane.add(panelListado, "listado");
		contentPane.add(panelFormulario, "formulario");
		contentPane.add(panelEditar, "editar");
		
		cardLayout.show(contentPane, "listado");
		
	}//fin constructor

	//CAMBIAR PANELES
	public void mostrarListado() {
		cardLayout.show(contentPane, "listado");
	}//fin mostrarListado()

	public void mostrarAdd() {
		cardLayout.show(contentPane, "formulario");
	}//fin mostrarAdd()

	public void mostrarEditar() {
		cardLayout.show(contentPane, "editar");
	}//fin mostrarEditar()

	public PanelListado getPanelListado() {
		return panelListado;
	}//fin getPanelListado

	/**
	 * @return the panelFormulario
	 */
	public PanelFormulario getPanelFormulario() {
		return panelFormulario;
	}

	/**
	 * @param panelFormulario the panelFormulario to set
	 */
	public void setPanelFormulario(PanelFormulario panelFormulario) {
		this.panelFormulario = panelFormulario;
	}

	/**
	 * @return the panelEditar
	 */
	public PanelEditar getPanelEditar() {
		return panelEditar;
	}

	/**
	 * @param panelEditar the panelEditar to set
	 */
	public void setPanelEditar(PanelEditar panelEditar) {
		this.panelEditar = panelEditar;
	}
}//fin class

