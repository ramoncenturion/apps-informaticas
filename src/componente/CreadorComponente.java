package componente;

import java.util.HashMap;

public class CreadorComponente {
	
	protected CreadorComponente(){}
	
	private static CreadorComponente instance = null;
	  
    public static CreadorComponente getInstance() {
      if(instance == null) {
         instance = new CreadorComponente();
      }
      return instance;
    }
	   
	public HashMap<String, Componente> crearComponentes(int tipoTecho, int tipoPiso){
		HashMap<String, Componente> componentes = new HashMap<String, Componente>();
		
		componentes.put("TECHO",this.crearTecho(tipoTecho));
		componentes.put("PISO",this.crearPiso(tipoPiso));
		
		return componentes;
	}

	private Componente crearPiso(int tipoPiso) {
		return new Piso(tipoPiso);
	}

	private Componente crearTecho(int tipoTecho) {
		return new Techo(tipoTecho);
	}
}
