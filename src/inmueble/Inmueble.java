package inmueble;

import java.util.HashMap;
import java.util.Set;

public class Inmueble {
	private HashMap<String, Componente> componentes;
	
	Inmueble(HashMap<String, Componente> componentes ){
		this.setComponentes(componentes);
	}

	public double getValor(){
		double valorFinal = 0;
		Set<String> keys = this.componentes.keySet();
		for (String key : keys) {
			valorFinal += this.componentes.get(key).getValor();
			
		}
		return valorFinal/this.componentes.size();
	}

	public HashMap<String, Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(HashMap<String, Componente> componentes) {
		this.componentes = componentes;
	}
	
}
