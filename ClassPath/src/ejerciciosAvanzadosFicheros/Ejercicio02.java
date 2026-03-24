package ejerciciosAvanzadosFicheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Fichero puntuaciones.txt:
 * Ana:10
 * Luis:25
 * Ana:15
 * Haz un programa que:
 * 1. Sume las puntuaciones por jugador
 * 2. Muestre ranking ordenado de mayor a menor
 * 3. Guarde el resultado en ranking.txt
 * 	Nivel extra
 * 		● Usar Stream
 * 		● Mostrar solo top 3
 * 
 * @author Eder Gracia
 * @version 1.0 
 */

public class Ejercicio02 {

	public static void main(String[] args) {
		
		Path ej02 = Path.of("ejerciciosAvanzados/puntuaciones.txt");
		
		String usuario;
		String puntuacion;
		Map<String, Integer> usuarioPuntuacion = new HashMap();
		boolean usuarioCorrecto = false;
		
		//LEER FICHERO
		usuarioPuntuacion = leerArchivo(ej02);
		System.out.println(usuarioPuntuacion);
		
		//MOSTRAR ORDENADOR
		
	} //fin main
	
	public static Map<String, Integer> leerArchivo(Path ej02){
		
		Map<String, Integer> resultado = new HashMap<String, Integer>();
		
		//chek si existe archivo
		if(!Files.exists(ej02)) {
			System.out.println("Archivo no encontrado");
			System.exit(0);
		} //fin if
		
		try {
			List<String> lineasFichero = Files.readAllLines(ej02);
			
			for(String s : lineasFichero) {
				String[] linea = s.split(":");
				
				if(!resultado.containsKey(linea[0])) {  //SI NO EXISTE EL USUARIO, SE QUEDA CON
					resultado.put(linea[0], Integer.parseInt(linea[1])); //LOS PUNTOS QUE TIENE
				} else { //SI EXISTE EL USUARIO, SE COGE LOS VALORES ANTERIORES Y SE SUMAN AL NUEVO
					resultado.put(linea[0], resultado.get(linea[0])+Integer.parseInt(linea[1]));
				} //fin if
			}//fin for
		} catch (IOException e) {
			e.printStackTrace();
		} //fin catch
		
		return resultado;
	}
	

} //fin class
