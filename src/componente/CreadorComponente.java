package componente;

import java.util.HashMap;

import componente.pared.Pared;
import componente.piso.Piso;
import componente.techo.Techo;

public class CreadorComponente {
	
	protected CreadorComponente(){}
	
	private static CreadorComponente instance = null;
	  
    public static CreadorComponente getInstance() {
      if(instance == null) {
         instance = new CreadorComponente();
      }
      return instance;
    }
	   
	public HashMap<String, Componente> crearComponentes(int tipoTecho, int tipoPiso, 
			int tipoLadrilloPared, int tipoRevIntPared, int tipoRevExtPared){
		HashMap<String, Componente> componentes = new HashMap<String, Componente>();
		
		componentes.put("TECHO",this.crearTecho(tipoTecho));
		componentes.put("PISO",this.crearPiso(tipoPiso));
		componentes.put("PARED",this.crearPared(tipoLadrilloPared,tipoRevIntPared,tipoRevExtPared));
		
		return componentes;
	}

	private Componente crearPiso(int tipoPiso) {
		return new Piso(tipoPiso);
	}

	private Componente crearTecho(int tipoTecho) {
		return new Techo(tipoTecho);
	}
	
	private Componente crearPared(int tipoLadrilloPared, int tipoRevIntPared, int tipoRevExtPared) {
		return new Pared(tipoLadrilloPared,tipoRevIntPared,tipoRevExtPared);
	}
}
