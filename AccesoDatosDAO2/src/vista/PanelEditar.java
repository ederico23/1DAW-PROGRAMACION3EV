package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelEditar extends JPanel{
	public PanelEditar() {
	}
	
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JButton btnActualizar;
	
	public void PanelEditrar() {
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

		btnActualizar = new JButton("Guardar");
		btnActualizar.setBounds(188, 212, 88, 22);
		add(btnActualizar);
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


}//fin class
