package ejerciciosAvanzadosFicheros;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio03 {
	
	public static void main(String[] args) {
		
		Path ej03 = Path.of("ejerciciosAvanzados/ejercicio03.txt");
		
		if (!Files.exists(ej03)) {
			System.out.println("Archivo no encontrado");
			return;
		}
		
		try {

			//para leer todas las lineas
			List <String>lineasAntes = Files.readAllLines(ej03);
			
			//para las lineas que son unicas
			List<String> lineasDespues = new ArrayList<>();
			
			//recorrer todas las lineas
			for(String lA : lineasAntes) {
				
				//boolean para ver si ya existe la palabra
				boolean existe = false;
				
				//recorre la lista de las lineas limpias, compara la linea actual con las del archivo
				for(String lD : lineasDespues) {
					//ignorar mayus
					if(lD.equalsIgnoreCase(lA)) {
						//si entra aqui es que ya existia
						existe = true;
						break;
					}
				} //fin for lD
				 
				//si existe se mete aqui
				if(!existe) {
					lineasDespues.add(lA);
				}
				
			} //fin for lA
			
			Files.write(ej03, lineasDespues);
			System.out.println("Fichero limpieado");
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fin trycatch
		
		
	} //fin main
	
	
}//fin class
