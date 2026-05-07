package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;

public class PeliculaDAO {

	public List<Pelicula> listar() throws Exception{
		List<Pelicula> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM peliculas";
		
		try(Connection conn = Database.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			while(rs.next()) {
				lista.add(new Pelicula (
					rs.getInt("Id"),
					rs.getString("Titulo"),
					rs.getString("Director"),
					rs.getString("Genero"),
					rs.getInt("Duracion")));
			}//fin while
			
			
			
		}//fin try
		
		return lista;
	}//fin listar()
	
	
}//fin class
