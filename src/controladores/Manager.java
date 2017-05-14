package controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import componente.Componente;
import componente.pared.TipoLadrilloPared;
import componente.pared.TipoRevestimientoExtPared;
import componente.pared.TipoRevestimientoIntPared;
import componente.piso.TipoPiso;
import componente.techo.TipoTecho;
import inmueble.CreadorInmueble;
import inmueble.Inmueble;

public class Manager {

	private static Manager instance = null;
	private CreadorInmueble creador;
	private Ponderador ponderador;
	private HashMap<String,Integer> componentesMap;
	private List<Inmueble> inmuebles;
	
	public static Manager getInstance() {
      if(instance == null) {
         instance = new Manager();
      }
      return instance;
    }
	
	private Manager(){
		this.ponderador = Ponderador.getInstance();
    	this.creador = CreadorInmueble.getInstance();
    	cargarMapaComponentes();
	}
	
	public void cargarDatos(){
		this.inmuebles = crearInmuebles();
		this.ponderar();
	}
	

    private void cargarMapaComponentes() {
		this.componentesMap  = new HashMap<String,Integer>();
		TipoPiso[] pisos = TipoPiso.values();
		for (TipoPiso tipoPiso : pisos) {
			this.componentesMap.put(tipoPiso.getDescripcion(), tipoPiso.getValor());	
		}
		TipoTecho[] techos = TipoTecho.values();
		for (TipoTecho tipoTecho : techos) {			
			this.componentesMap.put(tipoTecho.getDescripcion(), tipoTecho.getValor());
		}
		TipoLadrilloPared[] ladrillos = TipoLadrilloPared.values();
		for (TipoLadrilloPared tipoLadrilloPared : ladrillos) {			
			this.componentesMap.put(tipoLadrilloPared.getDescripcion(), tipoLadrilloPared.getValor());
		}
		TipoRevestimientoIntPared[] revestimientosInt = TipoRevestimientoIntPared.values();
		for (TipoRevestimientoIntPared tipoRevestimientoIntPared : revestimientosInt) {			
			this.componentesMap.put(tipoRevestimientoIntPared.getDescripcion(), tipoRevestimientoIntPared.getValor());
		}
		TipoRevestimientoExtPared[] revestimientosExt = TipoRevestimientoExtPared.values();
		for (TipoRevestimientoExtPared tipoRevestimientoExtPared : revestimientosExt) {			
			this.componentesMap.put(tipoRevestimientoExtPared.getDescripcion(), tipoRevestimientoExtPared.getValor());
		}

	}

	public List<Inmueble> crearInmuebles(){	
		List<Inmueble> inmuebles = new ArrayList<Inmueble>();
		
		try {
			File fXmlFile = new File("resources\\dataEntry\\inmuebles.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("inmueble");
	
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
//				System.out.println("\nCurrent Element :" + nNode.getNodeName());
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					String propietario = eElement.getElementsByTagName("propietario").item(0).getTextContent();
					String costo = eElement.getElementsByTagName("costo").item(0).getTextContent();
					String tipoPiso = eElement.getElementsByTagName("piso").item(0).getChildNodes().item(1).getTextContent();
					String tipoParedLadrillo = eElement.getElementsByTagName("pared").item(0).getChildNodes().item(1).getTextContent();
					String tipoParedRevInt = eElement.getElementsByTagName("pared").item(0).getChildNodes().item(3).getTextContent();
					String tipoParedRevExt = eElement.getElementsByTagName("pared").item(0).getChildNodes().item(5).getTextContent();
					String tipoTecho = eElement.getElementsByTagName("techo").item(0).getChildNodes().item(1).getTextContent();
//					System.out.println("Nombre : " + nombre);
//					System.out.println("Tipo Piso : " + tipoPiso);
//					System.out.println("Tipo Techo : " + tipoTecho);
					
					
					//Creo los inmuebles
					Inmueble inmueble = creador.crearInmueble(nombre,propietario,Integer.valueOf(costo),
							this.componentesMap.get(tipoTecho),this.componentesMap.get(tipoPiso),
							this.componentesMap.get(tipoParedLadrillo),this.componentesMap.get(tipoParedRevInt),
							this.componentesMap.get(tipoParedRevExt));
					inmuebles.add(inmueble);
				}
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		return inmuebles;
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
