package inmueble;

import java.util.HashMap;
import java.util.Set;

import componente.Componente;

public class Inmueble {
	private HashMap<String, Componente> componentes;
	private String descripcion;
	private double ponderacion;
	private Propietario propietario;
	private int costo;
	
	Inmueble(String descripcion, String nombreYApellidoProp, int costo, HashMap<String, Componente> componentes ){
		this.setDescripcion(descripcion);
		this.propietario = new Propietario(nombreYApellidoProp);
		this.costo = costo;
		this.setComponentes(componentes);
	}

	public HashMap<String, Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(HashMap<String, Componente> componentes) {
		this.componentes = componentes;
	}

	public String getDescripcion() {
		String descripcionComponentes = "";
		Set<String> claves = componentes.keySet();
		for (String clave : claves) {
			Componente componente = componentes.get(clave);
			descripcionComponentes += "\n"+componente.getDescripcion();
		}
		return descripcion+"\nPropietario: "+this.propietario.getNombreYApellido()+"\nPrecio: "+this.costo+descripcionComponentes;
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

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}
	
}
