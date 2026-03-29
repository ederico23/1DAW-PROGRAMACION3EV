package ejerciciosAvanzadosFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

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
		int contadorTotal = 0;
		String palabraBuscar;
		List<String> lineas;
		
		//TIENE QUE ESTAR CREADO
		if(!Files.exists(ej04)) {
			System.out.println("Archivo no encotrado");
			return;
		} //fin if
		
		//PROCESO
		palabraBuscar = Leer.leerFrase("¿Que palabra quieres buscar?");
		
		try {
			//LEEMOS LAS LINEAS
			lineas = Files.readAllLines(ej04);
			
			//FOR PARA RECORRER TODAS LAS LINEAS
			for( String l : lineas) {
				
				//CONTAMOS LAS VECES QUE APARECE LA PALABRA A TRAVES DEL METODO
				 Integer veces = contarApariciones(l, palabraBuscar);
				 
				 //IMPRIMIMOS EL MENSAJE RESUMEN DE LA BUSQUEDA
				 //el indexOf coge el numero de la linea pero empieza en 0 asique sumamos 1 para que empiece en 1
				 System.out.println("En la linea " + (lineas.indexOf(l)+1) + " la palabra " + palabraBuscar + 
						 " aparece un total de " + veces + " veces");
				 contadorTotal = contadorTotal + veces;
				
			} //fin for
			
			//RESUMEN FINAL
			System.out.println("En el archivo " + ej04.getFileName() + ", la palabra " + palabraBuscar +
					" aparece " + contadorTotal + " veces");
			  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fin trycatch
		
		
	}//fin main

	private static Integer contarApariciones(String l, String palabraBuscar) {
		
		Integer contador = 0;
		
		//dividimos las palabras 
		String[] palabras = l.split("[ ,.;]");
		
		//recorremos las palabras y cuentolas veces que coinciden con la palabraBuscar
		for(String p : palabras) {
			
			if(p.equalsIgnoreCase(palabraBuscar)) {
				contador++;
			} //fin if
			
		}//fin for
		
		return contador;
	}

}//fin class
