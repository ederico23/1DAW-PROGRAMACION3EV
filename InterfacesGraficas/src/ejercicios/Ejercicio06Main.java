package ejercicios;

/**
 * Ejercicio 6
Realizar un programa en Java para convertir grados celsius en grados fahrenheit y viceversa. La interfaz
será similar a la siguiente:
Cuando se pulse el botón "CELSIUS”, la temperatura que hay en el campo de textocorrespondiente a
Fahrenheit, se calculará en celsius y se mostrará en el campo de textodecelsius.
Cuando se pulse el botón "FAHRENHEIT”, la temperatura que hay en el campo de textocorrespondiente a
celsius, se calculará en fahrenheit y se mostrará en el campo de textodefahrenheit.
Si sucede algún error como:
• introducir letras (excepción NumberFormatException)
• dejar el campo que se quiere convertir vacío
En la etiqueta de abajo se mostrará un mensaje advirtiendo del error.
 */

public class Ejercicio06Main {
	public static void main(String[] args) {
		Ejercicio06 frame = new Ejercicio06();
		frame.setVisible(true);
	}
}
