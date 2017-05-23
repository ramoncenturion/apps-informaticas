package componente.piso;

public enum TipoPiso {
	
	LADRILLO("Ladrillo",1),MADERA("Madera",2), CERAMICOS("Ceramicos",3), 
	MARMOL("Marmol",4), CEMENTO("cemento",5),CEMENTO_Y_HORMIGON("Cemento y Hormigon",6), 
	MOSAICOS("Mosaicos",7), ENTABLONADA("Entablonada",8), FLOTANTE("Flotante",9);
	
	private String descripcion;
	private	int valor;
	
	private TipoPiso(String descripcion, int valor){
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
