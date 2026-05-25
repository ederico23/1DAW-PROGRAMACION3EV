package controlador;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Empleado;

public class ControladorEmpleado {

	private Path path = Path.of("empleados.txt");
	private Empleado e;

	/**
	 * @param e
	 */
	public ControladorEmpleado() {
		iniciar();
	}//fin ControladorEmpleado()

	private void iniciar() {
		//LLAMAMOS A LOS METODOS
		existeFichero();
		mostrarMenu();
	}//fin iniciar()

	public void mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n--- GESTOR EMPLEADOS ---");
			System.out.println("1. Mostrar todos los empleados");
			System.out.println("2. Filtrar por departamento");
			System.out.println("3. Empleado con mayor salario");
			System.out.println("4. Calcular salario medio");
			System.out.println("5. Añadir empleado");
			System.out.println("0.- Salir");
			opcion = Integer.parseInt(sc.nextLine().trim());//para que no se quede el enter guardado en el buffer

			switch (opcion) {
			case 0:
				System.out.println("Adios");
				break;
				
			case 1: 
				try {
					List<Empleado> empleados = leerFichero();
					for (Empleado emp : empleados) {
						System.out.println(emp);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 2: 
				String departamentoABuscar = utilidades.Leer.leerFrase("Departamento a buscar");
				try {
					filtrarDepartamento(departamentoABuscar);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 3: 
				try {
					salarioMayor();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 4:
				salarioMedio();
				break;
			
			case 5: 
				String nombreAñadir = utilidades.Leer.leerFrase("Nombre del nuevo empleado");
				String departAñadir = utilidades.Leer.leerFrase("Nombre del nuevo departamento");
				double salarioAñadir = utilidades.Leer.leerDouble("Salario del nuevo empleado");
				añadirEmpleado(nombreAñadir, departAñadir, salarioAñadir);
				break;
				
			default:
				System.out.println("Escriba una opcion valida");
			}//fin switch
		} while (opcion != 0);
	}//fin mostrarMenu()

	

	/**
	 * Metodo para comprobar que un fichero existe
	 */
	public void existeFichero() {
		if (!Files.exists(path)) {
			System.out.println("El archivo no existe");
			System.exit(0);
		}//fin if
	}//fin existeFichero()

	public List<Empleado> leerFichero() throws Exception {
		List<String> lineas = Files.readAllLines(path);
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		for(int i = 0; i < lineas.size(); i++) {
			String[] partes = lineas.get(i).split(";");
			String nombre = partes[0];
			String depart = partes[1];
			double salario = Double.parseDouble(partes[2]);
			
			empleados.add(new Empleado(nombre, depart, salario));
		}//fin for leer lineas
		return empleados;
	}//fin leerFichero()

	
	public void filtrarDepartamento(String depart) throws Exception {
		List<Empleado> empleados = leerFichero();
		boolean encontrado = false;
		
		for(Empleado emp : empleados) {
			if(emp.getDepartamento().equalsIgnoreCase(depart)) {
				System.out.println("Departamento de: " + depart + " encontrado correctamente");
				encontrado = true;
			}//fin if
		}//fin for
		
		if(!encontrado) {
			System.out.println("Departamento de: " + depart + " no encontrado");
		}
	}//fin filtrarDepartamentos()

	public void salarioMayor() throws Exception {
		try {
			
		List<Empleado> empleados = leerFichero();
		Empleado mayor = empleados.get(0); //suponemos q el salario mas alto es el primero
		for(Empleado emp : empleados) {
			if(emp.getSalarioMes() > mayor.getSalarioMes()) { //el siguiente tiene mas salario q el primeri? sigue hasta q encuentre el mayor
				mayor = emp; //si emp es mayor q mayor, se guarda en mayor y sigue comparando
			}
		}
		System.out.println("El empleado con mayor salario es: " + mayor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}//fin salarioMayor

	public void salarioMedio() {
		try {
			List<Empleado> empleados = leerFichero();
			double suma = 0;
			
			for(Empleado emp : empleados) {
				suma += emp.getSalarioMes();
			}
			double media = suma/empleados.size();
			System.out.println("El salario medio es de: " + media);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}//fin salarioMedio()
	
	public void añadirEmpleado(String nombre, String depart, double salario) {
		List<Empleado> empleados = new ArrayList<Empleado>();
		if(nombre.isEmpty() || depart.isEmpty() || salario <= 0) {
			System.out.println("Datos no validos. No se ha podido añadir el empleado");
			return;
		}
		
		String linea = nombre + ";" + depart + ";" + salario;

		try {
		Files.writeString(path, "\n" + linea, StandardOpenOption.APPEND);
		System.out.println("Empleado creado correctamente");
		} catch (Exception ex) {
			System.out.println("Error al escribir en el fichero");
		}
		
	}//fin añadirEmpleado()

}//fin ControladorEmpleado
