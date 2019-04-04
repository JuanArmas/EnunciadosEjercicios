package ejercicios2daEv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import modelEjercicios2DaEv.Vehiculo;

public class EjercicioRepasoFicheros {

	//. Crear un método que lea el fichero y devuelva un ArrayList de Vehiculo
	public ArrayList<Vehiculo> listadoVehiculos(String rutaFichero){
		ArrayList<Vehiculo> listadoVehiculos= new ArrayList<Vehiculo>();
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) !=null) {
				String[] unaLinea = fichero.split("#");
				//Integer id, String matricula, String marcaModelo, LocalDate fechaMatricula
				int id = Integer.parseInt(unaLinea[0]);
				String matricula = unaLinea[1];
				String marcaModelo = unaLinea[2];
				LocalDate fechaMatricula = LocalDate.parse(unaLinea[3]);			
				Vehiculo vehiculo = new Vehiculo(id, matricula, marcaModelo, fechaMatricula);
				listadoVehiculos.add(vehiculo);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			 System.out.println("Error FileNotFound \n");
		} catch (IOException e) {
			System.out.println("Error I/O \n");
		}
		return listadoVehiculos;
	}
	
	// 3. Crear un método que cree un fichero con objetos de la clase Vehiculo
	public void crearFicheroDeVehiculos(ArrayList<Vehiculo> listadoVehiculos) {
		try {
			FileOutputStream fos = new FileOutputStream("enunciadosEjercicios2daEv/ejercicioRepasoFicheros/marcasVehiculos.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			System.out.println();
			for(int i = 0; i < listadoVehiculos.size(); i++){
				Vehiculo unVehiculo = listadoVehiculos.get(i);
				oos.writeObject(unVehiculo);
				}
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			 System.out.println("Error FileNotFound \n");
		} catch (IOException e) {
			System.out.println("Error I/O \n");
		}
	}
	
	public ArrayList<Vehiculo> leerFicheroVehiculos(String rutaFichero) {
		ArrayList<Vehiculo> listadoVehiculos = new ArrayList<Vehiculo>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			 fis = new FileInputStream(rutaFichero);
			 ois = new ObjectInputStream(fis);
				while(true) {
					Vehiculo coche = (Vehiculo) ois.readObject();
					listadoVehiculos.add(coche);
				}		
		} catch (FileNotFoundException e) {
			 System.out.println("Error FileNotFound \n");
		} catch (IOException e) {
			System.out.println("Error I/O \n");
		} catch (ClassNotFoundException e) {
			System.out.println("Error ClassNotFound \n");
		}finally {
			try {
				ois.close();
				fis.close();
			} catch (Exception e) {				
			}
		}
		return listadoVehiculos;
	}
	
	public static void main(String[] args) {
		EjercicioRepasoFicheros ejercicio = new EjercicioRepasoFicheros();
		String rutaFicheroMarcasVehiculos = "enunciadosEjercicios2daEv/ejercicioRepasoFicheros/marcasVehiculos.txt";
		String rutaFicheroObjVehiculos = "enunciadosEjercicios2daEv/ejercicioRepasoFicheros/marcasVehiculos.obj";
		/**********************************************************************************************************/
		ArrayList<Vehiculo> listadoVehiculos = ejercicio.listadoVehiculos(rutaFicheroMarcasVehiculos);
		ejercicio.crearFicheroDeVehiculos(listadoVehiculos);
		ArrayList<Vehiculo> listadoObjVehiculos = ejercicio.leerFicheroVehiculos(rutaFicheroObjVehiculos);
		System.out.println(listadoObjVehiculos);
		
		
		System.out.println("Fin del programa");
		System.exit(0);
	}

}
