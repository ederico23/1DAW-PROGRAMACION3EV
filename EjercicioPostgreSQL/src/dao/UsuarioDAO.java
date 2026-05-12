package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UsuarioDAO {

	public void insertarUsuario(String nombre, String email) throws Exception {
		String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";

		try (Connection conn = Database.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nombre);
			pstmt.setString(2, email);

			pstmt.executeUpdate();

		}//fin try
	}//fin insertUsuario()

	public List<Usuario> listarUsuarios() throws Exception{
		String sql = "SELECT * FROM usuarios";
		List<Usuario> lista = new ArrayList<>();
		try(Connection conn = Database.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){

			while(rs.next()) {
				lista.add(new Usuario(
						rs.getInt("Id"),
						rs.getString("Nombre"),
						rs.getString("email")));
			}//fin while

		}//fin try
		return lista;
	}//fin listarUsuarios()


	public void actualizarUsuarios(int id, String nombre, String email) throws Exception{
		String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";

		try (Connection conn = Database.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nombre);
			pstmt.setString(2, email);
			pstmt.setInt(3, id);

			pstmt.executeUpdate();

		}//fin try
	}//fin actualizarUsuarios()


	public void borrarUsuario(int id) throws Exception{
		String sql = "DELETE FROM usuarios WHERE id = ?";

		try (Connection conn = Database.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		}//fin try
	}//fin borrarUsuario()

	public List<Usuario> filtrarInicial(String letra) throws Exception {
		String sql = "SELECT * FROM usuarios WHERE nombre LIKE ?";
		List<Usuario> lista = new ArrayList<>();
		try (Connection conn = Database.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, letra + "%");
			
			try (ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					lista.add(new Usuario(
							rs.getInt("Id"),
							rs.getString("Nombre"),
							rs.getString("email")));
				}//fin while
			}//fin trycatch
			return lista;
		}//fin try

	}//fin filtrarLetra()

}//fin class
