package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Ejercicio 2
 * @author Eder Gracia 25/05/26
 */

public class Database {
	private static final String URL = "jdbc:sqlite:videojuegos.db";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
	}
}//fin class Database
