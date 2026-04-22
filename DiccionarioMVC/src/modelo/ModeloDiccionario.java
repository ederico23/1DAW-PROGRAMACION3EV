package modelo;

import java.util.HashMap;
import java.util.Map;

public class ModeloDiccionario {
	
	private Map<String, String> diccionario = new HashMap<>();

	/**
	 * @param diccionario
	 */
	public ModeloDiccionario() {
		
		diccionario = iniciarDiccionario();
		
	}

	private Map<String, String> iniciarDiccionario() {
		Map<String, String> diccionario = new HashMap<>();
		   diccionario.put("hola", "hello");
	        diccionario.put("adios", "goodbye");
	        diccionario.put("perro", "dog");
	        diccionario.put("gato", "cat");
	        diccionario.put("casa", "house");
	        diccionario.put("comida", "food");
	        diccionario.put("agua", "water");
	        diccionario.put("libro", "book");
	        diccionario.put("escuela", "school");
	        diccionario.put("amigo", "friend");
	        diccionario.put("familia", "family");
	        diccionario.put("ciudad", "city");
	        diccionario.put("coche", "car");
	        diccionario.put("tiempo", "time");
	        diccionario.put("trabajo", "work");
	        diccionario.put("dinero", "money");
	        diccionario.put("feliz", "happy");
	        diccionario.put("triste", "sad");
	        diccionario.put("grande", "big");
	        diccionario.put("pequeño", "small");
		return diccionario;
	}
	
	public boolean isPalabraExiste(String palabra) {
		return diccionario.containsKey(palabra);
	}
	
	public String traducir(String palabra) {
		if(isPalabraExiste(palabra)) {
			return diccionario.get(palabra);
		} else {
			return null;
		}
	}
	
	
}//fin class
