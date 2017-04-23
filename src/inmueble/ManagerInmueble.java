package inmueble;

import java.util.List;

import componente.Componente;

public class ManagerInmueble {

	private List<Inmueble> inmuebles;
	private static ManagerInmueble instance = null;
	private PonderadorInmueble ponderador;
	
	public static ManagerInmueble getInstance() {
      if(instance == null) {
         instance = new ManagerInmueble();
      }
      return instance;
    }
	
	public void inicializar(){
		this.ponderador = PonderadorInmueble.getInstance();
		this.inmuebles = Inicializador.getInstance().crearInmuebles();
		this.ponderar();
	}
	
	public void ponderar(){
		this.ponderador.ponderarYOrdenar(this.inmuebles);
	}
	
	public void editarInmueble(int pos, String componenteEdit, Componente componente){
		inmuebles.get(pos).getComponentes().put(componenteEdit, componente);
		this.ponderar();
	}
	
	public List<Inmueble> getInmuebles(){
		return this.inmuebles;
	}
}
