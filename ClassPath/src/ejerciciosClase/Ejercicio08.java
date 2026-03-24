package ejerciciosClase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio08 {

	public static void main(String[] args) {
		String rutaArchivo = "numeros.dat";

		// PARTE 1: PEDIR NÚMEROS Y ESCRIBIR EN BINARIO
		// Usamos try-with-resources para que el archivo se cierre solo
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(rutaArchivo))) {

			int num;

			do {
				num = Leer.leerEntero("Introduce números enteros (0 para terminar):");
				if (num != 0) {
					dos.writeInt(num); // Escribe el entero en formato de 4 bytes
				}
			} while (num != 0);

			System.out.println("Fichero escrito correctamente.");

		} catch (IOException e) {
			e.printStackTrace();
		}

		//LEER Y CALCULAR ESTADÍSTICAS
		int contador = 0;
		int suma = 0;
		int mayor = Integer.MIN_VALUE;

		try (DataInputStream dis = new DataInputStream(new FileInputStream(rutaArchivo))) {
			// Leemos mientras haya datos disponibles
			while (true) {
				int leido = dis.readInt(); // Lee 4 bytes y los convierte en un int

				contador++;
				suma += leido;
				if (leido > mayor) {
					mayor = leido;
				}
			}
		} catch (IOException e) {
			// Es normal llegar aquí, significa que hemos terminado de leer el fichero
			System.out.println("\n--- RESULTADOS ---");
			System.out.println("Cantidad de números: " + contador);
			System.out.println("Suma total: " + suma);
			System.out.println("El número mayor: " + (contador > 0 ? mayor : "N/A"));
			e.printStackTrace();
		} 

	}
}

