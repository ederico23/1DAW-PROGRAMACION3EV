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

	private JPanel contenedorMain;
	private CardLayout cardLayout;

	//paneles
	private JPanel panelListado;
	private PanelAdd panelAdd;
	private PanelEditar panelEditar;

	//botones
	private JButton btnAdd, btnEditar, btnBorrar;
	private JTable tabla;
	private DefaultTableModel modeloTabla;


	/**
	 * Create the frame.
	 */
	public Vista() {
		
		//para que tenga un tamaño la ventana y se cierre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);

		//iniciar cardLayout y contenedor
		cardLayout = new CardLayout();
		contenedorMain = new JPanel(cardLayout);
		setContentPane(contenedorMain);

		//panel listado (tabla+ botones)
		panelListado = new JPanel();
		panelListado.setLayout(null);

		//crear tablamodelo
		modeloTabla = new DefaultTableModel();
		//añadir al modelo
		modeloTabla.addColumn("Id");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Edad");
		//creamos la tabla segun el modelo
		tabla = new JTable(modeloTabla);

		//meter en el panel, la tabla
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 10, 300, 300);
		panelListado.add(scrollPane);

		//BTN
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(297, 43, 89, 23);
		panelListado.add(btnAdd);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(297, 122, 89, 23);
		panelListado.add(btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(297, 203, 89, 23);
		panelListado.add(btnBorrar);

		//inicializar paneles
		panelAdd = new PanelAdd();
		panelEditar = new PanelEditar();

		//añadir paneles
		contenedorMain.add(panelListado, "listado");
		contenedorMain.add(panelAdd, "add");
		contenedorMain.add(panelEditar, "editar");

	}//fin constructor

	//LISTENERS
	public void setListenerAdd (ActionListener l) {
		btnAdd.addActionListener(l);
	}//fin setListenerAdd

	public void setListenerMod (ActionListener l) {
		btnEditar.addActionListener(l);
	}//fin setListenerMod

	public void setListenerDel (ActionListener l) {
		btnBorrar.addActionListener(l);
	}//fin setListenerDel


	//CAMBIAR PANELES
	public void mostrarListado() {
		cardLayout.show(contenedorMain, "listado");
	}//fin mostrarListado()

	public void mostrarAdd() {
		cardLayout.show(contenedorMain, "add");
	}//fin mostrarAdd()

	public void mostrarEditar() {
		cardLayout.show(contenedorMain, "editar");
	}//fin mostrarEditar()

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}//fin getModeloTabla()

	public JTable getTabla() {
		return tabla;
	}//fin getTabla()
}//fin class

