package controladores;

import java.util.List;

import componente.Componente;
import inmueble.Inmueble;

public class Manager {

	private List<Inmueble> inmuebles;
	private static Manager instance = null;
	private Ponderador ponderador;
	
	public static Manager getInstance() {
      if(instance == null) {
         instance = new Manager();
      }
      return instance;
    }
	
	public void cargarDatos(){
		this.ponderador = Ponderador.getInstance();
		this.inmuebles = CargadorDatos.getInstance().crearInmuebles();
		this.ponderar();
	}
	
	public void ponderar(){
		this.ponderador.ponderarYOrdenar(this.inmuebles);
	}
	/**
	 * Reemplaza el componente viejo por nuevo segun la clave del mapa
	 * @param pos
	 * @param componenteEdit
	 * @param componente
	 */
	public void editarInmueble(int pos, String componenteEdit, Componente componente){
		inmuebles.get(pos).getComponentes().put(componenteEdit, componente);
		this.ponderar();
	}
	
	public List<Inmueble> getInmuebles(){
		return this.inmuebles;
	}
}
