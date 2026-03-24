package ejemplos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class EjemplosDataInpuOutput {

	public static void main(String[] args) {
		
		// Ruta
		Path ruta = Path.of("datos.dat");
		
		// OutputStream
		try {
			OutputStream out = Files.newOutputStream(ruta, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			// DataOutputStream
			DataOutputStream dataOut = new DataOutputStream(out);
			for (int i = 0; i < 100; i++) {
				dataOut.writeInt(i);
				dataOut.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Aqui habria que cerrar el DataOutputStream
		// Haciendolo con "try-with-resources"
		try (DataOutputStream dataOut = new DataOutputStream(Files.newOutputStream
				(ruta, StandardOpenOption.CREATE))){
			// DataOutputStream
			for (int i = 0; i < 100; i++) {
				dataOut.writeInt(i);
				// El flush no haria falta porque lo cierra directamente 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Leer el archivo
		
		try(InputStream in = Files.newInputStream(ruta); 
				DataInputStream dataIn = new DataInputStream(Files.newInputStream(ruta))){
			int numero;
			while(true) {
				numero = dataIn.readInt();
				System.out.println(numero);
			}
		} catch (IOException e) {
			System.out.println("Fin fichero");
		}

	}

}
