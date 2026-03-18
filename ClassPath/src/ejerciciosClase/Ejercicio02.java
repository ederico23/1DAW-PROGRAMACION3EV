package ejerciciosClase;

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
		LocalDateTime fechaHora = LocalDateTime.now();
		DateTimeFormatter conFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fechaHoraConFormato = fechaHora.format(conFormato);
		
		try {
			Files.createDirectories(ej2.getParent());
			Files.writeString(ej2, "programa ejecutado: " + fechaHoraConFormato + "\n ", StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			System.out.println("se ha añadido con exito");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error al añadir");
		}
		
	}

}
