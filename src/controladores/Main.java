package controladores;

import java.util.List;

import componente.Piso;
import componente.Techo;
import inmueble.Inmueble;

public class Main {
	
	public static void main(String[] args) {
		Manager managerInmueble = Manager.getInstance();
		managerInmueble.cargarDatos();
		
		List<Inmueble> inmuebles = managerInmueble.getInmuebles();
		
		
		listarInmuebles(inmuebles);
		
		managerInmueble.editarInmueble(0, "TECHO", new Techo(1));
		managerInmueble.editarInmueble(0, "PISO", new Piso(1));
		
		listarInmuebles(inmuebles);
		
		
//		listarTechos(inmuebles);
	}
	
	
//	private static void listarTechos(List<Inmueble> inmuebles) {
//		System.out.println("*********************************************");
//		System.out.println("Muestro los tipos de techos de los inmuebles");
//		for (Inmueble inmueble : inmuebles) {
//			System.out.println(inmueble.getComponentes().get("TECHO").getDescripcion());
//		}
//	}


	private static void listarInmuebles(List<Inmueble> inmuebles) {
		
		for (Inmueble inmueble : inmuebles) {
			System.out.println("Inmueble "+inmueble.getDescripcion());
//			HashMap<String, Componente> componentes = inmueble.getComponentes();
			
//			Set<String> claves = inmueble.getComponentes().keySet();
//			for (String clave : claves) {
//				Componente componente = componentes.get(clave);
//				System.out.println(componente.getDescripcion()+": "+componente.getValor());
//			}
			System.out.println("Ponderacion: "+inmueble.getPonderacion());
			System.out.println("--------------------------------------------");
		}
	}
}
