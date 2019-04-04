package ejercicios2daEv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import modelEjercicios2DaEv.Libro;



public class EjercicioLibrosEditorial {

	public static void main(String[] args) {
		EjercicioLibrosEditorial ejercicio = new EjercicioLibrosEditorial();
		String rutaFicheroEditorial = "enunciadosEjercicios2daEv/ejercicioLibrosEditoriales/2Editoriales2DaEv.txt";
		String rutaFicheroAutores = "enunciadosEjercicios2daEv/ejercicioLibrosEditoriales/3Autores2DaEv.txt";
		String rutaFicheroTemas = "enunciadosEjercicios2daEv/ejercicioLibrosEditoriales/5Temas2DaEv.txt";
		String rutaFicheroLibros = "enunciadosEjercicios2daEv/ejercicioLibrosEditoriales/4Libros2DaEv.txt";
		/******************************************************************/
		ArrayList<String> editoriales = ejercicio.leerFicheroGenerico(rutaFicheroEditorial);
		ArrayList<String> autores = ejercicio.leerFicheroGenerico(rutaFicheroAutores);
		ArrayList<String> temas = ejercicio.leerFicheroGenerico(rutaFicheroTemas);
		HashMap <Integer,ArrayList<Libro>> mapaLibros = ejercicio.getLibrosPorEditorial(rutaFicheroLibros);
		System.out.println(mapaLibros);
		
		
		System.out.println("Fin del programa");
		System.exit(0);

	}

	public ArrayList<String> leerFicheroGenerico(String rutaFicheroGenerico) {
		ArrayList<String> listadoFichero= new ArrayList<String>();
		try {
			FileReader fr = new FileReader(rutaFicheroGenerico);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) !=null) {
				String[] unaLinea = fichero.split("#");
				String indice = unaLinea[0];
				String valor = unaLinea[1];
				listadoFichero.add(indice);
				listadoFichero.add(valor);
			}
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.err.println("Error I/O\n");
		}
		return listadoFichero;
	}
	
	public HashMap <Integer,ArrayList<Libro>> getLibrosPorEditorial(String rutaFicheroGenerico) {
		HashMap <Integer,ArrayList<Libro>> mapaLibrosEditorial= new HashMap <Integer,ArrayList<Libro>>();
		try {
			FileReader fr = new FileReader(rutaFicheroGenerico);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) !=null) {
				String[] unaLinea = fichero.split("#");
				Integer id = Integer.parseInt(unaLinea[0]);
				Integer tema = Integer.parseInt(unaLinea[1]);
				Integer editorial = Integer.parseInt(unaLinea[2]);
				String titulo = unaLinea[3];
				Integer autor = Integer.parseInt(unaLinea[4]);
				char disponible = unaLinea[5].charAt(0);
				String isbn = unaLinea[6];
				float precio = Float.parseFloat(unaLinea[7]);
				String portada = unaLinea[8];
				LocalDate fechapublicacion = LocalDate.parse(unaLinea[9]);
				Libro libro=new Libro(id, tema, editorial, titulo, autor, disponible, isbn, precio, portada, fechapublicacion);
				ArrayList<Libro> unLibro = null;	
				if(!mapaLibrosEditorial.containsKey(editorial)) {
					unLibro = new ArrayList<Libro>();
					mapaLibrosEditorial.put(editorial, unLibro);
				}
				unLibro = mapaLibrosEditorial.get(editorial);
				unLibro.add(libro);				
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.err.println("Error I/O\n");
		}
		return mapaLibrosEditorial;
	}
	
//crea un método que recoja el hashmap anterior y muestre por consola el listado de libros ordenados por su editorial
	
	public void mostrarOrdenadosPorEd(HashMap <Integer,ArrayList<Libro>> librosPorEditorial, ArrayList<String> editoriales) {
		Set<Integer> mapaLibros = librosPorEditorial.keySet();
		for(Integer idLibros : mapaLibros) {
			ArrayList<Libro> listadoLibros = librosPorEditorial.get(idLibros);
			Integer id;
			Integer tema;
			Integer editorial;
			String titulo;
			Integer autor;
			char disponible;
			String isbn;
			float precio;
			String portada;
			LocalDate fechapublicacion;

			for(int i = 0; i < listadoLibros.size(); i++) {
				Integer idEditorial = Integer.parseInt(editoriales.get(1));
				id = listadoLibros.get(i).getId();
				tema = listadoLibros.get(i).getTema();
				listadoLibros.get(i).getEditorial();
				listadoLibros.get(i).getTitulo();
				listadoLibros.get(i).getAutor();
				listadoLibros.get(i).getDisponible();
				listadoLibros.get(i).getIsbn();
				listadoLibros.get(i).getPrecio();
				listadoLibros.get(i).getPortada();
				listadoLibros.get(i).getFecha();
			}
			
			// NO TERMINADO, MISMO PROBLEMA QUE EL EJERCICIO EMPRESA
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
