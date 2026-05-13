package modelo;

public class Vehiculo {

	private String marca;
	private String vehiculo;
	private String provincia;
	private Integer año;
	private String matricula;
	private Integer km;
	
	/**
	 * @param marca
	 * @param vehiculo
	 * @param provincia
	 * @param matricula
	 * @param km
	 */
	public Vehiculo(String marca, String vehiculo, String provincia, Integer año,
			String matricula, Integer km) {
		this.marca = marca;
		this.vehiculo = vehiculo;
		this.provincia = provincia;
		this.año = año;
		this.matricula = matricula;
		this.km = km;
	}//fin constructor

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the vehiculo
	 */
	public String getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the km
	 */
	public Integer getKm() {
		return km;
	}

	/**
	 * @param km the km to set
	 */
	public void setKm(Integer km) {
		this.km = km;
	}
	
	/**
	 * @return the año
	 */
	public Integer getAño() {
		return año;
	}

	/**
	 * @param año the año to set
	 */
	public void setAño(Integer año) {
		this.año = año;
	}

}//fin class
