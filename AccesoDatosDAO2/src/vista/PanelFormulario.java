package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class PanelFormulario extends JPanel {
	private JTextField txtNombre;
	private JTextField txtEdad;
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
	}
}//fin class
