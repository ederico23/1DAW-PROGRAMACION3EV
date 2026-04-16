package modelo;

public class Usuario {	
	
	String contraseña;
	String nombre;
	
	/**
	 * @param contraseña
	 * @param nombre
	 */
	public Usuario(String nombre, String contraseña) {
		super();
		this.contraseña = contraseña;
		this.nombre = nombre;
	}//fin construcor

	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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

	
		
}//FIN CLASS
