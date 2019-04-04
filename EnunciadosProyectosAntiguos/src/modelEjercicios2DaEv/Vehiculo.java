package modelEjercicios2DaEv;

import java.io.Serializable;
import java.time.LocalDate;


public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
    private String matricula;
    private String marcaModelo;
    private LocalDate fechaMatricula;
	
    public Vehiculo() {
		super();
	}
	
    public Vehiculo(Integer id, String matricula, String marcaModelo, LocalDate fechaMatricula) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marcaModelo = marcaModelo;
		this.fechaMatricula = fechaMatricula;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarcaModelo() {
		return marcaModelo;
	}
	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}
	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}
	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", matricula=" + matricula + ", marcaModelo=" + marcaModelo + ", fechaMatricula="
				+ fechaMatricula + "]";
	}
    
    
    
    
}
