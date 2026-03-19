package ejerciciosClase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio05 {
	
	public static void main(String[] args) {
		
		Path ej5 = Path.of(".");
		
		try {
			//el files.walk entra en la carpeta que le indiques, y mira en subcarpetas hasta que acabe
			List<Path> archivos = Files.walk(ej5).toList();
			
			for (Path a : archivos) {
				if (a.toString().endsWith(".txt")) {
					System.out.println("Archivos: " + a.getFileName());
					System.out.println("Pertenece al directorio " + a.getParent());
					System.out.println("Y contiene: \n" + Files.readAllLines(a) + "\n\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
