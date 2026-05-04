package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Vehiculo;

public class VehiculoDAO {

	public List<Vehiculo> listar() throws Exception{
		List<Vehiculo> lista = new ArrayList<>();
		String sql = "SELECT * FROM VEHICULOS";

		try (Connection conex = Database.getConnection();
				PreparedStatement pstmt = conex.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){

			while(rs.next()) {
				lista.add(new Vehiculo(
						rs.getString("marca"),
						rs.getString("vehiculo"),
						rs.getString("provincia"),
						rs.getString("matricula"),
						rs.getInt("km")));

			}//fin while
		}//fin try
		return lista;
	}//fin listar()
	
	
}//fin class
