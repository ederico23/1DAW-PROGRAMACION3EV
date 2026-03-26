package ejerciciosAvanzadosFicheros;

import java.nio.file.Path;
import java.util.ArrayList;

import ejerciciosClase.Leer;

public class Ejercicio05 {
	public static void main(String[] args) {
		Path ej05 = Path.of("ejerciciosAvanzados/ejercicio05.txt");

		int opcion = 0;

		do {
			//menu
			System.out.println("1. Mostrar alumnos");
			System.out.println("2. Añadir alumnos");
			System.out.println("3. Buscar alumnos por nombre");
			System.out.println("4. Filtrar por grupo");
			System.out.println("0. Salir");
			Leer.leerEntero("Que eliges?");

			switch (opcion) {
			case 0: 
				System.out.println("Adios");
				break;

			case 1: 
				ArrayList<Ejercicio05Alumno> lista = leerFichero(ej05);
				mostrarAlumnos(ej05);


			} 

		} while (opcion != 0);
	}

	private static ArrayList<Ejercicio05Alumno> leerFichero(Path ej05) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void mostrarAlumnos(Path ej05) {
		// TODO Auto-generated method stub
		
	}
}