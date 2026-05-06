package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modelo.Vehiculo;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo;
	private JButton btnGuardar;
	private JButton btnFiltrarKM, btnBorrar, btnVolver, btnFiltrarProv, btnLeer;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//crear tablamodelo
		modelo = new DefaultTableModel();
		//añadir a modelo
		modelo.addColumn("marca");
		modelo.addColumn("vehiculo");
		modelo.addColumn("provincia");
		modelo.addColumn("matricula");
		modelo.addColumn("km");
		contentPane.setLayout(null);

		//crear table segun modelo
		table = new JTable(modelo);

		//meter en el panel la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 380, 275);
		contentPane.add(scrollPane);
		
		btnGuardar = new JButton("Guardar en fichero");
		btnGuardar.setBounds(429, 144, 151, 23);
		contentPane.add(btnGuardar);
		
		btnFiltrarKM = new JButton("Filtrar por KM");
		btnFiltrarKM.setBounds(429, 8, 151, 22);
		contentPane.add(btnFiltrarKM);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(429, 94, 151, 23);
		contentPane.add(btnBorrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(429, 245, 151, 22);
		contentPane.add(btnVolver);
		
		btnFiltrarProv = new JButton("Filtrar por provincia");
		btnFiltrarProv.setBounds(429, 50, 151, 22);
		contentPane.add(btnFiltrarProv);
		
		btnLeer = new JButton("Leer fichero");
		btnLeer.setBounds(429, 196, 151, 23);
		contentPane.add(btnLeer);
		
	}//fin constructor

	public void mostrarVehiculos(List<Vehiculo> Vehiculo) {	
		for(Vehiculo v: Vehiculo) {
			modelo.addRow(new Object[] {
					v.getMarca(),
					v.getVehiculo(),
					v.getProvincia(),
					v.getMatricula(),
					v.getKm()
			});			
		}//fin for	
	}//fin mostrarVehiculos()
	
	//LISTENERS
	public void setListenerGuardar(ActionListener l) {
		btnGuardar.addActionListener(l);
	}//fin setActionListenerGuardar()
	
	public void setListenerFiltrarKm(ActionListener l) {
		btnFiltrarKM.addActionListener(l);
	}//fin setActionListenerFiltrarKM()
	
	public void setListenerBorrar(ActionListener l) {
		btnBorrar.addActionListener(l);
	}//fin setListenerBorrar()

	public void setListenerVolver(ActionListener l) {
		btnVolver.addActionListener(l);
	}//fin setListenerBorrar()
	
	public void setListenerFiltrarProv(ActionListener l) {
		btnFiltrarProv.addActionListener(l);
	}//fin setListenerFiltrarProv()
	
	public void setListenerLeer(ActionListener l) {
		btnLeer.addActionListener(l);
	}//fin setListenerLeer()
	
	//MENSAJES
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}//fin mostrarError()

	public void mostrarMensajes(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.INFORMATION_MESSAGE);
	}//fin mostrarMensajes()
	
	public String mostrarProvincias (String[] provincias) {
		return (String) JOptionPane.showInputDialog(
				null, //centro pantalla 
				"Filtrar por ciudad",
				"Filtro",
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				provincias, 
				provincias[0]);
	}//fin mostrarProvincias
	
	//TABLAS
	public void limpiarTabla() {
		modelo.setRowCount(0);
	}//fin limpiarTabla()

	public int getFilaSeleccionada() {
		return table.getSelectedRow();
	}//fin getFilaSeleccionada()
	
	public Object getValorSeleccionado() {
		return modelo.getValueAt(getFilaSeleccionada(), 3);
	}//fin getValorSeleccionado()

	public void borrarFila(int fila) {
		modelo.removeRow(fila);
	}//fin borrarFila()
}//fin class
