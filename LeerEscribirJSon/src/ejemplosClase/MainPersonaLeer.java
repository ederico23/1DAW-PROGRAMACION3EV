package ejemplosClase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.google.gson.Gson;

public class MainPersonaLeer {

	public static void main(String[] args) {
		
		
		
		try {
			//leer toodo el archivo como un String
			String json = Files.readString(Path.of("ejemplos/personas.json"));
			
			//crear gson
			Gson gson = new Gson();
			
			//convertir json a array de objetos
			PersonaWr[] personas = gson.fromJson(json, PersonaWr[].class);
		
			//mostrar datos
			for(PersonaWr p : personas) {
				System.out.println("Nombre: " + p.getNombre() + 
						", edad: " + p.getEdad());
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}//fin try
	}

}
