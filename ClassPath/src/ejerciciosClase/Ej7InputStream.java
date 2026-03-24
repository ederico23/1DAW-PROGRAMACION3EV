package ejerciciosClase;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/*
 * Ejercicio 7.- Crea con el bloc de notas un fichero texto.txt con la palabra HOLA, lee su contenido
byte a byte con un InputStream y muestra los bytes obtenidos por consola. Interpreta el resultado.
• Usa read() para leer byte a byte.
• usa read(byte []) para leer.
• Usa Files.readAllBytes(path);
 */
public class Ej7InputStream {

	public static void main(String[] args) {
		Path path = Path.of("documentos/texto.txt");
		
		if (!Files.exists(path)) {
			System.out.println("Fichero inexistente");
			return;
		}
		// Primera parte del ejercicio
		int n;
		InputStream in;
		try {
			in = Files.newInputStream(path);
			while ((n=in.read()) != -1) {
				System.out.print((char)n); // Lo podemos castear a caracteres
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n=====================");
		// Segunda parte del ejercicio
		byte[] n2 = new byte [4];
		int bytesLeidos;
		try {
			in = Files.newInputStream(path);
			while ((bytesLeidos = in.read()) != -1) {
				bytesLeidos = in.read(n2); // solo hacemos el entero para poder hacer la condicion del while
				System.out.println("Bytes leidos " + bytesLeidos);
				System.out.print(Arrays.toString(n2)); // Lo podemos castear a caracteres
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
