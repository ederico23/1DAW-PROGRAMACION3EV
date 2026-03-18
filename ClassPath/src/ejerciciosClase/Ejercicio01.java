package ejerciciosClase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ejercicio01 {

	public static void main(String[] args) {

		Path ej1 = Path.of("ejercicios/ejercicio01.txt");
		
		String fraseAñadir = Leer.leerFrase("que frase quieres añadir?");
		
		try {
			Files.writeString(ej1, fraseAñadir, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			System.out.println("añadido correctamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error al añadir");
		}

	}

}
