package es.iestetuan.dvj.practica2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Metodos {

	public void cargarProperties() {
		Properties properties = new Properties();
		
		
		try {
			properties.load(new FileReader("C:/Users/David/eclipse-workspace/ActivadadDAO/src/Recursos/info-configuracion.properties.txt"));
			
			Enumeration<Object> keys = properties.keys();
				
			while(keys.hasMoreElements()) {
				Object key = keys.nextElement();
				if(!key.toString().contains("CrearInfoTemporalXML") && !key.toString().contains("CrearInfoTemporalTexto")){
				File directorio = new File((String) properties.get(key.toString()));
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("Pues no se ha creado");
					}
				}else {
					System.out.println("El directorio existe");
				}
			}
		}
			
			System.out.println("Los directorios se han creado");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void crearFicheros() {
		
		Properties properties = new Properties();
		
		
		try {
			properties.load(new FileReader("C:/Users/David/eclipse-workspace/ActivadadDAO/src/Recursos/info-configuracion.properties.txt"));
			
			Enumeration<Object> keys = properties.keys();
				
			while(keys.hasMoreElements()) {
				Object key = keys.nextElement();
				if(key.toString().contains("CrearInfoTemporalXML") || key.toString().contains("CrearInfoTemporalTexto")) {
					File file = new File((String) properties.get(key.toString()));
					if(!file.exists()) {
						file.createNewFile();
					}else {
						System.out.println("El archivo existe");
					}
				}

			}
			
			System.out.println("Los directorios se han creado");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void borrarArchivos() {
		
		try {
			Scanner sc = new Scanner(System.in);
			String ruta = sc.nextLine();
			
			File fichero = new File(ruta);
			File[] ficheros = fichero.listFiles();
			
				for(File f: ficheros) {
						f.delete();
				}
				
				fichero.delete();
			
			
			sc.close();
		} finally {
		}
	}
	
	//No funciona JsonParse error, no entiendo por qué.
	
	public void CrearDirectoriosJSON() {
		
		String CrearInfoTemporalXML = null;
		String CrearInfoTemporalTexto = null;
		String ruta1 = null;
		String ruta2 = null;
		String ruta3 = null;
		String ruta4 = null;
		String ruta5 = null;
		String ruta6 = null;
		String ruta7 = null;
		String ruta8 = null;
		

	    try {

	        JSONParser parser = new JSONParser();
	        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("C:/Users/David/eclipse-workspace/ActivadadDAO/src/Recursos/info-configuracion.json"));

	        for (Object object : jsonArray)
	        {
	          JSONObject config = (JSONObject) object;

	          
	          if(ruta1 ==(String) config.get("ruta1")){
				File directorio = new File(ruta1);
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("Pues no se ha creado");
					}
				}else {
					System.out.println("El directorio existe");
				}
	          }

	          if(ruta2 ==(String) config.get("ruta2")){
				File directorio = new File(ruta2);
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("Pues no se ha creado");
					}
				}else {
					System.out.println("El directorio existe");
				}
	          }

	          if(ruta3 ==(String) config.get("ruta3")){
				File directorio = new File(ruta3);
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("Pues no se ha creado");
					}
				}else {
					System.out.println("El directorio existe");
				}
	          }

	          if(ruta4 ==(String) config.get("ruta4")){
				File directorio = new File(ruta4);
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("Pues no se ha creado");
					}
				}else {
					System.out.println("El directorio existe");
				}
	          }
	          
	          if(ruta5 ==(String) config.get("ruta5")){
				File directorio = new File(ruta5);
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("Pues no se ha creado");
					}
				}else {
					System.out.println("El directorio existe");
				}
	          }
	          
	          if(ruta6 ==(String) config.get("ruta6")){
				File directorio = new File(ruta6);
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("Pues no se ha creado");
					}
				}else {
					System.out.println("El directorio existe");
				}
	          }
	          
	          if(ruta7 ==(String) config.get("ruta7")){
				File directorio = new File(ruta7);
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("Pues no se ha creado");
					}
				}else {
					System.out.println("El directorio existe");
				}
	          }
	          
	          if(ruta8 ==(String) config.get("ruta8")){
				File directorio = new File(ruta8);
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("Pues no se ha creado");
					}
				}else {
					System.out.println("El directorio existe");
				}
	          }
	          
	          if(CrearInfoTemporalTexto == (String) config.get("CrearInfoTemporalTexto")) {
					File file = new File(CrearInfoTemporalTexto);
					if(!file.exists()) {
						file.createNewFile();
					}else {
						System.out.println("El archivo existe");
					}
	          }
	          
	         
			if(CrearInfoTemporalXML == (String) config.get("CrearInfoTemporalXML")) {
				File file = new File(CrearInfoTemporalXML);
				if(!file.exists()) {
					file.createNewFile();
				}else {
					System.out.println("El archivo existe");
				}
	          }
	          
	          
	        }

	    } catch (Exception e) {
	        System.out.println("Excepcion leyendo fichero de configuracion " + e);
	    }
			
		
	}


	public void CrearDirectoriosXML() {
		Properties propiedades = new Properties();
		File fichero = new File("C:/Users/David/eclipse-workspace/ActivadadDAO/src/Recursos/info-configuracion.xml");
		Document documento = null;
		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
			documento = dBuilder.parse(fichero);
			documento.getDocumentElement();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		NodeList nListIni = documento.getElementsByTagName("ruta1");
		NodeList nList = nListIni.item(0).getChildNodes();
		
		for(int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String clave = eElement.getNodeName();
					Node valor = eElement.getChildNodes().item(0);
					propiedades.setProperty(clave, valor.getNodeValue());
					Enumeration<Object> keys = propiedades.keys();
						
					while(keys.hasMoreElements()) {
						Object key = keys.nextElement();
						File directorio = new File((String) propiedades.get(key.toString()));
						if(!directorio.exists()) {
							if(directorio.mkdirs()) {
								continue;
							}else {
								System.out.println("Pues no se ha creado");
							}
						}else {
							System.out.println("El directorio existe");
						}
					}
				}
					
				}
	}
		
	
	public void ElegirModoUsoProperties() {
		System.out.println("Elige la manera de utilizar el archivo properties: 1-properties, 2-Json, 3-Xml.");
		Scanner sc = new Scanner(System.in);
		int ref = sc.nextInt();
		
		switch(ref) {
			case 1:
				cargarProperties();
				crearFicheros();
			break;
			case 2: 
				CrearDirectoriosJSON();
				break;
			case 3: 
				CrearDirectoriosXML();
				break;
		}
		
	}
	
	
}
