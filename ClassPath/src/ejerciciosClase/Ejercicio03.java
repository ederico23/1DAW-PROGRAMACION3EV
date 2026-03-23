 package ejerciciosClase;

/**
 * Ejercicio 3.- Crea una aplicación que lea el fichero log.txt y lo escriba por consola.
 * 
 * @author Eder Gracia
 * @version 1.0
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio03 {

	public static void main(String[] args) {
		Path ej3 = Path.of("logs/log.txt");
		
		List <String >lineas;
		try {
			lineas = Files.readAllLines(ej3);
			for (String l : lineas) {
				System.out.println(l);
			}
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
