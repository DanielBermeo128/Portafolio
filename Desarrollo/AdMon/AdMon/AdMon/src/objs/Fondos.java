package objs;

public class Fondos {
	
	private String nombre;
	private int montoDeseado, capitalActual, idFondo;
	
	public Fondos(int idFondo, int montoDeseado,String nombre, int capitalActual) {
		super();
		this.nombre = nombre;
		this.montoDeseado = montoDeseado;
		this.capitalActual = capitalActual;
		this.idFondo = idFondo;
	}
	
	

	public Fondos(String nombre, int montoDeseado, int capitalActual) {
		super();
		this.idFondo = -1;
		this.nombre = nombre;
		this.montoDeseado = montoDeseado;
		this.capitalActual = capitalActual;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMontoDeseado() {
		return montoDeseado;
	}

	public void setMontoDeseado(int montoDeseado) {
		this.montoDeseado = montoDeseado;
	}

	public int getCapitalActual() {
		return capitalActual;
	}

	public void setCapitalActual(int capitalActual) {
		this.capitalActual = capitalActual;
	}

	public int getIdFondo() {
		return idFondo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNombre();
	}
	
	
	
	
	
}
