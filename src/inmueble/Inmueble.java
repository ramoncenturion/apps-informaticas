package inmueble;

import java.util.HashMap;

import componente.Componente;

public class Inmueble {
	private HashMap<String, Componente> componentes;
	private String descripcion;
	private double ponderacion;
	
	Inmueble(String descripcion, HashMap<String, Componente> componentes ){
		this.setDescripcion(descripcion);
		this.setComponentes(componentes);
	}

	public HashMap<String, Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(HashMap<String, Componente> componentes) {
		this.componentes = componentes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(double ponderacion) {
		this.ponderacion = ponderacion;
	}
	
}
