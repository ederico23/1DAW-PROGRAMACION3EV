package path;


import java.nio.file.Path;

public class Path1 {
	public static void main(String[] args) {
		// Crea una ruta. No el archivo
		// Ruta relativa partiendo de la carpeta raiz del proyecto
		Path ruta = Path.of("datos/archivo.txt");
		
		// Devuelve el nombre del archivo de la ruta
		System.out.println("Nombre: " + ruta.getFileName());
		
		// Devuelve el nombre de la carpeta padre del archivo
		System.out.println("Padre: " + ruta.getParent());
		
		// Devuelve un objeto con la ruta absoluta
		System.out.println("Absoluta: " + ruta.toAbsolutePath());
		
		// Devuelve un booleano si el elemento terminal de la ruta coincide
		System.out.println(ruta.endsWith("archivo.txt")); //devolverá true pq el ultimo "bloque" es lit archivo.txt
		
		// ATENCION
		System.out.println(ruta.endsWith("txt")); // es false pq mira los nombres
		System.out.println(ruta.getFileName().toString().endsWith("txt")); // es true
		//.toString convierte el Path en un String, .endsWith para ver si acaba con txt
		//la diferencia entre las 2 esque el primero busca una carpeta o archivo y el segundo mira TODAS las letras
		
		// Contar elementos de una ruta
		Path p = Path.of("a/b/c/d.txt");
		for (int i = 0; i < p.getNameCount(); i++) {
			System.out.println(p.getName(i));
		}
		
		// Construir rutas nuevas a partir de una base
		Path p2 = Path.of("usuarios");
		System.out.println(p2.resolve("juan/info.txt"));
		
		// usuarios/juan/info.txt
		// Construir rutas
		Path p3 = Path.of("datos", "2026", "enero.txt");
		
		// datos/2026/enero.txt
		String usuario = "ana";
		System.out.println(Path.of("usuarios", usuario, "perfil.json"));
		
	}
}