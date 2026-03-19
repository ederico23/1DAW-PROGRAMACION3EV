package ejemplos;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ejemplo04 {

	public static void main(String[] args) {
		Path p4 = Path.of("datos/ejemplo04.txt");
		
		//escritura
		try(DataOutputStream dos = new DataOutputStream(Files.newOutputStream(p4, StandardOpenOption.CREATE))){
			dos.writeInt(42); //escribe 4 bytes
			dos.writeLong(10000000L);  //escribe 8 bytes
			dos.writeFloat(9.18f); //escribe 4 bytes
			dos.writeChar('Z'); //escribe 2 bytes
			dos.writeUTF("Hola"); //escribe llongitud
			
			System.out.println("datos primitivos guardados");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//lectura
		try(DataInputStream ios = new DataInputStream(Files.newInputStream(p4))) {
			
			int v1;
			long v2;
			float v3;
			char v4;
			String v5;
			
//			System.out.println("int leido " + v1);
//			System.out.println("long leido " + v2);
//			System.out.println("float leido " + v3);
//			System.out.println("char leido " + v4);
//			System.out.println("String leido " + v5);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
