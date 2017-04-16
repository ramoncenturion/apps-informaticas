package inmueble;

import java.util.ArrayList;
import java.util.List;

public class Inmueble {

	private List<Componente> compomentes = new ArrayList<Componente>();
	
	Inmueble(int tipoTecho, int tipoPiso){
		Componente techo = new Techo(tipoTecho);
		this.compomentes.add(techo);
		Componente piso = new Piso(tipoPiso);
		this.compomentes.add(piso);
		
	}

	public double getValor(){
		double valorFinal = 0;
		for (Componente componente : compomentes) {
			valorFinal += componente.getValor();
		}
		return valorFinal/this.compomentes.size();
	}
	
	public List<Componente> getCompomentes() {
		return compomentes;
	}

	public void setCompomentes(List<Componente> compomentes) {
		this.compomentes = compomentes;
	}
}
