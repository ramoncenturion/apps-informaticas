package componente;

public enum TipoPiso {
	
	LADRILLO("Ladrillo",1),MADERA("Madera",2), CERAMICOS("Ceramicos",3), 
	MARMOL("Marmol",4), CEMENTO_Y_HORMIGÓN("Cemento y Hormigon",5), MOSAICOS("Mosaicos",6), 
	ENTABLONADA("Entablonada",7), FLOTANTE("Flotante",8);
	
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
