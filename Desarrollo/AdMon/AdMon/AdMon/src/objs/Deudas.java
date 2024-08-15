package objs;

public class Deudas {


	String concepto,fecha;
	int monto,estado,idDeuda;
	public Deudas(int idDeuda,String concepto, int monto, int estado, String fecha) {
		super();
		this.concepto = concepto;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public String getEstado() {
		if(estado==1) {
			return "Activa";
		}else {
			return "Innactiva";
		}
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIdDeuda() {
		return idDeuda;
	}
	public void setIdDeuda(int idDeuda) {
		this.idDeuda = idDeuda;
	}
	
	
	
}
