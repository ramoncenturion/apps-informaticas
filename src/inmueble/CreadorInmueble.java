package inmueble;

import java.util.HashMap;

import componente.Componente;
import componente.CreadorComponente;

/**
 * Singleton
 * @author Usuario
 *
 */
public class CreadorInmueble {

	private static CreadorInmueble instance = null;
	private CreadorComponente creadorComp;
	  
    public static CreadorInmueble getInstance() {
      if(instance == null) {
         instance = new CreadorInmueble();
      }
      return instance;
    }
    
    protected CreadorInmueble(){
		this.setCreadorComp(CreadorComponente.getInstance());
	}

	public Inmueble crearInmueble(String descripcion, int tipoTecho, int tipoPiso){
		HashMap<String, Componente> componentes = this.creadorComp.crearComponentes(tipoTecho, tipoPiso);
		
		Inmueble inmueble = new Inmueble(descripcion,componentes);
		
		return inmueble;
	}

	public CreadorComponente getCreadorComp() {
		return creadorComp;
	}

	public void setCreadorComp(CreadorComponente creadorComp) {
		this.creadorComp = creadorComp;
	}
}
