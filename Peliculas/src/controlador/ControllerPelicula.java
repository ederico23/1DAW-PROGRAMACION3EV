package controlador;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import dao.PeliculaDAO;
import modelo.Pelicula;
import vista.PeliculaTableModelo;
import vista.Vista;

public class ControllerPelicula {

	private Vista vista;
	private PeliculaDAO dao;
	private PeliculaTableModelo tabla;
	/**
	 * @param vista
	 */
	public ControllerPelicula(Vista vista) {
		try {
			this.vista = vista;
			this.dao = new PeliculaDAO();
			this.tabla = new PeliculaTableModelo(dao.listar());
			vista.getTable().setModel(tabla);
			
			iniciar();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//fin constructor

	public void iniciar() {
		vista.setListenerCrear(e->{
			crearArchivo();
		});
	}//fin Iniciar()

	private void crearArchivo() {
		Path path = Path.of("datos.csv");
		
		try (BufferedWriter bw = Files.newBufferedWriter(path)) {
			List<Pelicula> lista = dao.listar();
			//escribir cabeceras
			try {
				for(String columna : tabla.getColumnas()) {
					bw.write(columna + ";");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				bw.newLine();
				bw.flush();
			for(Pelicula p : lista) {
				bw.write(p.toString());
				bw.newLine();
				bw.flush();
			}//fin for
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fin tryCatch
		
	}//fin crearArchivo
	
	



}//fin class
