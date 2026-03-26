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
		
		

		
		
	}//fin main

}//fin class
