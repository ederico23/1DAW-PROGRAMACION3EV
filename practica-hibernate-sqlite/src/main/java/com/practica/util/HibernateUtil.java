package com.practica.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
// Campo estático final: se inicializa UNA VEZ cuando la clase se carga en 
//memoria
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
// Carga el archivo hibernate.cfg.xml desde el classpath
			configuration.configure("hibernate.cfg.xml");
// Registra la entidad Student para que Hibernate la conozca
			configuration.addAnnotatedClass(Student.class);

// Construye y devuelve la SessionFactory (operación costosa)
			return configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Error al crear SessionFactory: " + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

// Método público para obtener la única instancia
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

// Cierra todos los recursos al terminar el programa
	public static void shutdown() {
		if (SESSION_FACTORY != null && !SESSION_FACTORY.isClosed()) {
			SESSION_FACTORY.close();
		}
	}
}