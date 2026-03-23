package ejemplos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ejemplo05 {

	public static void main(String[] args) {
		//escribir
		//1. creamos ruta
		Path ejem05 = Path.of("datos/ejemplo05.dat");
		
		try (DataOutputStream dataOut = new DataOutputStream(Files.newOutputStream(ejem05, 
				StandardOpenOption.CREATE,
				StandardOpenOption.APPEND))){
			//2. creamos outputstream
			OutputStream out = Files.newOutputStream(ejem05);		
			
			for(int i = 0; i<=100; i++) {
				dataOut.writeInt(i);
			}
			
			dataOut.flush(); //para VACIAR	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//leer
		
		try(InputStream in = Files.newInputStream(ejem05);
				DataInputStream dataIn = new DataInputStream(Files.newInputStream(ejem05))) {
					
			int numero;
			while(true) {
				numero = dataIn.readInt();
				System.out.println(numero);
				
			}
				} catch (IOException e) {
					System.out.println("fin fichero");
					
				}
		
	}

}
