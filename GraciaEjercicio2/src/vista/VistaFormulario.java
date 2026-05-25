package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VistaFormulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPlataforma;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextField txtGenero;
	private JButton btnGuardar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaFormulario frame = new VistaFormulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaFormulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 29, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Plataforma");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 69, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Precio");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 104, 76, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Stock");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(10, 143, 76, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Genero");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(10, 183, 76, 14);
		contentPane.add(lblNewLabel_1_3);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(115, 26, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setBounds(115, 66, 86, 20);
		contentPane.add(txtPlataforma);
		txtPlataforma.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(115, 101, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(115, 140, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(115, 180, 86, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		btnGuardar = new JButton("Guardar videojuego");
		btnGuardar.setBounds(22, 227, 179, 23);
		contentPane.add(btnGuardar);

	}//fin VistaFormulario()

	public void setListenerGuardar(ActionListener l) {
		btnGuardar.addActionListener(l);
	}
	
	public String getNombre() {
		return txtNombre.getText();
	}
	
	public String getPlataforma() {
		return txtPlataforma.getText();
	}
	
	public String getPrecio() {
		return txtPrecio.getText();
	}
	
	public String getStock() {
		return txtStock.getText();
	}
	
	public String getGenero() {
		return txtGenero.getText();
	}
	
	public void irPrincipal() {
		Vista ViewNuevo = new Vista();
		ViewNuevo.setVisible(true);
	}
	

}//fin class VistaFormulario
