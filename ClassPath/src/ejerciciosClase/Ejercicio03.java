package ejerciciosClase;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio03 {

	public static void main(String[] args) {
		Path ej3 = Path.of("logs/log.txt");
		
		List <String >lineas;
		try {
			lineas = Files.readAllLines(ej3);
			for (String l : lineas) {
				System.out.println(l);
			}
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
