package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNums;
	private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	private JButton btnIgual, btnCE, btnSumar, btnRestar, btnMult, btnDiv;
	private JButton[] numeros = ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
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
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNums = new JTextField();
		txtNums.setBounds(27, 28, 277, 20);
		contentPane.add(txtNums);
		txtNums.setColumns(10);
		
		btn0 = new JButton("0");
		btn0.setBounds(27, 289, 39, 22);
		contentPane.add(btn0);
		
		btn1 = new JButton("1");
		btn1.setBounds(27, 115, 39, 22);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBounds(142, 116, 39, 22);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBounds(253, 116, 51, 22);
		contentPane.add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBounds(27, 169, 39, 22);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBounds(142, 169, 39, 22);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBounds(253, 169, 51, 22);
		contentPane.add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBounds(27, 231, 39, 22);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBounds(142, 231, 39, 22);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBounds(253, 231, 51, 22);
		contentPane.add(btn9);
		
		btnIgual = new JButton("=");
		btnIgual.setBounds(142, 289, 39, 22);
		contentPane.add(btnIgual);
		
		btnCE = new JButton("CE");
		btnCE.setBounds(253, 289, 51, 22);
		contentPane.add(btnCE);
		
		btnSumar = new JButton("+");
		btnSumar.setBounds(10, 67, 39, 22);
		contentPane.add(btnSumar);
		
		btnRestar = new JButton("-");
		btnRestar.setBounds(91, 67, 45, 22);
		contentPane.add(btnRestar);
		
		btnMult = new JButton("*");
		btnMult.setBounds(183, 67, 51, 22);
		contentPane.add(btnMult);
		
		btnDiv = new JButton("/");
		btnDiv.setBounds(275, 67, 51, 22);
		contentPane.add(btnDiv);

		for(int i = 0; i<10; i++) {
			numeros[i] = new JButton(i+"");
			numeros[i].setActionCommand(getNums());
		}
		
	}//fin constructor
	
	public JButton[] getBotonesNumeros() {
		return new JButton[] {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
	}
	
	public JButton getBtnIgual() { 
		return btnIgual; 
	}
	
	public JButton getBtnCE() {
		return btnCE; 
	}
	
	public JButton getBtnSumar() {
		return btnSumar; 
	}
	
	public JButton getBtnRestar() {
		return btnRestar; 
	}
	
	public JButton getBtnMult() {
		return btnMult; 
	}
	
	public JButton getBtnDiv() {
		return btnDiv; 
	}
	
	public String getNums() {
		return txtNums.getText();
	}
	
	public void setNums(String num) {
		txtNums.setText(num);
	}
	
	
}//fin class
