package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private static final String URL = "jdbc:sqlite:peliculas.db";
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(URL);
	}//fin getConnection()
	
}//fin class
