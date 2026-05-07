package dao;

import java.sql.Connection;
import java.sql.Statement;

public class CrearBBDD {

	public static void crearBD() throws Exception{
		//crear tabla
		String sqlCreate = "CREATE TABLE IF NOT EXISTS peliculas("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "titulo TEXT,"
				+ "director TEXT NOT NULL,"
				+ "genero TEXT NOT NULL,"
				+ "duracion INTEGER CHECK(duracion > 0));";
		
		try (Connection conn = Database.getConnection();
				Statement stmt = conn.createStatement()){
			stmt.executeUpdate(sqlCreate);
		}//fin try
		
		
		//insertar datos
		String sqlInsert = "INSERT INTO peliculas(titulo, director, genero, duracion) VALUES "
		        + "('Interstellar', 'Christopher Nolan', 'Ciencia Ficción', 169), "
		        + "('El Padrino', 'Francis Ford Coppola', 'Drama', 175), "
		        + "('Inception', 'Christopher Nolan', 'Acción', 148), "
		        + "('Pulp Fiction', 'Quentin Tarantino', 'Crimen', 154), "
		        + "('El Viaje de Chihiro', 'Hayao Miyazaki', 'Animación', 125), "
		        + "('Parásitos', 'Bong Joon-ho', 'Suspense', 132), "
		        + "('Matrix', 'Lana y Lilly Wachowski', 'Ciencia Ficción', 136), "
		        + "('Gladiator', 'Ridley Scott', 'Acción', 155), "
		        + "('Seven', 'David Fincher', 'Thriller', 127), "
		        + "('Coco', 'Lee Unkrich', 'Animación', 105);";
		
		try (Connection conn = Database.getConnection();
				Statement stmt = conn.createStatement()){
			stmt.executeUpdate(sqlInsert);
		}//fin try
		
	}//fin crearBD
	
}//fin class
