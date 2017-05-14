package componente.pared;

public enum TipoLadrilloPared {
	PERFORADO_AL_CANTO("perforado al canto",1), COCIDO_TIERRA("cocido de tierra",2),
	ADOBE_TIERRA("adobe de tierra",3), TIERRA_PERFORADO("de tierra perforado",4),
	MACIZO("macizo",5), CLINKER_GRESIFICADO("clínker o gresificado",6),
	HORMIGON("bloques de hormigón",7);

	private String descripcion;
	private	int valor;
	
	private TipoLadrilloPared(String descripcion, int valor){
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
