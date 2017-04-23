package componente;

public class Techo implements Componente {

	private TipoTecho tipo;
	
	public Techo(int tipo){
		this.setTipoTecho(TipoTecho.values()[tipo-1]);
	}

	public TipoTecho getTipoTecho() {
		return tipo;
	}

	public void setTipoTecho(TipoTecho tipo) {
		this.tipo = tipo;
	}

	@Override
	public String getDescripcion() {
		return this.getTipoTecho().getNombre();
	}

	@Override
	public int getValor() {
		return this.getTipoTecho().getValor();
	}
	
}
