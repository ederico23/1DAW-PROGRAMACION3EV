package controlador;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import modelo.Alumno;
import vista.Vista;

/**
 * Ejercicio 1
 * @author Eder Gracia Carmona 25/05/26
 */

public class ControladorAlumno {

	private Path path = Path.of("notas.txt");
	private Alumno a;
	private Vista v;
	
	/**
	 * Constructor
	 */
	public ControladorAlumno(Vista v) {
		this.v = v;
		iniciar();
	}//fin ControladorAlumno()
	
	public void iniciar() {
		
		//LISTENER GUARDAR FICHERO
		v.setListenerGuardarFichero(e->{
			ficheroExiste();
			try {
				escribirFichero();
			} catch (Exception e1) {
				v.mostrarError("Error al escribir en el fichero");
			}//fin tryCatch
		});//fin setListenerGuardarFichero
		
		v.setListenerMostrarAprobados(e->{
			try {
				v.setTxtArea(mostrarAprobados());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});//fin setListenerMostrarAprobados
	}//fin iniciar()
	
	//METODOS PARA EL FICHERO
	public void ficheroExiste() {
		try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (Exception e) {
            v.mostrarError("Error al crear el fichero");
        }
	}//fin ficheroExiste
	
	public List<Alumno> leerFichero() throws Exception {
		List<String> lineas = Files.readAllLines(path);
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		for(int i = 0; i<lineas.size(); i++) {
			String[] partes = lineas.get(i).split(",");
			String nombre = partes[0];
			Integer nota = Integer.parseInt(partes[1]);
			alumnos.add(new Alumno(nombre, nota));
		}//fin for
		return alumnos;
	}//fin leerFichero()
	
	public void escribirFichero() throws Exception{
		if(v.getNombre().isEmpty() || v.getNota().isEmpty()) {
			v.mostrarError("No dejes en blanco ningun campo");
			v.vaciarNombre();
			v.vaciarNota();
			return;
		}//fin if vacios
		String nombre = v.getNombre();
		Integer nota = Integer.parseInt(v.getNota());
		if(nota < 1 || nota >10) {
			v.mostrarError("La nota debe ser un numero entero entre 1 y 10");
			v.vaciarNombre();
			v.vaciarNota();
			return;
		}//fin if entero1-10
			
		
		try(BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, 
				StandardOpenOption.APPEND)){
			bw.write(nombre + "," + nota);
			bw.newLine();
			bw.flush();
			v.mostrarInfo("Alumno y nota guardada correctamente");
			v.vaciarNombre();
			v.vaciarNota();
		} catch (NumberFormatException ex) {
			v.mostrarError("Error al guardar los datos");
		}
	}//fin escribirFichero()

	//METODOS APROBADOS
	public List<Alumno> seleccionarAprobados() throws Exception {
		List<Alumno> alumnos = leerFichero();
		System.out.println(alumnos);
		List<Alumno> alumnosMas5 = new ArrayList<Alumno>();
		
		Alumno alumnoAprobado = alumnos.get(0);
		for(Alumno a : alumnos) {
			if(a.getNota() > 5) {
				alumnosMas5.add(a);
			}
		}
		//tengo que coger la nota del fichero no de la vista
		
		
//		for(Alumno a : alumnos) {
//			if(nota >= 5) {
//				alumnos.add(a);
//			}//fin if
//		}//fin for
		System.out.println(alumnos);
		return alumnos;
	}//fin seleccionarAprobados
	
	public String mostrarAprobados() throws Exception {
		List<Alumno> listaAlumnos = seleccionarAprobados();
		String listaAprobados = listaAlumnos.toString();
		System.out.println(listaAprobados);
		return listaAprobados;
	}//fin mostrarApronadps
}//fin ControladorAlumno
