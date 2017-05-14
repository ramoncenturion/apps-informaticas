package componente.techo;

public enum TipoTecho {
	UN_AGUA("1 agua",1), DOS_AGUAS("2 aguas",2),
	VARIAS_AGUAS("varias aguas",3), PLANO("plano",4);
	
	private String descripcion;
	private	int valor;
	
	private TipoTecho(String descripcion, int valor){
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
