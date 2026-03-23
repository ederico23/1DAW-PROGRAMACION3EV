package ejerciciosClase;

/**
 * Ejercicio 2.- Crea una aplicación que añada a un fichero log.txt en la ruta “/logs/log.txt” la
 * siguiente información.• Programa ejecutado “fecha y hora de la ejecución”
 * 
 *  @author Eder Gracia
 *  @version 1.0
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		Path ej2 = Path.of("logs/log.txt");
		//para coger la hora
		LocalDateTime fechaHora = LocalDateTime.now();
		//formato a la hora
		DateTimeFormatter conFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		//DateTimeFormatter otroFormato = DateTimeFormatter. Y AQUI SALEN TODAS LAS PREDEFINIDAS
		//unir la hora y el formato
		String fechaHoraConFormato = fechaHora.format(conFormato);
		
		try {
			Files.createDirectories(ej2.getParent());
			Files.writeString(ej2, "programa ejecutado: " + fechaHoraConFormato + "\n ", 
					StandardCharsets.UTF_8, 
					StandardOpenOption.CREATE, 
					StandardOpenOption.APPEND);
			
			System.out.println("se ha añadido con exito");
			
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("error al añadir");
		} //fin catch
		
	}//fin main

} //fin class 
