package ejercicios2daEv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class EjercicioProvinciasComunidades {

	public HashMap<Integer,String> lecturaFicheroComunidades(String rutaFichero) {
		HashMap<Integer,String> mapaComunidades= new HashMap<Integer,String>();
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) !=null) {
				String[] unaFila = fichero.split("%");
				mapaComunidades.put(Integer.parseInt(unaFila[0]), unaFila[1]);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound \n");
		} catch (IOException e) {
			System.out.println("Error I/O \n");
		}
		return mapaComunidades;
	}
	
	public HashMap<String,ArrayList<Integer>> lecturaFicheroProvincias(String rutaFichero) {
		HashMap<String,ArrayList<Integer>> mapaProvincias= new HashMap<String,ArrayList<Integer>>();
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) !=null) {
				String[] unaFila = fichero.split("%");
				Integer idPro = Integer.parseInt(unaFila[0]);
				String nombrePro = unaFila[1];
				Integer idComun = Integer.parseInt(unaFila[2]);
				Integer total = Integer.parseInt(unaFila[3]);
				ArrayList<Integer> listadoProvincias = new ArrayList<Integer>();
					listadoProvincias.add(idPro);
					listadoProvincias.add(idComun);
					listadoProvincias.add(total);
					mapaProvincias.put(nombrePro, listadoProvincias);			
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound \n");
		} catch (IOException e) {
			System.out.println("Error I/O \n");
		}
		return mapaProvincias;
	}
	
	public void mostrarDatosProvinciasXComunidades(HashMap<Integer,String> lecturaComunidades ,
			HashMap<String,ArrayList<Integer>> lecturaProvincias) {
		System.out.println("Listado de provincias de las Comunidades Autónomas: ");
		System.out.println("----------------------------------------------------");
	
			for(Integer IdComunidades : lecturaComunidades.keySet()) {
				String nombreUnaComunidad = lecturaComunidades.get(IdComunidades);
				System.out.println("Comunidad Autónoma: " + nombreUnaComunidad);
				int totalNumHab = 0;
				for(String nombreProvincias: lecturaProvincias.keySet()) {
					ArrayList<Integer> datosUnaProvincia = lecturaProvincias.get(nombreProvincias);				
					Integer numHabitantesPro = datosUnaProvincia.get(2);
					Integer idCom = datosUnaProvincia.get(1);
					if(IdComunidades.equals(idCom)) {
						System.out.println(nombreProvincias + " ------------------------> " + numHabitantesPro);
						totalNumHab += numHabitantesPro;
					}							
				}
				System.out.println("TOTAL CCAA " + nombreUnaComunidad + " -------> " + totalNumHab);
				System.out.println();
			}		
	}
	
	
	public static void main(String[] args) {
		EjercicioProvinciasComunidades ejercicio = new EjercicioProvinciasComunidades();
		String rutaFicheroComunidades = "enunciadosEjercicios2daEv/ejercicioProvinciasComunidadesAut/comunidades.txt";
		String rutaFicheroProvincias = "enunciadosEjercicios2daEv/ejercicioProvinciasComunidadesAut/provincias.txt";
		/*****************************************************************************************/
		HashMap<Integer,String> datosComunidades = ejercicio.lecturaFicheroComunidades(rutaFicheroComunidades);
		HashMap<String, ArrayList<Integer>> datosProvincias = ejercicio.lecturaFicheroProvincias(rutaFicheroProvincias);
		ejercicio.mostrarDatosProvinciasXComunidades(datosComunidades, datosProvincias);
	
	
	}

}
