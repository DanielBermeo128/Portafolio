package objs;

public class Ingresos {

	int idIngreso, monto, fondoDestino;
	String fecha,concepto,fondoDestinoLetra;
	
	
	public Ingresos(int idIngreso, String fecha, int monto, String concepto, int fondoDestino ) {
		super();
		this.idIngreso = idIngreso;
		this.monto = monto;
		this.fondoDestino = fondoDestino;
		this.fecha = fecha;
		this.concepto = concepto;
	}
	
	
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public int getIdIngreso() {
		return idIngreso;
	}
	public int getMonto() {
		return monto;
	}
	public int getFondoDestino() {
		return fondoDestino;
	}
	public String getFecha() {
		return fecha;
	}


	public String getFondoDestinoLetra() {
		return fondoDestinoLetra;
	}


	public void setFondoDestinoLetra(String fondoDestinoLetra) {
		this.fondoDestinoLetra = fondoDestinoLetra;
	}
	
	
}
