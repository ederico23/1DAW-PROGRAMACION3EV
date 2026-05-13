package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Usuario;

public class Vista extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo;
	private JButton btnFiltrarLetra, btnBorrar, btnVolver, btnFiltrarMail, btnLeer;
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
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Email");
		
		contentPane.setLayout(null);

		//crear table segun modelo
		table = new JTable(modelo);

		//meter en el panel la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 380, 275);
		contentPane.add(scrollPane);
		
		btnFiltrarLetra = new JButton("Filtrar por inicial");
		btnFiltrarLetra.setBounds(429, 8, 151, 22);
		contentPane.add(btnFiltrarLetra);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(429, 94, 151, 23);
		contentPane.add(btnBorrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(429, 184, 151, 22);
		contentPane.add(btnVolver);
		
		btnFiltrarMail = new JButton("Filtrar por mail");
		btnFiltrarMail.setBounds(429, 50, 151, 22);
		contentPane.add(btnFiltrarMail);
		
	}//fin constructor
	
	public void mostrarUsuarios(List<Usuario> Usuario) {	
		for(Usuario v: Usuario) {
			modelo.addRow(new Object[] {
					v.getId(),
					v.getNombre(),
					v.getEmail()
			});			
		}//fin for	
	}//fin mostrarVehiculos()
	
	//LISTENERS
	
	public void setListenerFiltrarLetra(ActionListener l) {
		btnFiltrarLetra.addActionListener(l);
	}//fin setActionListenerFiltrarKM()
	
	public void setListenerBorrar(ActionListener l) {
		btnBorrar.addActionListener(l);
	}//fin setListenerBorrar()

	public void setListenerVolver(ActionListener l) {
		btnVolver.addActionListener(l);
	}//fin setListenerBorrar()
	
	public void setListenerFiltrarMail(ActionListener l) {
		btnFiltrarMail.addActionListener(l);
	}//fin setListenerFiltrarProv()
	
	//MENSAJES
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}//fin mostrarError()

	public void mostrarMensajes(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.INFORMATION_MESSAGE);
	}//fin mostrarMensajes()
	
	public String filtrarPorInicial() {
		String letra = JOptionPane.showInputDialog(this, "Escribir letra para filtrar");
		return letra;
	}//fin filtrarLetra

	public String filtrarPorMail() {
		String mail = JOptionPane.showInputDialog(this, "Escribir tipo de mail para filtrar");
		return mail;
	}//filtrarPorMail()
	
	//TABLAS
	public void limpiarTabla() {
		modelo.setRowCount(0);
	}//fin limpiarTabla()

	public int getFilaSeleccionada() {
		return table.getSelectedRow();
	}//fin getFilaSeleccionada()
	
	public Object getValorSeleccionado() {
		return modelo.getValueAt(getFilaSeleccionada(), 0);//empieza por 0 las tablas como un array
	}//fin getValorSeleccionado()

	public void borrarFila(int fila) {
		modelo.removeRow(fila);
	}//fin borrarFila()

	
	
}//fin class
