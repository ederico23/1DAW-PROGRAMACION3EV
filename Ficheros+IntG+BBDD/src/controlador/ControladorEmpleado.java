package controlador;

import java.nio.file.*;
import java.sql.SQLException;
import java.util.List;
import dao.EmpleadoDAO;
import modelo.Empleado;
import vista.Vista;

public class ControladorEmpleado {

    private Vista v;
    private EmpleadoDAO dao;
    private Path path = Path.of("empleados.csv");

    public ControladorEmpleado(Vista v, EmpleadoDAO dao) {
        this.v = v;
        this.dao = dao;
        iniciar();
    }

    public void iniciar() {
        // Crear fichero si no existe
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (Exception e) {
            v.mostrarError("Error al crear el fichero: " + e.getMessage());
        }

        // Cargar opciones del comboBox
        v.cargarCombo(new String[]{"Todos", "Solo activos"});

        // Asignar listeners a los botones
        v.setListenerBuscar(e -> buscar());
        v.setListenerCrear(e -> crearEmpleado());
        v.setListenerExportar(e -> exportarCSV());

        // Mostrar todos los empleados al arrancar
        buscar();
    }

    // Busca según lo seleccionado en el comboBox
    public void buscar() {
        try {
            List<Empleado> empleados;

            if (v.getEstadoSeleccionado().equals("Solo activos")) {
                empleados = dao.listarActivos();
            } else {
                empleados = dao.listarTodos();
            }

            // Construir el texto a mostrar en el JTextArea
            StringBuilder sb = new StringBuilder();
            for (Empleado emp : empleados) {
                String estado = emp.getIsActivo() == 1 ? "[ACTIVO]" : "[INACTIVO]";
                sb.append(emp.getNombre() + " — " + emp.getPuesto()
                        + " — " + emp.getSalario() + "€ " + estado + "\n");
            }

            v.setTextoArea(sb.toString());
            v.setInfo(empleados.size() + " empleados encontrados.");

        } catch (SQLException e) {
            v.mostrarError("Error al buscar: " + e.getMessage());
        }
    }

    // Valida los campos y añade un nuevo empleado
    public void crearEmpleado() {
        String nombre = v.getNombre();
        String puesto = v.getPuesto();
        String salarioTexto = v.getSalarioTexto();

        // Validar que no haya campos vacíos
        if (nombre.isEmpty() || puesto.isEmpty() || salarioTexto.isEmpty()) {
            v.mostrarError("Todos los campos son obligatorios.");
            return;
        }

        // Validar que el salario sea un número válido
        double salario;
        try {
            salario = Double.parseDouble(salarioTexto);
        } catch (NumberFormatException e) {
            v.mostrarError("El salario debe ser un número válido.");
            return;
        }

        // Insertar en la BD
        try {
            dao.insertarEmpleado(nombre, puesto, salario);
            v.limpiarCampos();
            v.setInfo("Empleado añadido correctamente.");
            buscar(); // Actualizar la lista
        } catch (SQLException e) {
            v.mostrarError("Error al insertar: " + e.getMessage());
        }
    }

    // Exporta todos los empleados al fichero CSV
    public void exportarCSV() {
        try {
            List<Empleado> empleados = dao.listarTodos();

            StringBuilder sb = new StringBuilder();
            // Cabecera del CSV
            sb.append("id,nombre,puesto,salario,activo\n");

            // Una línea por empleado
            for (Empleado emp : empleados) {
                sb.append(emp.getId() + ","
                        + emp.getNombre() + ","
                        + emp.getPuesto() + ","
                        + emp.getSalario() + ","
                        + (emp.getIsActivo() == 1 ? "ACTIVO" : "INACTIVO") + "\n");
            }

            // Escribir en el fichero (sobreescribe si ya existe)
            Files.writeString(path, sb.toString());
            v.setInfo("Exportación completada: " + empleados.size() + " empleados guardados.");

        } catch (Exception e) {
            v.mostrarError("Error al exportar: " + e.getMessage());
        }
    }
}