package ejercicios;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Ejercicio05 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ejercicio05 frame = new Ejercicio05();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Ejercicio05() {
		//predefinido
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		//variables
		
		JLabel lblMensaje = new JLabel("");
		contentPane.add(lblMensaje, BorderLayout.CENTER);
		
		
		
		JButton btnCambioNombre = new JButton("Aceptar");
		
		contentPane.add(btnCambioNombre, BorderLayout.SOUTH);
		
		txtNombre = new JTextField();
		//txtNombre.setText("Introduce tu nombre");
		contentPane.add(txtNombre, BorderLayout.NORTH);
		txtNombre.setColumns(10);
	
		
		//acciones
		btnCambioNombre.addActionListener(e->{
			String textoExtraido = txtNombre.getText();
			lblMensaje.setText("Bienvenido " + textoExtraido);
			});

		btnCambioNombre.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("boton izq");
				} else if(e.getButton() ==  MouseEvent.BUTTON3) {
					System.out.println("boton derecho");
				}
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
	}//fin Ejercicio05


	
}//fin class
