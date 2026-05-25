package modelo;

public class Empleado {

    private Integer id;
    private String nombre;
    private String puesto;
    private double salario;
    private Integer isActivo;

    public Empleado(Integer id, String nombre, String puesto, double salario, Integer isActivo) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.isActivo = isActivo;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }
    public Integer getIsActivo() { return isActivo; }
}