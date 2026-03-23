package ejerciciosClase;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 *Ejercicio 7.- Crea con el bloc de notas un fichero texto.txt con la palabra HOLA, lee su contenido
 *byte a byte con un InputStream y muestra los bytes obtenidos por consola. Interpreta el resultado.
 *	• Usa read() para leer byte a byte.
 *	• usa read(byte []) para leer.
 *	• Usa Files.readAllBytes(path)
 *
 * @author Eder Gracia
 * @version 1.0
 */

public class Ejercicio07 {
	
	public static void main(String[] args) {
		
		Path ej7 = Path.of("ejercicios/texto.txt");
		
		if(!Files.exists(ej7)) {
			System.out.println("archivo no encontrado");
			return;
		}
		
		//parte 1
		int n;
		InputStream in;
		
		try {
			in = Files.newInputStream(ej7);
			// el -1 es que ya no hay nada mas, si no se pone es bucle infinto de -1
			while((n = in.read()) !=-1) {
				System.out.println(n);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		//parte 2
		byte [] n2 = new byte [4];
		int bytesLeidos;
		InputStream in2;
		
		try {
			in2 = Files.newInputStream(ej7);
			// el -1 es que ya no hay nada mas, si no se pone es bucle infinto de -1
			while((bytesLeidos = in2.read(n2)) !=-1) {
				System.out.println("bytes leidos " + bytesLeidos); 
				
				System.out.println(Arrays.toString(n2));
				
			}
		} catch (IOException e2) {
			e2.printStackTrace();
			
		}
		
		//parte 3
		
	} //fin main
}//fin class
