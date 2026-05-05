package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import controlador.ControllerVehiculo;
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
	
	
	public List<Vehiculo> filtrarKm(int km) throws Exception {
		String sql = "SELECT * FROM VEHICULOS WHERE KM >= ?";
		List<Vehiculo> listaKM = new ArrayList<Vehiculo>();
		
		try (Connection conex = Database.getConnection();
				PreparedStatement pstmt = conex.prepareStatement(sql)){
			
			pstmt.setInt(1, km);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				listaKM.add(new Vehiculo(
						rs.getString("marca"),
						rs.getString("vehiculo"),
						rs.getString("provincia"),
						rs.getString("matricula"),
						rs.getInt("km")));

			}//fin while
			
			return listaKM;
		}//fin try
		
	}//fin filtrarKm()
	
}//fin class
