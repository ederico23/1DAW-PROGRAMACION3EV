package ejerciciosAvanzadosFicheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejerciciosClase.Leer;

/**
 * Dispones de un fichero usuarios.txt con formato:
 * usuario:password
 * ana:1234
 * juan:abcd 
 * Haz un programa que:
 * 1. Pida usuario y contraseña
 * 2. Compruebe si existe en el fichero
 * 3. Permita 3 intentos
 * 4. Si falla, mostrar error
 * Nivel extra
 * ● Añadir usuario si no existe (APPEND)
 * ● Evitar duplicados
 * 
 * @author Eder Gracia
 * @version 1.0
 */

public class Ejercicio01 {

	public static void main(String[] args) {

		Path ej01 = Path.of("ejerciciosAvanzados/usuarios.txt");
		String usuario;
		String contraseña;
		Map<String, String> usuarioContraseña = new HashMap();
		final Integer TOTAL_INTENTOS = 3;
		Integer intentos = 0;
		boolean usuarioCorrecto = false;

		//leer el fichero
		usuarioContraseña = leerArchivo(ej01);

		//bucle, hacer mientras...
		while(intentos<TOTAL_INTENTOS && !usuarioCorrecto) {
			usuario = Leer.leerFrase("introduce tu usuario");
			contraseña = Leer.leerFrase("introduce tu contraseña");

			//chek si está en la lista
			if(usuarioContraseña.containsKey(usuario) &&
					usuarioContraseña.get(usuario).equals(contraseña)) {
				//el if = coge el mapa.contieneClave(usuario scaner) y mapa.get(usuario scanner).comparo con (contraseña scanner)

				usuarioCorrecto = true;
				System.out.println("usuario correcto");
			} else {
				intentos++;
				System.out.println("Usuario o contraseña incorrecto."
						+ "\nTe quedan " + intentos + " intentos");
			}
		}
		
		System.out.println("fin del programa");

	} //fin main

	public static Map<String, String> leerArchivo(Path ej01){

		Map<String,String> resultado = new HashMap<String, String>();

		//chek si existe archivo
		if(!Files.exists(ej01)){
			System.out.println("Este archivo no existe");
			System.exit(0);//salimos
		}

		List<String> lineasFichero = null;

		try {
			lineasFichero = Files.readAllLines(ej01);

			//s = usuario:constraseña
			for (String s : lineasFichero) {
				//lee hasta que se encuentre lo que pongas ""
				String[] linea = s.split(":");
				resultado.put(linea[0], linea[1]);
			} //fin for

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;

	} //fin leerArchivo



} //fin class
