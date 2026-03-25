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
		
		Path ej04 = Path.of("ejerciciosAvanzados/ejercicio04.txt");
		
		if(!Files.exists(ej04)) {
			System.out.println("Archivo no encotrado");
			return;
		}
		
		try (BufferedReader br = Files.newBufferedReader(ej04,StandardCharsets.UTF_8)){
			//LEER EL ARCHIVO
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				System.out.println(Arrays.toString(linea.split("[ ,.;]")));
			}
			
			//PREGUNTAR PALABRA
			String palabra = Leer.leerFrase("\n¿Que palabra quieres buscar?");
			
			
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fin trycatch 

		
		
	}//fin main

}//fin class
