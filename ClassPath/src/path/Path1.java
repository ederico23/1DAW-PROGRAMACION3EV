package path;

import java.nio.file.Path;

public class Path1 {

	public static void main(String[] args) {
		//crea una ruta, no el archivo
		//ruta relativa partiendo de la carpeta raiz del proyecto
		Path ruta = Path.of("datos/archivos.txt");
		
		//devuelve el nombre del archivo al que apunta, deuelve un Path
		System.out.println("Nombre: " + ruta.getFileName());
		
		//devuelve el directorio padre
		System.out.println("padre " + ruta.getParent());
		
		//devuelve un ojeto Path con la ruta absoluta
		System.out.println("absoluta: " + ruta.toAbsolutePath());
		
		//devuelve un boolean si el elemento terminal de la ruta coincide
		System.out.println(ruta.endsWith("archivos.txt"));
		
		
	}

}
