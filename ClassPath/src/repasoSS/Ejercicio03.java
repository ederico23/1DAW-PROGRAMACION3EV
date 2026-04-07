package repasoSS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 3 — Limpieza de fichero
Enunciado
Dado un fichero con líneas repetidas:
hola
adios
hola
hola
adios
Haz un programa que:
1. Elimine duplicados
2. Mantenga el orden original
3. Sobrescriba el fichero
Nivel extra
● Ignorar mayúsculas/minúsculas 
 */

public class Ejercicio03 {

	public static void main(String[] args) {
		//creamos variables
		Path path = Path.of("repasoSS/ejercicio03.txt");
		List<String> lineas;//leer lineas
		List<String> resultado = new ArrayList<>();//palabras finales
		List<String> palabraVista = new ArrayList<>();//palabras vistas antes de confirmar
		
		//leer 
		try {
			lineas = Files.readAllLines(path);
			
			for(String l : lineas) { //leer cada linea
				String minuscula = l.toLowerCase(); //palabras a minusculas
				if(!palabraVista.contains(minuscula)) { //hemos visto la palabra en minusculas?
					palabraVista.add(minuscula); //si es nueva, ya esta vista la palabra
					resultado.add(l);//la guardamos en la lista final
				}//fin if
				
			}//fin for
			
			//sobreescribir
			Files.write(path,resultado);
			System.out.println("Archivo actualizado");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fin trycatch

	}//fin main

}//fin class
