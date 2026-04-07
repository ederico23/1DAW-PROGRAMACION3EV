package ejerciciosAdvanzados2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import ejerciciosClase.Leer;


/**
 * Ejercicio 1.-
Crea una aplicación que realice las siguientes tareas:
• Pida por consola la rute relativa de un archivo.
• Si el archivo no existe, imprima un mensaje por pantalla de error y cierre la aplicación.
• Si el archivo existe muestre el contenido del archivo
◦ En bytes
◦ En texto.

 */

public class Ejercicio01 {

	public static void main(String[] args) {

		String ruta = Leer.leerFrase("Escribe la ruta relativo de un archivo");
		Path path = Path.of(ruta);
		
		if(!Files.exists(path)){
			System.err.println("ERROR, no existe el archivo. \nADIOS");
			return;
		}//fin if

		try {
			System.out.println("EN BYTES");
			
			byte[] enBytes = Files.readAllBytes(path);
			
			for(byte b : enBytes) {
				System.out.println(b + " ");
			}//fin for
			
			
			System.out.println("\nEN TEXTO");
			
			String enTexto = Files.readString(path);
			System.out.println(enTexto);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fin trycatch
		
	}//fin main

}//fin class
