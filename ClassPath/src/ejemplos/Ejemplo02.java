package ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Ejemplo02 {

	public static void main(String[] args) {
		//escribir en un archivo
		Path p = Path.of("datos/ejemplo02.txt");
		
		List<String> lineas = List.of("\nHola", "Mundo", "Java");
		try {
			Files.write(p, lineas, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			System.out.println(lineas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("////////////////////////////////");
		//esto me ha sobreescrito lo que tenia puesto, vale ya no al poner el APPEND
		try {
			Files.writeString(p, "Adios" , StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("///////////////////////////7");
		
		//tambien sobreescribe lo que habia antes,  vale ya no al poner el APPEND
		try (BufferedWriter bw = Files.newBufferedWriter(p, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
			bw.write("\nComo");
			bw.newLine();
			bw.write("estas?");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("//////////////////////////////////////777");
		
		byte[] datos = "\nHola Mundo".getBytes();
		try {
			Files.write(p, datos, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
