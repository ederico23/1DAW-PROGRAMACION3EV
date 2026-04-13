package ejemplos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class EjemploDialogoEmergente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploDialogoEmergente frame = new EjemploDialogoEmergente();
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
	public EjemploDialogoEmergente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//BOTONES
		JButton btnMensaje = new JButton("Mostrar mensaje");
		btnMensaje.setBounds(159, 172, 150, 23);
		contentPane.add(btnMensaje);

		JButton btnDialogo = new JButton("Mostrar dialogo");
		String[] opciones = {"Aceptar", "Cancelar", "Salir"}; //String con los botons que queremos que salgan 
		btnDialogo.setBounds(159, 119, 150, 23);
		contentPane.add(btnDialogo);


		JButton btnInput = new JButton("Input");
		btnInput.setBounds(159, 52, 150, 23);
		contentPane.add(btnInput);
		
		JButton btnInputCompuesto = new JButton("InputCompuesto");
		btnInputCompuesto.setBounds(159, 86, 150, 23);
		contentPane.add(btnInputCompuesto);


		//LISTENERS
		btnMensaje.addActionListener(e->
		JOptionPane.showMessageDialog(
				null, //null en medio de la pantalla, this en medio de la ventana 
				"Mensaje", //mensaje a mostrar 
				"Titulo",  //titulo de la ventana emergente
				JOptionPane.WARNING_MESSAGE //tipo de ventana que saldra, yes/no, aviso, pregunta...
				));//fin actionListener btnMensaje





		btnDialogo.addActionListener(e->{
			int respuesta = //lo guardamos en una variable int pq devuelve un entero, asi luego podemos hacer un sw
					JOptionPane.showOptionDialog(
							this, //donde aparece la ventana emergente
							"Que quieres hacer", //mensaje en la ventana
							"Titulo", //titulo ventana
							JOptionPane.DEFAULT_OPTION,//tipo boton
							JOptionPane.QUESTION_MESSAGE, //icono de mensaje
							null, //posible icono personalizados
							opciones, //opciones de los botones
							opciones[0] //opcion que sale default
							);
			//se puede poner un switch para decidir que hacer segun la respuesta
			System.out.println("Respuesta elegida " + opciones[respuesta]);
		});//FIN DIALOGO LISTENER



		btnInput.addActionListener(e->{
			String resultado = JOptionPane.showInputDialog(
					null,
					"Introduce tu nombre",
					"Entrada de datos",
					JOptionPane.QUESTION_MESSAGE
					);
			if(resultado.isEmpty()) {
				System.err.println("introduce un nombre");
			} else {
				System.out.println("Has introducido " + resultado);
			}
		});//FIN INPUT LISTENER

		
		btnInputCompuesto.addActionListener(e->{
			//creo un objeto PanelDatos
			EjemploPanelDatos panel = new EjemploPanelDatos();
			int respuesta = JOptionPane.showConfirmDialog(
					null,//centro pantalla
					panel,
					"Introduce datos",
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE					
					);
			
			if(respuesta == JOptionPane.OK_OPTION) {
				panel.escribirDatos();
			} else {
				JOptionPane.showMessageDialog(null,
						"Has cancelado la operacion",
						"Adios",
						JOptionPane.WARNING_MESSAGE);
			}//fin if
			
		});//fin inputCompuesto actionListener
		
		
		
	}//fin constructor
}//fin class
