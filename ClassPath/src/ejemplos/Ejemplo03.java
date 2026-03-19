package ejemplos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ejemplo03 {

	public static void main(String[] args) {
		Path p3 = Path.of("datos/ejemplo03.txt");
		 
		try(OutputStream os = Files.newOutputStream(p3, //si no pones nada de los siguientes 3
				StandardOpenOption.CREATE,  //java entiende que estan estos 3 por defecto
				StandardOpenOption.TRUNCATE_EXISTING,
				StandardOpenOption.WRITE
			)){
			
			String texto = "Hola\n";
			os.write(texto.getBytes());
			System.out.println("escritura completada");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("/////////////////////////////////");
		
		//falta el .2 append
		try (OutputStream os = Files.newOutputStream(p3, 
				StandardOpenOption.CREATE,
				StandardOpenOption.APPEND)){
			
			String texto = "Linea añadida con APPEND";
			os.write(texto.getBytes());
			
			System.out.println("append completado");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System.out.println("///////////////////////////////////");
		
		try (InputStream is = Files.newInputStream(p3, null)){
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
