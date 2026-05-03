package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelEditar extends JPanel{
	
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JButton btnActualizar;
	private JButton btnVolver;
	
	public PanelEditar() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(96, 109, 48, 14);
		add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(96, 171, 48, 14);
		add(lblEdad);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setBounds(189, 106, 119, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdad.setColumns(10);
		txtEdad.setBounds(189, 168, 119, 20);
		add(txtEdad);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(197, 221, 111, 22);
		add(btnActualizar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(56, 221, 88, 22);
		add(btnVolver);
		
		
	}//fin constructor
	
	
	public String getNombre() {
		return txtNombre.getText();
	}//fin getNombre()

	public String getEdad() {
		return txtEdad.getText();
	}//fin getEdad()

	public void setActionListenerActualizar(ActionListener l) {
		btnActualizar.addActionListener(l);
	}//fin setActionListenerActualizar()
	
	public void setACtionListenerVolver(ActionListener l) {
		btnVolver.addActionListener(l);
	}//fin setActionListenerVolver()
	
}//fin class
