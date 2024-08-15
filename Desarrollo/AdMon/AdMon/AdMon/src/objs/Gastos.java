package objs;

public class Gastos {
	
	

	private int idGasto, monto, fondoTomado;
	private String fecha, concepto, clasificacion, fondoTomadoLetra;
	
	
	public Gastos(int idGasto,String fecha, int monto,  String concepto, String clasificacion, int fondoTomado) {
		super();
		this.idGasto = idGasto;
		this.monto = monto;
		this.clasificacion = clasificacion;
		this.fondoTomado = fondoTomado;
		this.fecha = fecha;
		this.concepto = concepto;
	}
	
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public int getIdGasto() {
		return idGasto;
	}
	public int getMonto() {
		return monto;
	}
	public int getFondoTomado() {
		return fondoTomado;
	}
	public String getFecha() {
		return fecha;
	}

	public String getFondoTomadoLetra() {
		return fondoTomadoLetra;
	}

	public void setFondoTomadoLetra(String fondoTomadoLetra) {
		this.fondoTomadoLetra = fondoTomadoLetra;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return concepto;
	}
	
}
