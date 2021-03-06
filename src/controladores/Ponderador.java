package controladores;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import componente.Componente;
import inmueble.Inmueble;

public class Ponderador {

	private static Ponderador instance = null;
	
	public static Ponderador getInstance() {
      if(instance == null) {
         instance = new Ponderador();
      }
      return instance;
    }
	
	public void ponderarYOrdenar(List<Inmueble> inmuebles){
		for (Inmueble inmueble : inmuebles) {
			double valorFinal = 0;
			HashMap<String, Componente> componentes = inmueble.getComponentes();
			Set<String> keys = componentes.keySet();
			for (String key : keys) {
				valorFinal += componentes.get(key).getValor();
			}
			valorFinal = valorFinal/componentes.size();
			inmueble.setPonderacion(valorFinal);
		}
		ordenar(inmuebles);
	}

	private void ordenar(List<Inmueble> inmuebles) {
		Collections.sort(inmuebles,new Comparator<Inmueble>(){
            public int compare(Inmueble i1,Inmueble i2){
				if (i1.getPonderacion()>i2.getPonderacion()){
					return -1;
				} else if (i1.getPonderacion()<i2.getPonderacion()){
					return 1;
				} else {					
					return 0;
				}
            }});
		
	}
	
}
