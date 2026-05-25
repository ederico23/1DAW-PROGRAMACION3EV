package modelo;

public class Empleado {

	private String nombreCompleto;
	private String departamento;
	private double salarioMes;
	
	/**
	 * @param nombreCompleto
	 * @param departamento
	 * @param salarioMes
	 */
	public Empleado(String nombreCompleto, String departamento, double salarioMes) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.departamento = departamento;
		this.salarioMes = salarioMes;
	}//fin Empleado()

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the salarioMes
	 */
	public double getSalarioMes() {
		return salarioMes;
	}

	/**
	 * @param salarioMes the salarioMes to set
	 */
	public void setSalarioMes(double salarioMes) {
		this.salarioMes = salarioMes;
	}

	@Override
	public String toString() {
	    return nombreCompleto + " | " + departamento + " | " + salarioMes + " €";
	}
	
	
	
	
	
}//fin Empleado
