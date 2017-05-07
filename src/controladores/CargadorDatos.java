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

import componente.TipoPiso;
import componente.TipoTecho;
import inmueble.CreadorInmueble;
import inmueble.Inmueble;

public class CargadorDatos {
	
	private HashMap<String,Integer> componentesMap;

	private CreadorInmueble creador;
	private static CargadorDatos instance = null;
	  
    public static CargadorDatos getInstance() {
      if(instance == null) {
         instance = new CargadorDatos();
      }
      return instance;
    }

    CargadorDatos(){
    	this.creador = CreadorInmueble.getInstance();
    	cargarMapaComponentes();
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
					String tipoPiso = eElement.getElementsByTagName("piso").item(0).getChildNodes().item(1).getTextContent();
					String tipoTecho = eElement.getElementsByTagName("techo").item(0).getChildNodes().item(1).getTextContent();
//					System.out.println("Nombre : " + nombre);
//					System.out.println("Tipo Piso : " + tipoPiso);
//					System.out.println("Tipo Techo : " + tipoTecho);
					
					
					//Creo los inmuebles
					Inmueble inmueble = creador.crearInmueble(nombre,this.componentesMap.get(tipoTecho),this.componentesMap.get(tipoPiso));
					inmuebles.add(inmueble);
				}
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		return inmuebles;
	}

	
}
