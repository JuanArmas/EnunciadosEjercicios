package ejercicios2daEv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import modelEjercicios2DaEv.Jugador;

public class EjercicioExamen2Abril2019 {

	public static void main(String[] args) {
		EjercicioExamen2Abril2019 ejercicio = new EjercicioExamen2Abril2019();
		String rutaFicheroEquipos = "enunciadosEjercicios2daEv/ejercicioExamen2Abril2019/equipos.txt";
		String rutaJugadores = "enunciadosEjercicios2daEv/ejercicioExamen2Abril2019/jugadores.txt";
		/*************************************************************************************************/
		
		ArrayList<Jugador> listadoJugadores = ejercicio.ejercicio1(rutaJugadores, "11");
		System.out.println(listadoJugadores);
		
		
		System.out.println("Fin del programa\n");
		System.exit(0);
	}

	// Se recorre dicho fichero, comprobando si el jugador leído pertenece al equipo dado por parámetro.
	// Si pertenece se procede a crear el objeto jugador y se añade a la lista.
	public ArrayList<Jugador> ejercicio1 (String rutaJugadores , String equipo){
		ArrayList<Jugador> listadoJugadores = new ArrayList<Jugador>();
		try {
			FileReader fr = new FileReader(rutaJugadores);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			// 1#nif1#Fernando Pacheco#121#AAAAMMDD#M#1#1
			while((fichero = br.readLine()) != null) {
				String[] unaLinea = fichero.split("#");
				String id = unaLinea[0];
				String nombre = unaLinea[2];
				String dorsal = unaLinea[6];
				String idEquipo = unaLinea[7];
				if(equipo.equals(idEquipo)) {
					Jugador unJugador = new Jugador();
					unJugador.setId(Integer.parseInt(id));
					unJugador.setNombre(nombre);
					unJugador.setDorsal(Integer.parseInt(dorsal));
					unJugador.setIdEquipo(Integer.parseInt(idEquipo));
					listadoJugadores.add(unJugador);
				}
			}		
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.out.println("Error I/O\n");
		}
		return listadoJugadores;
	}
	
	/*
	se pide obtener un mapa de jugadores por equipo. 
	El prototipo debe ser el siguiente:
		
	La clave representa el código del equipo.

	Si la ruta al fichero no existe, se devolverá null.
	*/
	
	public HashMap<String, ArrayList<Jugador>> ejercicio2 (String rutaJugadores){
		HashMap<String, ArrayList<Jugador>> mapaJugadores = new HashMap<String, ArrayList<Jugador>>();
		try {
			if(rutaJugadores != null) {
				FileReader fr = new FileReader(rutaJugadores);
				BufferedReader br = new BufferedReader(fr);
				String fichero;
				// 1#nif1#Fernando Pacheco#121#AAAAMMDD#M#1#1
				while((fichero = br.readLine()) != null) {
					String[] unaLinea = fichero.split("#");
					
					String idEquipo = unaLinea[7];
					
				}		
				br.close();
				fr.close();
			}else {
				return null;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.out.println("Error I/O\n");
		}
		
		
		return mapaJugadores;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
