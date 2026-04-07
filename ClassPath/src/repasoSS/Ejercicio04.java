package repasoSS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Ejercicio 4 — Buscador tipo “grep”
simple
Enunciado
Pide al usuario una palabra y muestra:
1. Las líneas donde aparece
2. Número de veces que aparece
3. Número de línea
Nivel extra
● Búsqueda sin distinguir mayúsculas

 */

public class Ejercicio04 {

	public static void main(String[] args) {

		Path path = Path.of("repasoSS/ejercicio04.txt");
		
		int opcion = 0;
		int menu;
		
		int numAparicionesTotales = 0;
		
		do {
			
			System.out.println("---BUSCADOR---");
			System.out.println("0. Salir");
			System.out.println("1. Mostrar texto");
			System.out.println("2. Buscar palabra");
			
			opcion = Leer.leerEntero("Elige que quieres hacer");
			
			switch (opcion){
			case 0:
				System.out.println("Adios");
				break;
			
			case 1:
				try {
					String texto = Files.readString(path);
					System.out.println(texto);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//fin trycatch
				break;
			
			case 2:
				buscarPalabra(path);
				
			}//fin switch
			
			
		} while (opcion != 0);
		
		
	}//fin main

	private static void buscarPalabra(Path path) {
	    String palabraBuscar = Leer.leerFrase("¿Qué palabra quieres buscar?");
	    int totales = 0; // Para el contador global

	    try {
	        List<String> lineas = Files.readAllLines(path);

	        //tener la "i" como número de línea
	        for (int i = 0; i < lineas.size(); i++) {
	            String lineaActual = lineas.get(i);
	            int aparicionesEnEstaLinea = 0;

	            
	            String[] palabrasDeLaLinea = lineaActual.split("[ ,.:;]+");

	            for (String p : palabrasDeLaLinea) {
	                
	                if (p.equalsIgnoreCase(palabraBuscar)) {
	                    aparicionesEnEstaLinea++;
	                    totales++;
	                }//fin if
	            }//fin for palabras

	            // Si ha aparecido al menos una vez, informamos
	            if (aparicionesEnEstaLinea > 0) {
	                System.out.println("Línea " + (i + 1) + " [" + aparicionesEnEstaLinea + " veces]: " + lineaActual);
	            }
	        }//fin for normal

	        System.out.println(">> Total de apariciones en el archivo: " + totales);
	        System.out.println();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }//fin trycatch
	}//fin buscarPAlabar

}//fin class
