package controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.swing.JOptionPane;

public class ControllerFichero {
	
	
	static Path path = Path.of("usuarioContraseña.txt");
	static List<String> lineas;
	static String[] separadas;
	static String validezPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
	
	//LEER
	public static void leerFichero() {
		try {
			lineas = Files.readAllLines(path);
			
			for(String l : lineas) {
				separadas = l.split("[ :]");
			}//fin for
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//REGISTRARSE
	public static boolean buscarUsuario(String nombreABuscar) {
		leerFichero();
		if(lineas == null || lineas.isEmpty()) {
			return false;
		}//fin if vacio o no valido
		for(String l : lineas) {
			String[] partes = l.split("[:]");
			if(partes[0].trim().equalsIgnoreCase(nombreABuscar.trim())) {
				return true; //ya existe
			}//fin if
		}//fin for
		return false; //no existe
	}//fin buscarUsuario()
	
	public static boolean passwordValida(String passwordNueva) {
		
		return passwordNueva.matches(validezPassword);
		
	}//fin passwordExiste()

	/**
	 * @return the path
	 */
	public static Path getPath() {
		return path;
	}//fin getPath()
	
	//INICIAR SESION
	public static boolean comprobarUsuario(String nombreABuscar) throws UsuarioNoEncontradoException{
		if(lineas == null || lineas.isEmpty()) {
			return false;
		}//fin if vacio o no valido
		
		for(String l : lineas) {
			String[] partes = l.split("[ :]");
			if(partes[0].trim().equalsIgnoreCase(nombreABuscar.trim())) {
				return true; //ya existe
			}//fin if
		}//fin for
		return false; //no existe
		
	}//fin comprobarUsuario()
	
	
	public static boolean comprobarPassword(String nombre, String passwordNueva) throws UsuarioNoEncontradoException, PasswordIncorrectaException {
		if(passwordNueva.isEmpty() || passwordNueva == null){
			return false;
		}
		
		for (String l : lineas) {
			String[] separadas = l.split("[ : ]");
			String nombreBueno = separadas[0].trim();
			String passwordBuena = separadas[1].trim();
			
			if(nombreBueno.equalsIgnoreCase(nombre)) {
				if(passwordBuena.equals(passwordNueva)) {
					return true;
				} else {
					throw new PasswordIncorrectaException();
				}//fin if contraseña
			}//fin if nombre 
			
		}//fin for
		
		throw new UsuarioNoEncontradoException();
		
		
	}//fin passwordExiste()
	
}//fin class
