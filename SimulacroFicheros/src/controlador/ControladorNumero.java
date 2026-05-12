package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import vista.Vista;

public class ControladorNumero {	
	
	private Vista v;
	private Path p = Path.of("numeros.txt");
	
	/**
	 * @param v
	 */
	public ControladorNumero(Vista v) {
		this.v = v;
		iniciar();
	}//fin constructor

	public void iniciar() {
		
		v.setListenerGuardar(e->{
			try {
				guardarNumero();
			} catch (IOException e1) {
				v.setMensajes("Erro al guardar numero");
			}
		});//fin setListenerGuardar
		
		v.setListenerMultiplos3(e->{
			List<Integer> listaNumeros = leerFichero();
			v.setMensajes("Hay "+calcularMultiplos(listaNumeros) + " multiplos de 3");
			mostrarNumeros(mostrarMultiplos(listaNumeros));
		});//fin setListenerMultiplos3
		
		v.setListenerMostrar(e->{
			mostrarNumeros(leerFichero());
		});;
	}//fin iniciar()

	public void guardarNumero() throws IOException {
		
		if(!Files.exists(p)) {
			v.setMensajes("El fichero no existe");
		}//fin if
		
		if(v.getNumero().isEmpty()) {
			v.setMensajes("Error, introduce un numero");
		}
		
		try(BufferedWriter bw = Files.newBufferedWriter(p, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
			Integer numero = Integer.parseInt(v.getNumero());
			bw.write(numero + "");
			bw.newLine();
			bw.flush();
			v.setMensajes("Numero guardado");
		} catch (NumberFormatException ex) {
			v.setMensajes("Error al leer al guardar los datos");
		}//fin try catch
		
	}//fin guardarNumero
	
	public Integer calcularMultiplos(List<Integer> numeros) {
		Integer contador = 0;
		
		for(Integer num : numeros) {
			if(num % 3 == 0) {
				contador++;
			}//fin if
		} //fin for
		
		return contador;
	} //fin calcularMultiplos()
	
	
	public List<Integer> leerFichero(){
		
		List<String> lineas;
		List<Integer> numeros = new ArrayList<>();
		try {
			lineas = Files.readAllLines(p);
			
			for(String l : lineas) {
				Integer numero = Integer.parseInt(l);
				numeros.add(numero);
			}//fin for
			
		} catch (IOException e) {
			v.setMensajes("Error al leer fichero");
		}//try carth
	
		return numeros;
	}//fin leerFichero()
	
	public void mostrarNumeros(List<Integer> numeros) {
		String listaNumeros = numeros.toString();
		v.setNumeros(listaNumeros);
	}//fin mostrarNumeros
	
	public List<Integer> mostrarMultiplos(List<Integer> numeros) {
		List<Integer> lineas = new ArrayList<>();
		
		for(Integer num : numeros) {
			if(num % 3 == 0) {
				lineas.add(num);
			}//fin if
		} //fin for
		
		return lineas;
	} //fin calcularMultiplos()
	
}//fin class
