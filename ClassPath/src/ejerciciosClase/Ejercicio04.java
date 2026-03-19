package ejerciciosClase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ejercicio04 {
	
	public static void main(String[] args) {
	
		Path ej4 = Path.of("ejercicios/diario.txt");
		
		int opcion = 1;
		do {
			System.out.println("0- Salir");
			System.out.println("1- Añadir nota");
			System.out.println("2- Mostrar diario");
			
			opcion = Leer.leerEntero("Escoge una opcion");
			
			switch (opcion){
			case 0:
				System.out.println("adios");
				break;
			
			case 1: 
				String textoAñadir = Leer.leerFrase("Que quieres añadir a tu diario?");
				
				
				try {
					Files.writeString(ej4, textoAñadir +"\n", 
							StandardCharsets.UTF_8, StandardOpenOption.CREATE ,StandardOpenOption.APPEND); 
					
						} catch (IOException e){
						e.printStackTrace();
					} //fin catch
				break;
				
			case 2:
				try {
					String mostrarDiario = Files.readString(ej4);
					System.out.println(mostrarDiario);
				} catch (IOException e) {
					e.printStackTrace();
					} //fin catch
				break;
				
				} //fin switch
			
		} while (opcion!=0);
		
		
		
	} //fin main
} //fin class
