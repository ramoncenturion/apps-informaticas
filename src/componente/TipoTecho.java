package componente;

public enum TipoTecho {
	UN_AGUA("Techo a 1 Agua",1), DOS_AGUAS("Techo a 2 Aguas",2),
	VARIAS_AGUAS("Techo a Varias Aguas",3), PLANO("Techo Plano",4);
	
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
