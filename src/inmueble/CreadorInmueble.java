package inmueble;

import java.util.HashMap;

/**
 * Singleton
 * @author Usuario
 *
 */
public class CreadorInmueble {

	private CreadorComponente creadorComp;
	
	CreadorInmueble(){
		this.setCreadorComp(new CreadorComponente());
	}

	public Inmueble crearInmueble(int tipoTecho, int tipoPiso){
		HashMap<String, Componente> componentes = this.creadorComp.crearComponentes(tipoTecho, tipoPiso);
		
		Inmueble inmueble = new Inmueble(componentes);
		
		return inmueble;
	}

	public CreadorComponente getCreadorComp() {
		return creadorComp;
	}

	public void setCreadorComp(CreadorComponente creadorComp) {
		this.creadorComp = creadorComp;
	}
}
