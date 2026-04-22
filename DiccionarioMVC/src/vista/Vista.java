package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPalabraSpain;
	private JLabel lblTraducida;
	private JButton btnTraductor; 

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtPalabraSpain = new JTextField();
		txtPalabraSpain.setBounds(67, 40, 86, 20);
		contentPane.add(txtPalabraSpain);
		txtPalabraSpain.setColumns(10);

		JLabel lblMensaje = new JLabel("Palabra a traducir:");
		lblMensaje.setBounds(67, 11, 112, 14);
		contentPane.add(lblMensaje);

		lblTraducida = new JLabel("");
		lblTraducida.setBounds(214, 103, 180, 14);
		contentPane.add(lblTraducida);

		btnTraductor = new JButton("TRADUCIR");
		btnTraductor.setBounds(67, 99, 89, 23);
		contentPane.add(btnTraductor);

	}
	
	public String getPalabra() {
		return txtPalabraSpain.getText();
	}
	
	public void setPalabra(String mensaje) {
		lblTraducida.setText(mensaje);
	}

	
	public void setListenerTraducir(ActionListener l) {
		btnTraductor.addActionListener(l);
	}
}//fin class
