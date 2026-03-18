package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Ejemplo01 {

	public static void main(String[] args) {

		Path p1 = Path.of("datos/ejemplo01.txt");

		List<String> lineas;
		try {
			lineas = Files.readAllLines(p1, StandardCharsets.UTF_8);
			for(String l : lineas) {
				System.out.println(l);
			}
			System.out.println(lineas.getFirst());
			
			//mirar este
			System.out.println(lineas.add("añado"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		/////////////////////////////////////////
		System.out.println("/////////////////////////////");
		
		try {
			String contenido2 = Files.readString(p1);
			System.out.println(contenido2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/////////////////////////////////////////////
		System.out.println("//////////////////////////////");
		
		Path p2 = Path.of("datos/ejemplo01_2.txt");
		try (Stream<String> lineas2 = Files.lines(p2, StandardCharsets.UTF_8)){
			lineas2.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		////////////////////////////////////////////////////
		System.out.println("/////////////////////////////////");
		
		try (BufferedReader br = Files.newBufferedReader(p2, StandardCharsets.UTF_8)){
			String lin;
			while ((lin = br.readLine()) != null) {
				System.out.println(lin);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/////////////////////////////////////////////////////////////////
		System.out.println("///////////////////////////////////////777");
		
		try {
			byte[] datos = Files.readAllBytes(p2);
			
			for(byte d : datos) {
				System.out.print(d + " ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}


