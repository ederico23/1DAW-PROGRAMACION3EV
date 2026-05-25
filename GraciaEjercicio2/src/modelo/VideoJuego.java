package modelo;

/**
 * Ejercicio 2
 * @author Eder Gracia 25/05/26
 */

public class VideoJuego {

	private Integer id;
	private String nombre;
	private String plataforma;
	private Double precio;
	private Integer stock;
	private String genero;

	/**
	 * Constructor con id
	 * @param id
	 * @param nombre
	 * @param plataforma
	 * @param precio
	 * @param stock
	 * @param genero
	 */
	public VideoJuego(Integer id, String nombre, String plataforma, Double precio, Integer stock, String genero) {
		this.id = id;
		this.nombre = nombre;
		this.plataforma = plataforma;
		this.precio = precio;
		this.stock = stock;
		this.genero = genero;
	}//fin VideoJuego()
	
	/**
	 * Constructor sin id
	 * @param nombre
	 * @param plataforma
	 * @param precio
	 * @param stock
	 * @param genero
	 */
	public VideoJuego(String nombre, String plataforma, Double precio, Integer stock, String genero) {
		this.nombre = nombre;
		this.plataforma = plataforma;
		this.precio = precio;
		this.stock = stock;
		this.genero = genero;
	}//fin VideoJuego()

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the plataforma
	 */
	public String getPlataforma() {
		return plataforma;
	}

	/**
	 * @param plataforma the plataforma to set
	 */
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "VideoJuego [id=" + id + ", nombre=" + nombre + ", plataforma=" + plataforma + ", precio=" + precio
				+ ", stock=" + stock + ", genero=" + genero + "]";
	}
	
	
}//fin class VideoJuego

