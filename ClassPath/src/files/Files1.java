package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardCopyOption;

public class Files1 {
    public static void main(String[] args) {
        
        Path p = Path.of("datos/mensaje.txt");

        // 1. ESCRIBIR (Sobrescribir)
        try {
            Files.writeString(p, "Hola");
            System.out.println("1. He escrito 'Hola' en mensaje.txt"); // CHIVATO
        } catch (IOException e) {
            System.err.println("Error en paso 1: " + e.getMessage());
        }

        // 2. ESCRIBIR (Añadir)
        try {
            Files.writeString(p, "HolaSSS", StandardOpenOption.APPEND);
            System.out.println("2. He añadido 'HolaSSS' al archivo"); // CHIVATO
        } catch (IOException e2) {
            System.err.println("Error en paso 2: " + e2.getMessage());
        } 

        // 3. LEER CONTENIDO
        Path rutaLeer = Path.of("datos/datos.txt");
        try {
            String contenido = Files.readString(rutaLeer);
            System.out.println("3. He leído de datos.txt: " + contenido); // CHIVATO
        } catch (IOException e3) {
            System.err.println("Error en paso 3 (Lectura): ¿Existe el archivo datos.txt?");
            
        }
        
        // 4. COPIAR UN ARCHIVO
        Path p3 = Path.of("datos/copia.txt");
        try {
            // He cambiado el orden: p es el que existe, p3 es el nuevo
            // Y añadimos REPLACE_EXISTING para que puedas dar al Play muchas veces
            Files.copy(p, p3, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("4. He copiado mensaje.txt a copia.txt"); // CHIVATO
            
            // Ahora leemos el resultado de la copia
            System.out.println("Contenido de la copia: " + Files.readString(p3));
        } catch (IOException e4) {
            System.err.println("Error en paso 4 (Copia): " + e4.getMessage());
        }
        
        System.out.println("--- Fin del programa ---");
    }
}