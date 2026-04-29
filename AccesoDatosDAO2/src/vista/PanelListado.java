package vista;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Usuario;

public class PanelListado extends JPanel{

	//paneles
//	private CardLayout cardLayout;
	private JPanel panelListado;
	private PanelListado panelAdd;
	private PanelEditar panelEditar;
	
	//botones
	private JButton btnAdd, btnEditar, btnBorrar;
	private JTable tabla;
	private DefaultTableModel modeloTabla;

	public PanelListado() {
		//panel listado (tabla+ botones)
//		panelListado = new JPanel();


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
		add(scrollPane);

		//BTN
		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(359, 42, 89, 23);
		add(btnAdd);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(359, 121, 89, 23);
		add(btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(359, 205, 89, 23);
		add(btnBorrar);

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
	
		public void getFilaSeleccionada() {
			tabla.getSelectedRow();
		}//fin getFilaSeleccionada
		
		public void getValor(int fila, int columna) {
			fila = tabla.getSelectedColumn();
			columna = tabla.getSelectedRow();
		}//fin getValor()
		

		public void mostrarUsuarios(List<Usuario> usuarios) {
			
			for(Usuario u : usuarios) {
				
				modeloTabla.addRow(new Object[] {
						u.getId(),
						u.getNombre(),
						u.getEdad()
				});
				
			}
			
		}//fin mostrarUsuarios()
}//fin class
