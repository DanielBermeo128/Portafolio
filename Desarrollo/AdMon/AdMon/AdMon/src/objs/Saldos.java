package objs;

public class Saldos {

	private String conceptoGasto, fechaGasto, fechaDeuda, conceptoDeuda;
	private int montoPendiente, idDeuda, idGasto;
	public Saldos(int idDeuda,int idGasto,String conceptoGasto, String fechaGasto, int montoPendiente) {
		super();
		this.idDeuda=idDeuda;
		this.conceptoGasto = conceptoGasto;
		this.fechaGasto = fechaGasto;
		this.montoPendiente = montoPendiente;
		this.idGasto = idGasto;
	}

	public Saldos(int idDeuda,int idGasto, String conceptoGasto, String fechaDeuda, String conceptoDeuda) {
		super();
		this.idDeuda=idDeuda;
		this.conceptoGasto = conceptoGasto;
		this.fechaDeuda = fechaDeuda;
		this.conceptoDeuda = conceptoDeuda;
		this.idGasto = idGasto;
	}

	public String getConceptoGasto() {
		return conceptoGasto;
	}

	public void setConceptoGasto(String conceptoGasto) {
		this.conceptoGasto = conceptoGasto;
	}

	public String getFechaGasto() {
		return fechaGasto;
	}

	public void setFechaGasto(String fechaGasto) {
		this.fechaGasto = fechaGasto;
	}

	public int getMontoPendiente() {
		return montoPendiente;
	}

	public void setMontoPendiente(int montoPendiente) {
		this.montoPendiente = montoPendiente;
	}

	public String getFechaDeuda() {
		return fechaDeuda;
	}

	public void setFechaDeuda(String fechaDeuda) {
		this.fechaDeuda = fechaDeuda;
	}

	public String getConceptoDeuda() {
		return conceptoDeuda;
	}

	public void setConceptoDeuda(String conceptoDeuda) {
		this.conceptoDeuda = conceptoDeuda;
	}
	
	public int getIdDeuda() {
		return this.idDeuda;
	}

	public int getIdGasto(){
		return this.idGasto;
	}
	
}
