package vista;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Vista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombre, txtPuesto, txtSalario;
    private JComboBox<String> comboBox;
    private JButton btnBuscar, btnCrear, btnExportar;
    private JTextArea txtArea;
    private JLabel lblInfo;

    public Vista() {
        setTitle("Gestión de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 589, 335);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblFiltrar = new JLabel("Filtrar:");
        lblFiltrar.setBounds(10, 34, 60, 14);
        contentPane.add(lblFiltrar);

        comboBox = new JComboBox<>();
        comboBox.setBounds(70, 30, 120, 22);
        contentPane.add(comboBox);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(200, 30, 89, 23);
        contentPane.add(btnBuscar);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 78, 60, 14);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(70, 75, 120, 20);
        contentPane.add(txtNombre);

        JLabel lblPuesto = new JLabel("Puesto:");
        lblPuesto.setBounds(200, 78, 60, 14);
        contentPane.add(lblPuesto);

        txtPuesto = new JTextField();
        txtPuesto.setBounds(260, 75, 100, 20);
        contentPane.add(txtPuesto);

        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setBounds(10, 120, 60, 14);
        contentPane.add(lblSalario);

        txtSalario = new JTextField();
        txtSalario.setBounds(70, 117, 100, 20);
        contentPane.add(txtSalario);

        btnCrear = new JButton("Añadir empleado");
        btnCrear.setBounds(200, 117, 140, 23);
        contentPane.add(btnCrear);

        btnExportar = new JButton("Exportar CSV");
        btnExportar.setBounds(350, 117, 140, 23);
        contentPane.add(btnExportar);

        txtArea = new JTextArea();
        txtArea.setBounds(10, 155, 553, 100);
        contentPane.add(txtArea);

        lblInfo = new JLabel("");
        lblInfo.setBounds(10, 265, 553, 14);
        contentPane.add(lblInfo);
    }

    // Getters de los campos del formulario
    public String getNombre() { return txtNombre.getText(); }
    public String getPuesto() { return txtPuesto.getText(); }
    public String getSalarioTexto() { return txtSalario.getText(); }
    public Object getEstadoSeleccionado() { return comboBox.getSelectedItem(); }

    // Setters para actualizar la interfaz
    public void setTextoArea(String texto) { txtArea.setText(texto); }
    public void setInfo(String mensaje) { lblInfo.setText(mensaje); }

    // Limpia los campos del formulario
    public void limpiarCampos() {
        txtNombre.setText("");
        txtPuesto.setText("");
        txtSalario.setText("");
    }

    // Carga las opciones del comboBox
    public void cargarCombo(String[] opciones) {
        for (String op : opciones) {
            comboBox.addItem(op);
        }
    }

    // Listeners de los botones
    public void setListenerBuscar(ActionListener l) { btnBuscar.addActionListener(l); }
    public void setListenerCrear(ActionListener l) { btnCrear.addActionListener(l); }
    public void setListenerExportar(ActionListener l) { btnExportar.addActionListener(l); }

    // Mensajes de error e información
    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}