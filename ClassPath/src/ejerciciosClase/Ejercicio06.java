package ejerciciosClase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ejercicio06 {
	
	public static void main(String[] args) {
		
		Path ej6 = Path.of("ejercicios/configuracion.txt");
		
		if(Files.exists(ej6)) {
			Path ej6_1 = Path.of("ejercicios/configuracion_backup.txt");
			
			try {
				//si ejecutamos el programa dos veces saldria error pq ya exestiria el backup, entonces ponemos
				Path contenidoConfig = Files.copy(ej6, ej6_1, StandardCopyOption.REPLACE_EXISTING); //replace existin para reemplazar
				System.out.println("copadiado con exito");
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("error al copiar");
			}
		} else {
			System.out.println("error al copiar, no existe " + ej6.getFileName());
		}
		
		
	}
}
