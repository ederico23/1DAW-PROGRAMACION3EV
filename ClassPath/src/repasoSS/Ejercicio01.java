package repasoSS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Ejercicio 1 — Sistema de login con
fichero
Enunciado
Dispones de un fichero usuarios.txt con formato:
usuario:password
ana:1234
juan:abcd
Haz un programa que:
1. Pida usuario y contraseña
2. Compruebe si existe en el fichero
3. Permita 3 intentos
4. Si falla, mostrar error
Nivel extra
● Añadir usuario si no existe (APPEND)
● Evitar duplicados

@author ederg
@version 1.0
 */

import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Ejercicio01 {

	public static void main(String[] args) {
		//VARIABLES A USAR
			Path path = Path.of("repasoSS/ejercicio01.txt"); //ruta y archivo
			String usuario;
			String password;
			final int INTENTOS_TOTALES = 3;
			int contadorIntentos = 0;
			boolean coinciden = false;
			
			//si no existe el archivo, mensaje y se acaba
			if(!Files.exists(path)) {
				System.out.println("Archivo no encontrado");
				return;
			}
			
			
			do {

				//archivo existe, entonces, preguntamos
				usuario = Leer.leerFrase("Introduce tu usuario");
				password = Leer.leerFrase("Introduce la contraseña");
				
				contadorIntentos++;
				
				try {
					List<String> lineas = Files.readAllLines(path);
					
					for(String l : lineas) {
						String[] separada = l.split("[:]");
						
						if(separada[0].equals(usuario) && separada[1].equals(password)) {
							System.out.println("Inicio sesion correcto");
							coinciden = true;
							return;
						}//fin if
						
						
					}//fin for
					
					if(!coinciden) {
					System.err.println("Error al iniciar sesion");
					System.out.println("Te quedan " + (INTENTOS_TOTALES-contadorIntentos) + " intentos");
					} //fin if
					
					
				} catch (IOException e) {
					e.printStackTrace();
				} //fin trycatch
				
				
			} while (coinciden == false && contadorIntentos < INTENTOS_TOTALES);
			
			
			String crearUsuario = Leer.leerFrase("¿Quieres crear un nuevo usuario?");
			String nuevoUsuario;
			String nuevaPassword;
			
			
			if(crearUsuario.equalsIgnoreCase("si")) {
				
				List<String> lineas;
				boolean yaExiste = false;
				
				nuevoUsuario = Leer.leerFrase("Escribe el usuario que quieres añadir");
				nuevaPassword = Leer.leerFrase("Escribe la contraseña para el usuario '" + nuevoUsuario + "'");
					
				try {
					lineas = Files.readAllLines(path);
					for(String l : lineas) {
						String[] usu = l.split("[:]");
						
						if(usu[0].equalsIgnoreCase(nuevoUsuario)) {
							
							yaExiste = true;
						}
						
					}//fin for
					
					if(yaExiste == false) {
						String personaNueva = "\n" + nuevoUsuario + ":" + nuevaPassword;
						Files.writeString(path, personaNueva, StandardOpenOption.APPEND);
						System.out.println("Nuevo usuario registrado");
					} else {
						System.out.println("Usuario ya existente");
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//fin trycatch 
				
			} else {
				System.out.println("ADIOS");
			}//fin if
			
			
	}//fin main

}//fin class
