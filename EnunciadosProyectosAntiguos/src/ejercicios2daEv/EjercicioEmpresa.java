package ejercicios2daEv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelEjercicios2DaEv.Empleado;



public class EjercicioEmpresa {

	public static void main(String[] args) {
		EjercicioEmpresa empresa = new EjercicioEmpresa();
		String rutaFicheroEmpleados = "enunciadosEjercicios2daEv/ejercicioEmpresas/empleados.txt";
		String rutaFicheroDepartamento = "enunciadosEjercicios2daEv/ejercicioEmpresas/departamento.txt";
		/************************************************************************************************/
		
		ArrayList<Empleado> empleados = empresa.lecturaFicheroObjEmpleado(rutaFicheroEmpleados);		
		/*for(int i = 0 ; i < empleados.size(); i++) {
			System.out.println(empleados.get(i) + "\n");
		}*/		
		ArrayList<ArrayList<String>> departamentos = empresa.lecturaFicheroDepartamento(rutaFicheroDepartamento);
		/*for(int i = 0 ; i < departamentos.size(); i++) {
			System.out.println(departamentos.get(i) + "\n");
		}*/
		
		//empresa.gastosMensuales(empleados);
		
		empresa.mostrarEmpleados(empleados, departamentos);
		
		
		
		
		
		
		System.out.println("Fin del programa");
		System.exit(0);
	}

	/***********APARTADO 1***************/
 // cargue el fichero Empleados.txt en un Collection que contenga objetos Empleado
	public ArrayList<Empleado> lecturaFicheroObjEmpleado(String rutaFichero){
		ArrayList<Empleado> unEmpleado = new  ArrayList<Empleado>();
		//(id, nombre, idDepartamento, idJefe, sueldo)
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) != null) {
				String[] unaLinea = fichero.split("#");
				int idEmpleado = Integer.parseInt(unaLinea[0]);
				String nombre = unaLinea[1];
				String idDepartamento = unaLinea[2];
				int idJefe = Integer.parseInt(unaLinea[3]);
				double sueldo = Double.parseDouble(unaLinea[4]);
				Empleado empleado = new Empleado(idEmpleado, nombre, idDepartamento, idJefe, sueldo);				
				unEmpleado.add(empleado);				
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.out.println("Error I/O\n");
		}
		return unEmpleado;
	}
		
	/***********APARTADO 2***************/
	//cargue el fichero Fichero Departamentos.txt en un Collection de String
	public ArrayList<ArrayList<String>> lecturaFicheroDepartamento(String rutaFichero){
		ArrayList<ArrayList<String>> departamentos = new  ArrayList<ArrayList<String>>();
		//(idDepartamento, nombreDepartamento)
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) != null) {
				String[] unaLinea = fichero.split("#");
				String idDepartamento = unaLinea[0];
				String nombreDepartamento = unaLinea[1];
				ArrayList<String> unDepartamento = new ArrayList<String>();
				unDepartamento.add(idDepartamento);
				unDepartamento.add(nombreDepartamento);
				departamentos.add(unDepartamento);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.out.println("Error I/O\n");
		}
		return departamentos;
	}
	
	
	// cada vez tengo mas claro que deben ser hashmaps... piden indices numericos, pero son todos string.. o parseo cargando de lineas o miro el modo hahsmap
	// 
	/***********APARTADO 3***************/
	// mostrar los datos de todos los empleados ordenados por departamento y sustituyendo los id por nombres
	// (id, nombre, idDepartamento, idJefe, sueldo)
	// (idDepartamento, nombreDepartamento)
	public void mostrarEmpleados(ArrayList<Empleado> unEmpleado, ArrayList<ArrayList<String>> departamentos) {		
		for(int i = 0 ; i < unEmpleado.size(); i++) {
			String  nombreDepartamento = null;
			for(int j =0; j < departamentos.size(); j++) {
				unEmpleado.get(i).getIdDepartamento();
				nombreDepartamento = departamentos.get(j).get(0);
				
			}		
			System.out.println(unEmpleado.get(i).getIdEmpleado() + " " + unEmpleado.get(i).getNombre() + " " 
					+ unEmpleado.get(i).getIdDepartamento() + " "  + unEmpleado.get(i).getIdJefe()+ " "  
					+ unEmpleado.get(i).getSueldo());
		}	
	}
	
	/***********APARTADO 4***************/
	//crear un método que devuelva que cantidad que gasta la empresa mensualmente en sueldos y que la vista lo muestre
	
	public void gastosMensuales(ArrayList<Empleado> unEmpleado){
		double sueldo = 0;
		for(int i = 0; i< unEmpleado.size(); i++) {
			sueldo += unEmpleado.get(i).getSueldo();
		}
		System.out.println(sueldo);
	}
	
	
}
