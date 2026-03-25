package ejemplosClase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainPersonaWr {
	public static void main(String[] args) {
		
		try {
		//A PARTIR DE UN ARRAY
		PersonaWr[] personas = {
			new PersonaWr("Ana", 25),
			new PersonaWr("Luis", 30),
			new PersonaWr("Maria", 22),
			new PersonaWr("Carlos", 28),
			new PersonaWr("Elena", 32)
		};
		
		//el gsonBuilder es como un constructor
		//prettyPrint para que esté en una linea
		//create para crearlo
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//coger el Array y convertirlo en json 
		String json = gson.toJson(personas);
		
		Files.writeString(Path.of("ejemplos/personas.json"), json, StandardOpenOption.CREATE);	
		System.out.println("Archivo completado");
		} catch (Exception e) {
			e.printStackTrace();
		}//fin trycatch
		
	}//fin main
	
}//fin class
