package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Files1 {
	Path p = Path.of("datos/mensaje.txt");

	try {
		//tiene como option por defecto y hay que sobreescribir el archivo
		Files.writeString(p, "Hola");
	} catch (IOException e) {
		e.printStackTrace();
		}


	try {
		//tiene como option por defecto y hay que sobreescribir el archivo
		Files.writeString(p, "HolaSSS", StandardOpenOption.APPEND);
	} catch (IOException e2) {
		e.printStackTrace();
		}
}

	//LEER CONTENIDO

	Path rutaLeer = Path.of("datos/datos.txt");
	
	try {
		String contenido = Files.readString(rutaLeer);
		System.out.println(contenido);
	} catch (IOException e3) {
		e.printStackTrace();

		
	//COPIAR UN ARCHIVO
		
	Path p3 = Path.of("datos/copia.txt");
		
	try {
		Files.copy(p, Path.of("datos/datos.txt"));
		System.out.println(Files.readString(p3));
	} catch (IOException e4) {
		
	}
		
		
}
