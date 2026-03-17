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
		
		//sirve para pegar 2 rutas
		Path carpeta = Path.of("datos");
		Path archivo = carpeta.resolve("notas.txt"); // = datos/notas.txt
		
		//la ruta que hay que seguir para llegar a otra
		Path rutaA = Path.of("usuarios/pepe");
		Path rutaB = Path.of("usuarios/pepe/documentos/facturas.pdf");
		
		Path relativa = rutaA.relativize(rutaB);
		System.out.println(relativa);
		
		//saber en que carpeta esta guardado algo sin improtar el nombre del archivo
		Path rutaLarga = Path.of("C:/Usiarios/Proyectos/Java/Main.java");
		
		int niveles = rutaLarga.getNameCount();
		System.out.println("la ruta tiene " + niveles + " niveles");
		System.out.println("el archivo es " + rutaLarga.getName(niveles - 1));
		
		//comprueba si la cadena de texto de la ruta empieza o termina por donde le indiques
		Path p = Path.of("datos/config/setup.exe");
		
		System.out.println("Es un ejecutable? " + p.endsWith("setup.exe"));
		System.out.println("Esta en la carpeta de datos? " + p.startsWith("datos"));
		
		
	}

}
