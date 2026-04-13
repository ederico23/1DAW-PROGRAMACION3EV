package ejemplos;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EjemploMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout = new CardLayout(); //TIENE FUNCIONES ESPECIFICAS PARA ESTO, SUPERPONER...
	private JPanel contentPane = new JPanel(cardLayout);
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploMenu frame = new EjemploMenu();
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
	public EjemploMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//contentPane = new JPanel(); QUITAMOS ESTA LINEA PQ ESTA CREADO ARRIBA
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelRojo = new JPanel();
		panelRojo.add(new JLabel("Color rojo"));
		panelRojo.setBackground(new Color(255,0,0));

		JPanel panelVerde = new JPanel();
		panelVerde.add(new JLabel("Color verde"));
		panelVerde.setBackground(new Color(0,255,0));

		JPanel panelAzul = new JPanel();
		panelAzul.add(new JLabel("Color azul"));
		panelAzul.setBackground(new Color(0,0,255));
		
		//metemos los paneles para sobreescribirlos despues como queramos
		contentPane.add(panelRojo, "Panel rojo");
		contentPane.add(panelVerde, "Panel verde");
		contentPane.add(panelAzul, "Panel azul");

		//creamos menu
		JMenuBar barraMenu = new JMenuBar();
		JMenu menu = new JMenu("Navegacion");
		
		//creamos items
		JMenuItem itemRojo = new JMenuItem("Rojo");
		JMenuItem itemVerde = new JMenuItem("Verde");
		JMenuItem itemAzul = new JMenuItem("Azul");
		
		//meterlos en el menu
		setJMenuBar(barraMenu);
		barraMenu.add(menu);
		menu.add(itemRojo);
		menu.add(itemVerde);
		menu.add(itemAzul);
		
		//listeners
		itemRojo.addActionListener(e-> cardLayout.show(contentPane, "Panel rojo"));
		itemAzul.addActionListener(e-> cardLayout.show(contentPane, "Panel azul"));
		itemVerde.addActionListener(e-> cardLayout.show(contentPane, "Panel verde"));
		
		cardLayout.show(contentPane, "Panel azul");
		
		
	}//fin constructor

}//fin class
