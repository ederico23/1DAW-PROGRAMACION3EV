package modelo;

public class Pelicula {

	//atributos
	private Integer id;
	private String titulo;
	private String director;
	private String genero;
	private Integer duracion;
	
	/**
	 * @param id
	 * @param titulo
	 * @param director
	 * @param genero
	 * @param duracion
	 */
	public Pelicula(Integer id, String titulo, String director, String genero, Integer duracion) {
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.duracion = duracion;
	}//fin constructor completo
	
	/**
	 * @param titulo
	 * @param director
	 * @param genero
	 * @param duracion
	 */
	public Pelicula(String titulo, String director, String genero, Integer duracion) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.duracion = duracion;
	}//fin consturcor sin id

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @return the duracion
	 */
	public Integer getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return id + ";" + titulo + ";" + director + ";" + genero + ";" + duracion ;
	}
	
	
	
	
	
}//fin class
