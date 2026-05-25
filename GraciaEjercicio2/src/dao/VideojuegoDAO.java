package dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.VideoJuego;

/**
 * Ejercicio 2
 * @author Eder Gracia 25/05/26
 */

public class VideojuegoDAO {

	public void crearTabla() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS videojuegos ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "nombre TEXT NOT NULL,"
				+ "plataforma TEXT NOT NULL,"
				+ "precio REAL NOT NULL,"
				+ "stock INTEGER NOT NULL,"
				+ "genero TEXT NOT NULL)";
		try (Connection conn = Database.getConnection();
				Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
		}
	}//fin crearTabla()

	public void insertarVideojuegosPrueba() throws SQLException{
		String sql ="INSERT INTO videojuegos (nombre, plataforma,precio,stock,genero)"
				+ "VALUES('FIFA 25', 'PlayStation 5', 69.99, 15, 'Deportes'),"
				+ "('Minecraft', 'PC', 29.99, 40, 'Sandbox'),"
				+ "('Zelda: Tears of the Kingdom', 'Nintendo Switch', 59.95, 12, 'Aventura'),"
				+ "('Call of Duty', 'Xbox series X', 74.50, 20, 'Acción'),"
				+ "('The Sims', 'PC', 39.99, 18, 'Simulacion')";
		try(Connection conn = Database.getConnection();
				Statement stmt = conn.createStatement()){
			stmt.execute(sql);
		}
	}//fin insertarVideojuegosPrueba
	
	public List<VideoJuego> listarVideoJuegos() throws Exception{
		String sql = "SELECT * FROM videojuegos";
		List<VideoJuego> lista = new ArrayList<>();
		try(Connection conn = Database.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){

			while(rs.next()) {
				lista.add(new VideoJuego(
						rs.getInt("Id"),
						rs.getString("Nombre"),
						rs.getString("Plataforma"),
						rs.getDouble("Precio"),
						rs.getInt("Stock"),
						rs.getString("Genero")));
			}//fin while

		}//fin try
		return lista;
	}//fin listarVideojuego()
	
	public List<VideoJuego> listarPlataformas(String plataforma) throws Exception{
		String sql = "SELECT * FROM videojuegos WHERE plataforma = ?";
		List<VideoJuego> lista = new ArrayList<>();
		try(Connection conn = Database.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, plataforma);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				lista.add(new VideoJuego(
						rs.getInt("Id"),
						rs.getString("Nombre"),
						rs.getString("Plataforma"),
						rs.getDouble("Precio"),
						rs.getInt("Stock"),
						rs.getString("Genero")));
			}//fin while

		}//fin try
		return lista;
	}//fin listarVideojuego()
	
	public void insertar(VideoJuego e) throws Exception {
		String sql = "INSERT INTO videojuegos(nombre, plataforma, precio, stock, genero)"
				+ " VALUES (?,?,?,?,?)";
		
		try(Connection conex = Database.getConnection();
				PreparedStatement pstmt = conex.prepareStatement(sql)){
			
			pstmt.setString(1, e.getNombre());
			pstmt.setString(2, e.getPlataforma());
			pstmt.setDouble(3, e.getPrecio());
			pstmt.setInt(4, e.getStock());
			pstmt.setString(5, e.getGenero());
			pstmt.executeUpdate();
			
		}//fin try
	}//fin insertar()
	
	public void borrarVehiculo(Integer id) throws Exception{
		String sql = "DELETE FROM videojuegos WHERE id = ?";

		try (Connection conn = Database.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		}//fin try

	}//fin borrarVideojuego

	public List<String> getPlataformas() throws SQLException {
		List<String> plataformas = new ArrayList<String>();
		String sql = "SELECT DISTINCT plataforma FROM videojuegos";

		try(Connection conn = Database.getConnection()){
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				plataformas.add(rs.getString("provincia"));
			}//fin while
			
		}//fin try
		return plataformas;
	}
}//fin class VideojuegoDAO
