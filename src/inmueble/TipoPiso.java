package inmueble;

public enum TipoPiso {
	
	LADRILLO("Ladrillo",1),MADERA("Madera",2), CERAMICOS("Ceramicos",3), 
	MARMOL("Marmol",4), CEMENTO_Y_HORMIGÓN("Cemento y Hormigon",5), MOSAICOS("Mosaicos",6), 
	ENTABLONADA("Entablonada",7), FLOTANTE("Flotante",8);
	
	private String nombre;
	private	int valor;
	
	private TipoPiso(String nombre, int valor){
		this.setNombre(nombre);
		this.setValor(valor);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
