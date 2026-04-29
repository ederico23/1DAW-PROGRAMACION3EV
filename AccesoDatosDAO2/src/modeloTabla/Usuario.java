package modeloTabla;

public class Usuario {

	private int id;
	private String nombre;
	private int edad;
	
	/**
	 * Constructor para leer datos (con id)
	 * @param id
	 * @param nombre
	 * @param edad
	 */
	public Usuario(int id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}//fin Usuario()

	/**
	 * Constructor para añadir datos (sin id)
	 * @param nombre
	 * @param edad
	 */
	public Usuario(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}//fin Usuario()

	public int getId() {
		return id;
	}//fin getId()

	public String getNombre() {
		return nombre;
	}//fin getNombre()

	public int getEdad() {
		return edad;
	}//fin getEdad()
	
		
}//fin class
