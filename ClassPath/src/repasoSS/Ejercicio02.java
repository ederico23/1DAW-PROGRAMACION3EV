package repasoSS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Ejercicio 2 — Ranking desde fichero
Enunciado
Fichero puntuaciones.txt:
Ana:10
Luis:25
Ana:15
Eder:35
Juan:26
Haz un programa que:
1. Sume las puntuaciones por jugador
2. Muestre ranking ordenado de mayor a menor
3. Guarde el resultado en ranking.txt
Nivel extra
● Usar Stream
● Mostrar solo top 3
 */

public class Ejercicio02 {

	public static void main(String[] args) {
		//VARIABLES A USAR 
		Path path = Path.of("repasoSS/ejercicio02.txt");
		Map<String, Integer> jugadoresPuntuaciones = new HashMap<>();
		String[] separadas;
		String nombre;
		List<String> lineas;
		int puntos;
		
		try {
			lineas = Files.readAllLines(path); //leemos las lineas	
			
			for(String l : lineas) { //leemos todas las lineas y las separamos de 1 en 1
				separadas = l.split("[:]");//separamos en 2 las lineas, antes de los : y despues (nombre:puntos)
				nombre = separadas[0].trim(); //el trim por si se me cuelan espacios
				puntos= Integer.parseInt(separadas[1].trim()); //esto coge los puntos, los convierte a int y sin espacios
				
				if(jugadoresPuntuaciones.containsKey(nombre)) {//si el mapa ya contiene el nombre
					
					puntos = puntos + jugadoresPuntuaciones.get(nombre);//para coger el "values" (los puntos)  de la key (nombre) y los sumamos a los puntos
					jugadoresPuntuaciones.put(nombre, puntos);//actualizamos los puntos
					
				} else { //si no existia el jugador
					jugadoresPuntuaciones.put(nombre, puntos);
				}//fin if jugadores existian
				
			}//fin for leerLineas
			
			
			//creamos la nueva lista para guardar el ranking
			List<Map.Entry<String, Integer>> ranking = new ArrayList<>(jugadoresPuntuaciones.entrySet());
			//.sort(a,b) [cogemos a y b] -> [haz lo siguiente] b.getValue()[pts de b].compareTo(a.getValue)[comparalos con pts de a]
			ranking.sort((a,b)->b.getValue().compareTo(a.getValue()));
			
			List<String> rankingFinal = new ArrayList<>(); //para poder escribir, pq no se puede escribir un map
			int contador = 0;
			for(Map.Entry<String, Integer> r : ranking) {//recorremos el ranking
				
				if(contador == 3) {
					break;
				}
				
				String nombres = r.getKey(); //metemos la clave en una variable
				Integer pts = r.getValue(); //metemos values en una variable
				rankingFinal.add(nombres + ":" + pts); //añadimos con formato
				
				contador++;
			} //fin for ranking
			
			//lo metemos al nuevo fichero
			Path path2 = Path.of("repasoSS/ejercicios02Ranking.txt");//nueva ruta yy
			Files.write(path2, rankingFinal);//lo escribimos
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fin trycatch
		
		System.out.println("Ranking hecho");
		

	}//fin main

}//fin class
