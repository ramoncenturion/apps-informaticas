package inmueble;

import java.util.HashMap;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		int techo_un_agua = 1;
		int piso_madera = 2;
		CreadorInmueble creador = new CreadorInmueble();
		Inmueble inmueble = creador.crearInmueble(techo_un_agua,piso_madera);
		System.out.println("Promedio: "+inmueble.getValor());
		HashMap<String, Componente> componentes = inmueble.getComponentes();
		Set<String> claves = inmueble.getComponentes().keySet();
		for (String clave : claves) {
			Componente componente = componentes.get(clave);
			System.out.println(componente.getTipo()+": "+componente.getValor());
		}
	}

}
