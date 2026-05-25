package vista;

/**
 * Ejercicio 2
 * @author Eder Gracia 25/05/26
 */

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.VideoJuego;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo;
	private JButton  btnBorrar, btnFiltrarPlataforma, btnGuardar;
	private JTable table;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//crear tablamodelo
		modelo = new DefaultTableModel();
		//añadir a modelo
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Plataforma");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		modelo.addColumn("Genero");
		contentPane.setLayout(null);

		//crear table segun modelo
		table = new JTable(modelo);

		//meter en el panel la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 380, 301);
		contentPane.add(scrollPane);
		
		btnGuardar = new JButton("Guardar Videojuego");
		btnGuardar.setBounds(429, 222, 151, 23);
		contentPane.add(btnGuardar);

		btnFiltrarPlataforma = new JButton("Filtrar por provincia");
		btnFiltrarPlataforma.setBounds(429, 155, 151, 22);
		contentPane.add(btnFiltrarPlataforma);

		comboBox = new JComboBox();
		comboBox.setBounds(429, 55, 151, 22);
		contentPane.add(comboBox);
		

	}//fin Vista()

	public void mostrarVideojuegos(List<VideoJuego> videojuego) {	
		for(VideoJuego v: videojuego) {
			modelo.addRow(new Object[] {
					v.getId(),
					v.getNombre(),
					v.getPlataforma(),
					v.getPrecio(),
					v.getStock(),
					v.getGenero()
			});			
		}//fin for	
	}//fin mostrarVideojuegos()
	
	public void vaciarCombo() {
		comboBox.removeAllItems();
	}//fin vaciarCombo()
	
	public void cargarPlataformas(String[] plataformas) {
		vaciarCombo();
		for (int i = 0; i < plataformas.length; i++) {
			comboBox.addItem(plataformas[i]);
		}
	}//fin cargarPlataformas()
	
	public void limpiarTabla() {
		modelo.setRowCount(0);
	}//fin limpiarTabla()

	
	public Object plataformaSeleccionada() {
		return comboBox.getSelectedItem();
	}//fin plataformaSeleccionada()
	
	public void setListenerGuardar(ActionListener l) {
		btnGuardar.addActionListener(l);
	}

	public void setListenerBorrar(ActionListener l) {
		btnBorrar.addActionListener(l);
	}
	
	public void setListenerFiltrarPlat(ActionListener l) {
		btnFiltrarPlataforma.addActionListener(l);
	}
	
	//MENSAJES
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}//fin mostrarError()

	public void mostrarMensajes(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.INFORMATION_MESSAGE);
	}//fin mostrarMensajes()
	
	public String mostrarPlataformas (String[] plataformas) {
		return (String) JOptionPane.showInputDialog(
				null, //centro pantalla 
				"Filtrar por plataforma",
				"Filtro",
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				plataformas, 
				plataformas[0]);
	}//fin mostrarProvincias
	
	public int getFilaSeleccionada() {
		return table.getSelectedRow();
	}//fin getFilaSeleccionada()
	
	public Object getValorSeleccionado() {
		return modelo.getValueAt(getFilaSeleccionada(), 0);
	}//fin getValorSeleccionado()

	public void borrarFila(int fila) {
		modelo.removeRow(fila);
	}//fin borrarFila()

	public void irFormulario() {
		VistaFormulario ViewNuevo = new VistaFormulario();
		ViewNuevo.setVisible(true);
	}
	
}//fin class Vista
