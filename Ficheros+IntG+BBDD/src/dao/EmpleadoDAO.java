package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDAO {

    // Crea la tabla si no existe al arrancar la app
    public void crearTabla() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS empleados ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "puesto TEXT NOT NULL,"
                + "salario REAL NOT NULL,"
                + "activo INTEGER NOT NULL)";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    // Inserta los 5 empleados de prueba, OR IGNORE evita duplicados
    public void insertarEmpleadosInicio() throws SQLException {
        String sql = "INSERT OR IGNORE INTO empleados VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            Object[][] datos = {
                {1, "Ana García",    "Desarrolladora", 2200.0, 1},
                {2, "Luis Martínez", "Analista",        2800.0, 1},
                {3, "Marta López",   "Diseñadora",      1900.0, 0},
                {4, "Pedro Ruiz",    "Desarrollador",   2500.0, 1},
                {5, "Sara Sanz",     "Tester",          2100.0, 0}
            };

            for (Object[] fila : datos) {
                pstmt.setInt(1,    (int) fila[0]);
                pstmt.setString(2, (String) fila[1]);
                pstmt.setString(3, (String) fila[2]);
                pstmt.setDouble(4, (double) fila[3]);
                pstmt.setInt(5,    (int) fila[4]);
                pstmt.executeUpdate();
            }
        }
    }

    // Devuelve todos los empleados de la BD
    public List<Empleado> listarTodos() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("puesto"),
                    rs.getDouble("salario"),
                    rs.getInt("activo")
                ));
            }
        }
        return lista;
    }

    // Devuelve solo los empleados con activo = 1
    public List<Empleado> listarActivos() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados WHERE activo = 1";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("puesto"),
                    rs.getDouble("salario"),
                    rs.getInt("activo")
                ));
            }
        }
        return lista;
    }

    // Inserta un empleado nuevo desde el formulario, activo siempre es 1
    public void insertarEmpleado(String nombre, String puesto, double salario) throws SQLException {
        String sql = "INSERT INTO empleados (nombre, puesto, salario, activo) VALUES (?, ?, ?, 1)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, puesto);
            pstmt.setDouble(3, salario);
            pstmt.executeUpdate();
        }
    }
}