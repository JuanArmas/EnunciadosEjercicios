package ejercicios2daEv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class EjercicioNotasAlumnos {

	public static void main(String[] args) {
		EjercicioNotasAlumnos ejercicio = new EjercicioNotasAlumnos();
		String rutaFicheroAsignaturas = "enunciadosEjercicios2daEv/ejerciciosAlumnosAsignaturas/asignaturas.txt";
		String rutaFicheroNotasAlumnos = "enunciadosEjercicios2daEv/ejerciciosAlumnosAsignaturas/notasAlumnos.txt";
		/**************************************************************/
		ArrayList<String> asignaturas = ejercicio.listadoAsignaturas(rutaFicheroAsignaturas);
		HashMap<String, ArrayList<Integer>> notasAlumnos = ejercicio.mapaNotasAlumnos(rutaFicheroNotasAlumnos);
		ejercicio.mostrarDatos(asignaturas, notasAlumnos);
		ejercicio.mediaAlumno(notasAlumnos);
		ejercicio.mediaPorAsignatura(asignaturas, notasAlumnos);
		
		
		
		System.out.println("\n\n Fin del programa");
		System.exit(0);
	}	
	//obtener la nota media por asignatura (columna)
	public void mediaPorAsignatura(ArrayList<String> asignaturas, HashMap<String, ArrayList<Integer>> notasAlumnos) {
		System.out.println();
		System.out.println("NOTA MEDIA POR ASIGNATURA: ");
		System.out.println("--------------------------");
		for(int i = 0; i < notasAlumnos.size(); i++) {
			int sumaNotas = 0;
			double mediaNotas = 0;
			for(String nombreAlumno : notasAlumnos.keySet()) {
				ArrayList<Integer> listadoNotas = notasAlumnos.get(nombreAlumno);
				sumaNotas += listadoNotas.get(i);
				mediaNotas = sumaNotas/asignaturas.size();
			}
			System.out.println(asignaturas.get(i) + " --> " + mediaNotas + " ");	
		}		
	}
	
	
	//obtener la nota media por alumno (fila)
	public void mediaAlumno(HashMap<String, ArrayList<Integer>> notasAlumnos) {
		System.out.println();
		System.out.println("Nota Media Por Alumno:");
		System.out.println("----------------------");
		Set<String> clavesNotasAlumnos = notasAlumnos.keySet();
		for(String nombreAlumno : clavesNotasAlumnos) {
			ArrayList<Integer> listadoNotas = notasAlumnos.get(nombreAlumno);
			double mediaNotas = 0;
			double sumatoriaNotas = 0;
			for(int i = 0; i < listadoNotas.size(); i++) {
				sumatoriaNotas += listadoNotas.get(i);
				mediaNotas = sumatoriaNotas/listadoNotas.size();
			}
			
			System.out.println(nombreAlumno + "  -->  " + mediaNotas);
		}
	}
	
	public void mostrarDatos(ArrayList<String> asignaturas, HashMap<String, ArrayList<Integer>> notasAlumnos) {
		System.out.print("\t\t\t");
		for(int i = 0; i < asignaturas.size(); i++) {
			System.out.print("\t" + asignaturas.get(i));			
		}
		System.out.println();
		Set<String> clavesNotasAlumnos = notasAlumnos.keySet();
		for(String nombreAlumno : clavesNotasAlumnos) {
			ArrayList<Integer> listadoNotas = notasAlumnos.get(nombreAlumno);
			Integer notaLeng = listadoNotas.get(0);
			Integer notaMate = listadoNotas.get(1);
			Integer notaFisi = listadoNotas.get(2);
			Integer notaHist = listadoNotas.get(3);
			Integer notaQuim = listadoNotas.get(4);		
			System.out.println(nombreAlumno + " -> \t  " + notaLeng + "\t  " + notaMate + "\t\t  " + notaFisi + "\t  " + notaHist + "\t\t  " + notaQuim);
		}		
	}
	
	public ArrayList<String> listadoAsignaturas(String rutaFicheroAsignaturas){
		ArrayList<String> listadoAsignaturas= new ArrayList<String>();
		try {
			FileReader fr = new FileReader(rutaFicheroAsignaturas);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) !=null) {
				String[] unaFila = fichero.split(",");			
				for(int i = 0; i< unaFila.length; i++) {
					listadoAsignaturas.add(unaFila[i]);
				}				
			}			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.out.println("Error I/O\n");
		}
		return listadoAsignaturas;
	}
	
	public HashMap<String, ArrayList<Integer>> mapaNotasAlumnos(String rutaFicheroNotasAlumnos){
		HashMap<String, ArrayList<Integer>> mapaNotasAlumnos= new HashMap<String, ArrayList<Integer>>();
		try {
			FileReader fr = new FileReader(rutaFicheroNotasAlumnos);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			//SANCHEZ LOPEZ,BERNARDO #6,8,9,5,7
			while((fichero = br.readLine()) !=null) {
				String[] nombreYNotas = fichero.split("#");	
				String nombreAlumnos = nombreYNotas[0];
				String[] notas = nombreYNotas[1].split(",");
				ArrayList<Integer> listadoNotas = new ArrayList<Integer>();
				for(int i = 0; i < notas.length; i++) {
					listadoNotas.add(Integer.parseInt(notas[i]));
				}
				mapaNotasAlumnos.put(nombreAlumnos, listadoNotas);			
			}			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.out.println("Error I/O\n");
		}
		return mapaNotasAlumnos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
