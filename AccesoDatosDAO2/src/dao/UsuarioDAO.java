package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import modelo.Usuario;

public class UsuarioDAO {

	public void insertar(Usuario u) throws Exception {
		String sql = "INSERT INTO USUARIOS (NOMBRE,EDAD) VALUES (?,?)";

		try (Connection conex = Database.getConnection();
				PreparedStatement pstmt = conex.prepareStatement(sql)){

			pstmt.setString(1, u.getNombre());
			pstmt.setInt(2, u.getEdad());
			pstmt.executeUpdate();
		}//fin trycatch
	}//fin insertar()


	public List<Usuario> listar() throws Exception{
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT * FROM USUARIOS";

		try (Connection conex = Database.getConnection();
				PreparedStatement pstmt = conex.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){

			while(rs.next()) {
				lista.add(new Usuario(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("edad")));

			}//fin while
		}//fin try
		return lista;
	}//fin listar()

	public void actualizar(Usuario u) throws Exception {

		String sql = "UPDATE USUARIOS SET NOMBRE=?, EDAD=? WHERE ID=?";

		try (Connection conex = Database.getConnection();
				PreparedStatement pstmt = conex.prepareStatement(sql)){

			pstmt.setString(1, u.getNombre());
			pstmt.setInt(2, u.getEdad());
			pstmt.setInt(3, u.getId());
			pstmt.executeUpdate();

		}//fin try

	} //fin actualizar()


	public void eliminar(Usuario u) throws Exception {
		String sql = "DELETE DROP USUARIOS WHERE ID=?";

		try (Connection conex = Database.getConnection();
				PreparedStatement pstmt = conex.prepareStatement(sql)){

			pstmt.setInt(1, u.getId());
			pstmt.executeUpdate();
		}//fin try
	} //fin eliminar()

}//fin class
