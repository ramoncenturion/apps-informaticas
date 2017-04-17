package inmueble;

public class Piso implements Componente {

	private TipoPiso tipo;
	
	Piso(int tipo){
		this.setTipoPiso(TipoPiso.values()[tipo-1]);
	}

	public TipoPiso getTipoPiso() {
		return tipo;
	}

	public void setTipoPiso(TipoPiso tipo) {
		this.tipo = tipo;
	}

	@Override
	public String getDescripcion() {
		return this.getTipoPiso().getNombre();
	}

	@Override
	public int getValor() {
		return this.getTipoPiso().getValor();
	}
	
}
