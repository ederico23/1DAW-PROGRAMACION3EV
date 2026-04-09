package modelo;

public class Alumno {
	private String nombre;
	private Integer edad;
	
	/**
	 * @param nombre
	 * @param edad
	 */
	public Alumno(String nombre, Integer edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
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
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}
	
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "nombre=" + nombre + ", edad=" + edad;
	}

	

}//fin clas

