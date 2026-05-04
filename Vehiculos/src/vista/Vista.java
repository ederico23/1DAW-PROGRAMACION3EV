package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modelo.Vehiculo;
import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo;
	private JButton btnGuardar;
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		JTable table = new JTable(modelo);

		//meter en el panel la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(54, 11, 370, 168);
		contentPane.add(scrollPane);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(76, 209, 89, 23);
		contentPane.add(btnGuardar);
		
		
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
	
	
	public void setListenerGuardar(ActionListener l) {
		btnGuardar.addActionListener(l);
	}//fin setActionListenerGuardar()
	
}//fin class
