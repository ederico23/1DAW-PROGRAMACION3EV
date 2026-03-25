package ejemplosClase;

public class PersonaWr {
	
	//SIEMPRE EN PRIVADO
	private String nombre;
	private int edad;
	
	//OBLIGATORIO CONSTRUCTOR VACIO
	public PersonaWr() {}

	/**
	 * @param nombre
	 * @param edad
	 */
	public PersonaWr(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

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
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
