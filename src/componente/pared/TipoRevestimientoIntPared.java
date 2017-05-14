package componente.pared;

public enum TipoRevestimientoIntPared {
	LADRILLO_VISTA("ladrillo a la vista",1), PIEDRA_PROYECTADA("piedra proyectada",2),
	ESTUCO_VENECIANO("estuco veneciano",3), VIN�LICOS("vin�licos",4),MICROCEMENTO("microcemento",1), 
	VENECITAS("venecitas",2), ESMALTADO("esmaltado",3), REVOQUE("revoque",4),MADERA("madera",1), 
	CER�MICA("cer�mica",2),HORMIG�N_PULIDO("hormig�n pulido",3), PIEDRA_NATURAL("piedra natural",4),
	PAPEL_PINTADO("papel pintado",1), AZULEJOS("azulejos",2), M�RMOL("m�rmol",3);
	
	private String descripcion;
	private	int valor;
	
	private TipoRevestimientoIntPared(String descripcion, int valor){
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
