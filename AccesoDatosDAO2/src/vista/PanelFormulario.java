package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PanelFormulario extends JPanel {
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JButton btnGuardar;
	private JButton btnVolver;

	public PanelFormulario() {
		setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(94, 84, 68, 30);
		add(lblNombre);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setBounds(94, 146, 68, 30);
		add(lblEdad);

		txtNombre = new JTextField();
		txtNombre.setBounds(186, 148, 90, 24);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(186, 92, 90, 24);
		add(txtEdad);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(188, 212, 88, 22);
		add(btnGuardar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(74, 212, 88, 22);
		add(btnVolver);
	}//fin constructor

	public String getNombre() {
		return txtNombre.getText();
	}//fin getNombre()

	public String getEdad() {
		return txtEdad.getText();
	}//fin getEdad()

	public void setActionListenerGuardar(ActionListener l) {
		btnGuardar.addActionListener(l);
	}//fin setActionListenerGuardar()

	public void setACtionListenerVolver(ActionListener l) {
		btnVolver.addActionListener(l);
	}//fin setActionListenerVolver()
	
	
}//fin class
