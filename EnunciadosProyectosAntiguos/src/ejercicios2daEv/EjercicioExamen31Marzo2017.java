package ejercicios2daEv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelEjercicios2DaEv.Movimiento;

public class EjercicioExamen31Marzo2017 {

	
							/***************EJERCICIO 1************************/
	
	public ArrayList<Movimiento> examenCargaMovimientos(String rutaFichero){
		ArrayList<Movimiento> movimientoCuentas = new ArrayList<Movimiento>();
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) !=null) {
				String[] unaLinea = fichero.split("#");			
				String fechaHora = unaLinea[0];
				Integer idCuenta = Integer.parseInt(unaLinea[1]);
				float importe = Float.parseFloat(unaLinea[2]);
				char tipoMov = unaLinea[3].charAt(0);
				Movimiento movimiento = new Movimiento(fechaHora, idCuenta, importe, tipoMov);
				movimientoCuentas.add(movimiento);
			}			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.out.println("Error I/O\n");
		}
		
		return movimientoCuentas;
	}
	
							/***************EJERCICIO 2************************/
	
	public float examenCalculaSaldo(float[][] movimientos, float saldoInicial) {
		float saldoFinal = saldoInicial;
		
		for(int i = 0; i < movimientos.length; i++) {
			float sumaSaldo = 0 ;
			for(int j = 0; j < movimientos[i].length; j++) {
				sumaSaldo += movimientos[j][i];
			}
			saldoFinal += sumaSaldo;
		}	
		return saldoFinal;
	}
	
	
							/***************EJERCICIO 3************************/
	
	public float[][] examenTuristasIslas(String rutaFichero){
		float[][] turistasIslas = new float[7][12];
		int j = 0;
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String fichero;
			while((fichero = br.readLine()) !=null) {
				String[] unaLinea = fichero.split("&");						
				for(int i = 0; i < unaLinea.length; i++) {
					turistasIslas[j][i] = Float.parseFloat(unaLinea[i]);				
				}
				j++;
			}			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound\n");
		} catch (IOException e) {
			System.out.println("Error I/O\n");
		}		
		return turistasIslas;
	}
	
	public void resumenTuristasMes(float[][] turistasIslas) {
		ArrayList<String> nombreMeses = new ArrayList<>();
		nombreMeses.add("Enero");
		nombreMeses.add("Febrero");
		nombreMeses.add("Marzo");
		nombreMeses.add("Abril");
		nombreMeses.add("Mayo");
		nombreMeses.add("Junio");
		nombreMeses.add("Julio");
		nombreMeses.add("Agosto");
		nombreMeses.add("Septiembre");
		nombreMeses.add("Octubre");
		nombreMeses.add("Noviembre");
		nombreMeses.add("Diciembre");
		
		float[] sumaPorMeses = new float[12];
		for(int i = 0; i < sumaPorMeses.length; i++) {		
			for(int j = 0; j < turistasIslas.length; j++) {
				sumaPorMeses[i] +=turistasIslas[j][i];
			}
			System.out.println(nombreMeses.get(i) + " --> " + sumaPorMeses[i] * 1000f);
		}	
	}
		
	public static void main(String[] args) {
		EjercicioExamen31Marzo2017 ejercicio = new EjercicioExamen31Marzo2017();
		String rutaFicheroMovimientos = "enunciadosEjercicios2daEv/ejercicioExamen31Marzo2017/movimientos.txt";
		String rutaFicheroTuristas = "enunciadosEjercicios2daEv/ejercicioExamen31Marzo2017/TuristasIsla2016.txt";
		/**************************************************************************************************************/
		ArrayList<Movimiento> listadoMovimiento = ejercicio.examenCargaMovimientos(rutaFicheroMovimientos);
		System.out.println(listadoMovimiento);
		
		float saldoInicial = 15.5f;
		float[][] movimientos = {
				{-12.54f,11.65f,85.46f},
				{75.32f,53.12f,-56.12f},
				{42.15f,-63.25f,85.34f}
				};
		float saldoFinal = ejercicio.examenCalculaSaldo(movimientos, saldoInicial);
		System.out.println("\n" + "El Saldo final es -> " + saldoFinal + "\n");
		
		float[][] turistasIslas = ejercicio.examenTuristasIslas(rutaFicheroTuristas);
		ejercicio.resumenTuristasMes(turistasIslas);
		
		
		
		
		System.out.println("\nFin del programa");
		System.exit(0);
	}
	
}
