package controlador;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Usuario;
import vista.VistaRegistrarse;

public class ControllerVistaRegistarse {
	
//	static String nombre = vista.VistaRegistrarse.getNombre();
//	static String password = vista.VistaRegistrarse.getPassword();
	
	public static void comprobarTodo(Usuario user) throws UsuarioRegistradoException, PasswordInvalidaException{
		String nombre = user.getNombre();
		String password = user.getContraseña();
		
		ControllerFichero.leerFichero();
		
		if(!ControllerFichero.buscarUsuario(nombre)) {
			throw new UsuarioRegistradoException();
		}//fin if validacion usuario
		
		if(!ControllerFichero.passwordValida(password)) {
			throw new PasswordInvalidaException();
		}
	}//fin comprobarTodo()

	
	public static void registroCompletado(Usuario user) {
		Path path = ControllerFichero.getPath();
		String nombre = user.getNombre();
		String password = user.getContraseña();
		String datos = nombre + ":" + password;
		try {	
			Files.writeString(path, datos + "\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			ControllerFichero.leerFichero(); //para que no haya duplicados
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos", "Error", JOptionPane.ERROR_MESSAGE);
		}//fin trycatch
		
	}//fin registroCompletado()
	
	
	
	
}//fin class
