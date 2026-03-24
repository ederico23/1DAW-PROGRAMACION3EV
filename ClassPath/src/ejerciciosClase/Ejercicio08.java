package ejerciciosClase;

<<<<<<< HEAD
/**
 * Ejercicio 8.- Utilizando InputStream y OutputStream generaun progrmama que realice la siguiente
 * tarea:
 * Pida por teclado números Int hasta que introduzcas el valor 0 y escriba los números como Int.
 * Una vez escrito el fichero intenta leer el fichero con el bloc de notas o algún programa que lea el
 * contenido en bytes de un archivo. Interpreta el resultado.
 * Lee todos los números del fichero y determina:
 * 	• La cantidad de numeros introducidos.
 * 	• Su suma.
 * • El mayor de los números introducidos.
 * 
 * @author Eder Gracia
 * @version 1.0
 */
=======
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

>>>>>>> eefb427f2c2377f6a38582a661b5fa072ad54368
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

