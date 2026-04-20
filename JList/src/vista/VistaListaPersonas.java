package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Persona;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class VistaListaPersonas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textEdad;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnMod;
	private JList<Persona> personaLista = new JList<>();

	/**
	 * Create the frame.
	 */
	public VistaListaPersonas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(42, 22, 46, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(98, 19, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setBounds(236, 22, 46, 14);
		contentPane.add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setHorizontalAlignment(SwingConstants.CENTER);
		textEdad.setBounds(294, 19, 86, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(personaLista);
		scrollPane.setBounds(47, 66, 333, 120);
		contentPane.add(scrollPane);
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.setBounds(42, 213, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Borrar");
		btnDelete.setBounds(160, 213, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnMod = new JButton("Modificar");
		btnMod.setBounds(291, 213, 89, 23);
		contentPane.add(btnMod);

	}//fin constructor

	//GETTERS Y SETTERS
	public String getNombre() {
		return textNombre.getText();
	}

	public String getEdad() {
		return textEdad.getText();
	}

	
	//LISTENERS
	public void setListenerBorrar(ActionListener l) {
		btnDelete.addActionListener(l);
	}
	
	public void setListenerAdd(ActionListener l) {
		btnAdd.addActionListener(l);
	}
	
	public void setListenerMod(ActionListener l) {
		btnMod.addActionListener(l);
	}
	
	
	//AGREGAR MODELO
	public void setModelo(DefaultListModel<Persona> modelo) {
		personaLista.setModel(modelo);
	}
	
	//MENSAJES
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}

	public void limpiarCampos() {
		textNombre.setText("");
		textEdad.setText("");
	}
}//fin class
