package modelEjercicios2DaEv;

public class Movimiento {
	private String fechaHora;
	private Integer idCuenta;
	private float importe;
	private char tipoMov;
	
	public Movimiento() {
		super();
	}
	
	public Movimiento(String fechaHora, Integer idCuenta, float importe, char tipoMov) {
		super();
		this.fechaHora = fechaHora;
		this.idCuenta = idCuenta;
		this.importe = importe;
		this.tipoMov = tipoMov;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Integer getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public char getTipoMov() {
		return tipoMov;
	}
	public void setTipoMov(char tipoMov) {
		this.tipoMov = tipoMov;
	}
	@Override
	public String toString() {
		return "Movimiento [fechaHora=" + fechaHora + ", idCuenta=" + idCuenta + ", importe=" + importe + ", tipoMov="
				+ tipoMov + "]";
	}
	
	
	
}
