package inmueble;

public enum TipoTecho {
	UN_AGUA("Techo a 1 Agua",1), DOS_AGUAS("Techo a 2 aguas",2),
	VARIAS_AGUAS("Techo a Varias Aguas",3), PLANO("Techo Plano",4);
	
	private String nombre;
	private	int valor;
	
	private TipoTecho(String nombre, int valor){
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
