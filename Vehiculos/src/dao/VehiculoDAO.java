package dao;

import java.sql.Statement;
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

	public List<Vehiculo> filtrarProvincia(String provincia) throws Exception {
		List<Vehiculo> lista = new ArrayList<Vehiculo>();
		String sql = "SELECT * FROM VEHICULOS WHERE PROVINCIA = ?";

		try(Connection conn = Database.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){

			pstmt.setString(1, provincia);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				lista.add(new Vehiculo(
						rs.getString("marca"),
						rs.getString("vehiculo"),
						rs.getString("provincia"),
						rs.getString("matricula"),
						rs.getInt("km")));

			}//fin while
			return lista;
		}//fin try 

	}//fin filtrarProvincia()

	public List<String> getProvincias() throws Exception{
		List<String> provincias = new ArrayList<String>();
		String sql = "SELECT DISTINCT PROVINCIA FROM VEHICULOS";

		try(Connection conn = Database.getConnection()){
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				provincias.add(rs.getString("provincia"));
			}//fin while
			
		}//fin try
		return provincias;
	}//fin getProvincias()


	public void borrarVehiculo(String matricula) throws Exception{
		String sql = "DELETE FROM VEHICULOS WHERE MATRICULA = ?";

		try (Connection conn = Database.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){

			pstmt.setString(1, matricula);
			pstmt.executeUpdate();

		}//fin try

	}//fin borrarVhiculo()

	public void insertar(Vehiculo vh) throws Exception {
		String sql = "INSERT INTO VEHICULOS(marca, vehiculo, provincia, matricula, km)"
				+ " VALUES (?,?,?,?,?)";
		
		try(Connection conex = Database.getConnection();
				PreparedStatement pstmt = conex.prepareStatement(sql)){
			
			pstmt.setString(1, vh.getMarca());
			pstmt.setString(2, vh.getVehiculo());
			pstmt.setString(3, vh.getProvincia());
			pstmt.setString(4, vh.getMatricula());
			pstmt.setInt(5, vh.getKm());
			pstmt.executeUpdate();
			
		}//fin try
	}//fin insertar()
	
}//fin class
