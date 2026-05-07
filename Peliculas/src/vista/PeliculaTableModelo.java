package vista;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Pelicula;

public class PeliculaTableModelo extends AbstractTableModel {

	private List<Pelicula> listaPeliculas;
	
	private String[] columnas = {"Id", "Titulo", "Director", "Genero", "Duracion"};
		
	/**
	 * @param listaPeliculas
	 */
	public PeliculaTableModelo(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}//fin constructor

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaPeliculas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pelicula p = listaPeliculas.get(rowIndex);
		
		switch(columnIndex) {
		case 0: return p.getId();
		case 1: return p.getTitulo();
		case 2: return p.getDirector();
		case 3: return p.getGenero();
		case 4: return p.getDuracion();
		default: return null;
		}//fin switch
	}
	
	@Override
	public String getColumnName(int columna) {
		return columnas[columna];
	}

	/**
	 * @return the columnas
	 */
	public String[] getColumnas() {
		return columnas;
	}
	
	
	
}//fin class
