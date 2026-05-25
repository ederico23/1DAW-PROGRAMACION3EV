package modelo;

/**
 * Ejercicio 1
 * @author Eder Gracia Carmona 25/05/26
 */

public class Alumno {

	private String nombre;
	private Integer nota;
	
	/**
	 * Constructor
	 * @param nombre
	 * @param nota
	 */
	public Alumno(String nombre, Integer nota) {
		this.nombre = nombre;
		this.nota = nota;
	}//fin Alumno()

	//GETTERS Y SETTERS
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nota
	 */
	public Integer getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Integer nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nombre= " + nombre + ", Nota= " + nota;
	}
	
	
}//fin class Alumno
