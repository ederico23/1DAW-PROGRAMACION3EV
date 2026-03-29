package ejerciciosAvanzadosFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import ejerciciosClase.Leer;

/**
 *Ejercicio 4 — Buscador tipo “grep” simple
 *Enunciado
 *Pide al usuario una palabra y muestra:
 *	1. Las líneas donde aparece
 *	2. Número de veces que aparece
 *	3. Número de línea
 *	Nivel extra
 *		● Búsqueda sin distinguir mayúsculas 
 */

public class Ejercicio04 {

	public static void main(String[] args) {

		//VARIABLES
		Path ej04 = Path.of("ejerciciosAvanzados/ejercicio04.txt");
		int contadorLineas = 0;
		int contadorDeLineas = 1;
		int contadorPalabras = 0;



		if(!Files.exists(ej04)) {
			System.out.println("Archivo no encotrado");
			return;
		}



		//PREGUNTAR PALABRA
		String palabra = Leer.leerFrase("\n¿Que palabra quieres buscar?").toLowerCase();

		try (BufferedReader br = Files.newBufferedReader(ej04,StandardCharsets.UTF_8)){

			int numLinea = 1;
			int aparicioneS = 0;

			//LEER EL ARCHIVO
			String linea;
			while ((linea = br.readLine()) != null) {

				//partimos la linea 
				String[] palabrasLinea = linea.split("[ ,.;]");
				boolean encontradaEnLinea = false;
				int aparicionesLinea = 0;

				for (String p : palabrasLinea) {
					//ignoro mayus
					if(p.equalsIgnoreCase(palabra)) {
						aparicionesLinea++;
						aparicioneS++;
						encontradaEnLinea = true;
					}//fin if

				} //fin for

				//palabra en el texto
				if(encontradaEnLinea) {
					System.out.println("La palabra '" + palabra +"' está en " +
							"\nla linea " + linea + 
							" y \nen el texto aparece un total de " 
							+ aparicioneS + " veces");

				}//fin if

				numLinea++;
			} //fin while







		}


	}//fin main

}//fin class
