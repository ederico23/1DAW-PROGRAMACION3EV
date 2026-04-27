package ejemplos;

import java.sql.Statement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ejemplo01 {

	//libreria:bd:archivo
	static String url =  "jdbc:sqlite:prueba.db";
	
	public static void main(String[] args) {
		
		//crearUsuarios("Eder", 18);
		actualizarUsuario(8, "Eder", 18);
		leerUsuarios();
		
		
	}//fin main

	
	
	/**
	 * METODO PARA CREAR NUEVOS USUARIOS
	 * @param nombre
	 * @param edad
	 */
	public static void crearUsuarios(String nombre, int edad) {
		
		//creamos el string con la sentencia sql, los ? es para indiccar despues que tipo de valor va ahi
		String sql = "INSERT INTO USUARIOS(NOMBRE,EDAD) VALUES (?,?)";
		
		// try(para tener conexion con la base de datos)
		try (Connection conex = DriverManager.getConnection(url)){
			//pre- sentencia para luego poder indicar el tipo de dato de los ?, esto contiene la sentencia sql
			PreparedStatement pstmt = conex.prepareStatement(sql);
			
			//setTipoDato(num ?, valor)
			pstmt.setString(1, nombre);
			pstmt.setInt(2, edad);
			
			//ejecutar la actualizacion de los valores
			pstmt.executeUpdate();
			
			System.out.println("Usuario creado");
		} catch (Exception ex){
			ex.getMessage();
		}//fin try catch
		
	}//fin crearUsuarios()
	
	
	public static void leerUsuarios() {
		
		//sentencia sql
		String sql = "SELECT * FROM USUARIOS";
		
		// try(para tener conexion con la base de datos)
		try (Connection conex = DriverManager.getConnection(url)) {
			//preparar el comando
			Statement stmt = conex.createStatement();
			
			//ejecutar sentencias de select y devuelve el tipo ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			
			//rs.next() coloca en rs el siguiente resultado y devuelve false si hemos alcanzado el último
			//rs.next() coloca el cursor rs en el siguiente dato, devuelve false si hemos llegado al final
			while(rs.next()) {
				System.out.println(
						"id - " + rs.getInt("id") + "\n" //rs.getInt(“id”) devuelve un entero con el id del dato en la posición del cursor del ResultSet
						+"nombre - " + rs.getString("nombre") + "\n" //rs.getString(“nombre”) devuelve el nombre del dato en la posición del cursor del Resultset 
						+"edad - " + rs.getInt("edad") //rs.getInt(“edad”) devuelve un entero con la edad del dato en la posición del cursor. del resultset
						+ " \n---------------------------------------------------\n "
						);
			}//fin while
		} catch(Exception ex) {
			ex.getMessage();
		} //fin trycatch
		
	}//fin leerUsuarios()
	
	public static void actualizarUsuario(int id, String nombre, int edad){
		
		//sentencia sql
		String sql = "UPDATE usuarios SET nombre = ?, edad = ? WHERE id = ?";
		
		// try(para tener conexion con la base de datos)
		try (Connection conex = DriverManager.getConnection(url)){
			
			//pre- sentencia para luego poder indicar el tipo de dato de los ?, esto contiene la sentencia sql
			PreparedStatement pstmt = conex.prepareStatement(sql);
			
			pstmt.setString(1, nombre);
			pstmt.setInt(2, edad);
			pstmt.setInt(3, id);
			
			pstmt.executeUpdate();
			
			System.out.println("Usuario actualizado");
		} catch (Exception ex) {
			ex.getMessage();
		}//fin trycatch
				
		
	}//fin actualizarUsuario()
	
	public static void eliminarUsuario(int id) {
		String sql = "DELETE FROM USUARIOS WHERE ID=?";
		
		try (Connection conex = DriverManager.getConnection(url);
			PreparedStatement pstmt = conex.prepareStatement(sql)){
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.getMessage();
		}//fin try catch
	}//fin eliminarUsuario
	
	
	
}//fin class
