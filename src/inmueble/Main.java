package inmueble;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	private static CreadorInmueble creador = CreadorInmueble.getInstance();
	
	public static void main(String[] args) {
		List<Inmueble> inmuebles = crearInmuebles();
		
		listarInmuebles(inmuebles);
		listarTechos(inmuebles);
	}
	
	
	private static void listarTechos(List<Inmueble> inmuebles) {
		System.out.println("*********************************************");
		System.out.println("Muestro los tipos de techos de los inmuebles");
		for (Inmueble inmueble : inmuebles) {
			System.out.println(inmueble.getComponentes().get("TECHO").getDescripcion());
		}
	}


	private static void listarInmuebles(List<Inmueble> inmuebles) {
		for (Inmueble inmueble : inmuebles) {
			System.out.println("Inmueble "+inmueble.getDescripcion());
			HashMap<String, Componente> componentes = inmueble.getComponentes();
			
			Set<String> claves = inmueble.getComponentes().keySet();
			for (String clave : claves) {
				Componente componente = componentes.get(clave);
				System.out.println(componente.getDescripcion()+": "+componente.getValor());
			}
			System.out.println("Promedio: "+inmueble.getValor());
			System.out.println("--------------------------------------------");
		}
	}


	public static List<Inmueble> crearInmuebles(){
		
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
					Inmueble inmueble = creador.crearInmueble(nombre,Integer.valueOf(tipoTecho),Integer.valueOf(tipoPiso));
					inmuebles.add(inmueble);
				}
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		return inmuebles;
	}

}
