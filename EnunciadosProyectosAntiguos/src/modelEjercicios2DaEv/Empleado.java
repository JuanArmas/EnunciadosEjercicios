package modelEjercicios2DaEv;

public class Empleado {
	//(id, nombre, idDepartamento, idJefe, sueldo)
	
	private int idEmpleado;
	private String nombre;
	private String idDepartamento;
	private int idJefe;
	private double sueldo;
	
	public Empleado() {
		super();
	}
	
	public Empleado(int idEmpleado, String nombre, String idDepartamento, int idJefe, double sueldo) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.idDepartamento = idDepartamento;
		this.idJefe = idJefe;
		this.sueldo = sueldo;
	}
	
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public int getIdJefe() {
		return idJefe;
	}
	public void setIdJefe(int idJefe) {
		this.idJefe = idJefe;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", idDepartamento=" + idDepartamento
				+ ", idJefe=" + idJefe + ", sueldo=" + sueldo + "]";
	}
	
	
}
