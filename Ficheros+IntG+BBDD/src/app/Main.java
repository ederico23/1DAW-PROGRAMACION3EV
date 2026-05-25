package app;

import java.sql.SQLException;
import dao.EmpleadoDAO;
import vista.Vista;
import controlador.ControladorEmpleado;

public class Main {

    public static void main(String[] args) {
        // 1. Crear la BD y los datos de prueba
        EmpleadoDAO dao = new EmpleadoDAO();
        try {
            dao.crearTabla();
            dao.insertarEmpleadosInicio();
        } catch (SQLException e) {
            System.out.println("Error al iniciar la BD: " + e.getMessage());
            return;
        }

        // 2. Arrancar la ventana y el controlador
        Vista v = new Vista();
        new ControladorEmpleado(v, dao);
        v.setVisible(true);
    }
}