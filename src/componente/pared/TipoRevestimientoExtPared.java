package componente.pared;

public enum TipoRevestimientoExtPared {
	LADRILLO_VISTA("ladrillo a la vista",1), CERAMICOS("cerámico",2),
	MADERA("madera",3), PIEDRA("piedra",4), 
	PETROS_CALIZOS("pétreos y calizos",3), LIGEROS("ligeros",4);
	
	private String descripcion;
	private	int valor;
	
	private TipoRevestimientoExtPared(String descripcion, int valor){
		this.setDescripcion(descripcion);
		this.setValor(valor);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
