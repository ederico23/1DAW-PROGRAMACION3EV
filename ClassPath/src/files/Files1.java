package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Files1 {

	public static void main(String[] args) {
		Path p = Path.of("datos/mensaje.txt");
//		try {
//			// Esto tiene como "option" por defecto, sobreescribir el archivo
//			Files.writeString(p, "Hola DAM");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			// Esto tiene como "option" por defecto, sobreescribir el archivo
//			Files.writeString(p, "Mensaje añadido", StandardOpenOption.APPEND);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		//////////////////////////////////////////////////
		
		// Leer contenido de un archivo
		
		Path p2 = Path.of("datos/datos.txt");
		try {
			String contenido = Files.readString(p2);
			System.out.println(contenido);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//////////////////////////////////////////////
		
		// Copiar contenido de un archivo
		Path p3 = Path.of("datos/copiaP3");
		try {
			Files.copy(p, p3);
			System.out.println(Files.readString(p3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}