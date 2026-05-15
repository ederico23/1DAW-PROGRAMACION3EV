package com.practica.main;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practica.util.Student;
import com.practica.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== INICIO PRÁCTICA HIBERNATE + SQLITE ===\n");
// 1) CREATE: insertar estudiantes, obtener sus IDs
		List<Long> idsCreados = crearEstudiantesEjemplo();
		if (!idsCreados.isEmpty()) {
			Long idPrimero = idsCreados.get(0);
			Long idUltimo = idsCreados.get(idsCreados.size() - 1);
// 2) READ: buscar por ID y listar todos
			leerEstudiantePorId(idPrimero);
			listarTodosLosEstudiantes();

// 3) UPDATE: modificar nombre y edad del primero
			actualizarEstudiante(idPrimero, "Lucía (actualizado)", 23);
// 4) DELETE: eliminar el último
			eliminarEstudiante(idUltimo);
			listarTodosLosEstudiantes();
		}
		HibernateUtil.shutdown(); // Cierra conexiones al terminar
		System.out.println("\n=== FIN PRÁCTICA ===");
	}
// Los métodos privados crearEstudiantesEjemplo(), leerEstudiantePorId(),
// listarTodosLosEstudiantes(), actualizarEstudiante(), eliminarEstudiante()
// se explican en la siguiente sección.

	private static List<Long> crearEstudiantesEjemplo() {
		List<Long> ids = new ArrayList<>();
		Transaction tx = null;
		// try-with-resources: la sesión se cierra automáticamente al salir del bloque
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction(); // Iniciamos la transacción
			// Sufijo de tiempo para emails únicos en cada ejecución
			String sufijo = String.valueOf(System.currentTimeMillis());
			// Creamos objetos Java normales (aún no están en la BD)
			Student s1 = new Student("Ana", "García López", 20, "ana.garcia." + sufijo + "@example.com");
			Student s2 = new Student("Carlos", "Pérez Martín", 22, "carlos.perez." + sufijo + "@example.com");
			Student s3 = new Student("Lucía", "Ruiz Torres", 21, "lucia.ruiz." + sufijo + "@example.com");
			// persist() marca cada objeto para ser insertado al hacer commit
			session.persist(s1);
			session.persist(s2);
			session.persist(s3);
			ids.add(s1.getId());
			ids.add(s2.getId());
			ids.add(s3.getId());

			tx.commit(); // Ejecuta los INSERTs en la BD y cierra la transacción
			// Después del commit, Hibernate ha rellenado los IDs generados por la BD
		} catch (Exception e) {
			rollbackSiHaceFalta(tx); // Si hay error, deshacemos todo
			System.err.println("Error en CREATE: " + e.getMessage());
		}
		return ids;
	}

	private static void leerEstudiantePorId(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// get() busca por clave primaria. Devuelve null si no existe.
			Student student = session.get(Student.class, id);
			if (student != null) {
				System.out.println("Encontrado: " + student);
			} else {
				System.out.println("No existe estudiante con ID " + id);
			}
		} catch (Exception e) {
			System.err.println("Error en READ por ID: " + e.getMessage());
		}
		// No hace falta Transaction para operaciones de solo lectura
	}

	private static void listarTodosLosEstudiantes() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// HQL (Hibernate Query Language): usa nombres de CLASES, no de tablas
			// "from Student" equivale a "SELECT * FROM students"
			List<Student> estudiantes = session.createQuery("from Student", Student.class).list();
			if (estudiantes.isEmpty()) {
				System.out.println("No hay estudiantes registrados.");
			} else {
				estudiantes.forEach(System.out::println);
			}

		} catch (Exception e) {
			System.err.println("Error en listado: " + e.getMessage());
		}
	}

	private static void actualizarEstudiante(Long id, String nuevoNombre, Integer nuevaEdad) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			// Paso 1: Cargamos el objeto desde la BD
			Student student = session.get(Student.class, id);
			if (student != null) {
				// Paso 2: Modificamos el objeto Java como siempre
				student.setNombre(nuevoNombre);
				student.setEdad(nuevaEdad);
				// Paso 3: merge() genera automáticamente el UPDATE en SQL
				session.merge(student);
				tx.commit();
				System.out.println("Estudiante actualizado correctamente.");

			} else {
				System.out.println("No se puede actualizar: ID " + id + " no existe");
				rollbackSiHaceFalta(tx);
			}
		} catch (Exception e) {
			rollbackSiHaceFalta(tx);
			System.err.println("Error en UPDATE: " + e.getMessage());
		}
	}

	private static void eliminarEstudiante(Long id) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			// Cargamos el objeto para verificar que existe
			Student student = session.get(Student.class, id);
			if (student != null) {
				// remove() marca el objeto para ser eliminado al hacer commit
				session.remove(student);
				tx.commit();
				System.out.println("Estudiante eliminado correctamente.");
			} else {
				System.out.println("No se puede eliminar: ID " + id + " no existe");
				rollbackSiHaceFalta(tx);
			}
		} catch (Exception e) {
			rollbackSiHaceFalta(tx);
			System.err.println("Error en DELETE: " + e.getMessage());
		}
	}

	private static void rollbackSiHaceFalta(Transaction tx) {
		if (tx != null) {
			try {
				if (tx.isActive()) {
					tx.rollback(); // Deshace todos los cambios de la transacción
				}
			} catch (Exception ex) {
				System.err.println("No fue posible hacer rollback: " + ex.getMessage());
			}
		}
	}

}
