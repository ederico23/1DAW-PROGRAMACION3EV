package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	// Credenciales de Render
	private static final String URL = "jdbc:postgresql://dpg-d80u14mgvqtc73dsvcq0-a.frankfurt-postgres.render.com:5432/prueba_89p7?sslmode=require";
	private static final String USER = "alumno";
	private static final String PASS = "12345*";

	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(URL, USER, PASS);
	}
}