package es.iestetuan.dvj.dao.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.iestetuan.dvj.dao.IAlumno;
import es.iestetuan.dvj.dao.IAlumnoXML;
import es.iestetuan.dvj.dao.vo.Alumno;

public class UsuarioFicheroXMLDao implements IAlumnoXML {

	List<Alumno> ListaAlumnos = new ArrayList<Alumno>();
	List<Alumno> ListaAlumnos1 = new ArrayList<Alumno>();
	Alumno alumno1;

	@Override
	public Alumno getAlumno(int id) {
		String ruta = "./Recursos/alumnos-dam2-nuevos.xml";
		File file = new File(ruta);
		Alumno alumno1 = new Alumno();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			
			
			NodeList nList = doc.getElementsByTagName("alumno");
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String comprobar = Integer.toString(id);
						if(eElement.getAttribute("id").equals(comprobar)) {
							System.out.println(comprobar);
							String idXML= eElement.getAttribute("id");
							String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
							String apellido1 = eElement.getElementsByTagName("apellido1").item(0).getTextContent();
							String apellido2 = eElement.getElementsByTagName("apellido2").item(0).getTextContent();
							
							alumno1.setId(Integer.parseInt(idXML));
							alumno1.setNombre(nombre);
							alumno1.setApellido1(apellido1);
							alumno1.setApellido2(apellido2); 
							
						}
					
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return alumno1;
	}

	@Override
	public List<Alumno> getListaAlumno() {
		String ruta = "./Recursos/alumnos-dam2-nuevos.xml";
		File file = new File(ruta);
		
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("alumno");
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String id= eElement.getAttribute("id");
					String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					String apellido1 = eElement.getElementsByTagName("apellido1").item(0).getTextContent();
					String apellido2 = eElement.getElementsByTagName("apellido2").item(0).getTextContent();
					Alumno alumno1 = new Alumno();
					alumno1.setId(Integer.parseInt(id));
					alumno1.setNombre(nombre);
					alumno1.setApellido1(apellido1);
					alumno1.setApellido2(apellido2);
					
					ListaAlumnos.add(alumno1);
					
							
					
				}
				
			}
			
			for(Alumno lista  : ListaAlumnos) {
				System.out.println(lista.getNombre() + " " + lista.getApellido1() + " " + lista.getApellido2());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ListaAlumnos;
	}
	
	public List<Alumno> getListaAlumnoInicial() {
		String ruta = "./Recursos/alumnos-dam2-inicial.txt";
		File file = new File(ruta);
		FileReader fr = null;
		BufferedReader bf = null;
		String Linea = null;
		
		boolean primeraVez = true;
		try {
			fr= new FileReader(file, StandardCharsets.UTF_8);
			bf = new BufferedReader(fr);
			
			while((Linea=bf.readLine())!=null) {
				String[] partes = Linea.split(",");
				if(primeraVez) {
					primeraVez=false;
				} else {
					if(partes.length > 3) {
						Alumno AlumnoEJ = new Alumno();
						int ID = Integer.parseInt(partes[0]);
						AlumnoEJ.setId(ID);
						AlumnoEJ.setNombre(partes[1]);
						AlumnoEJ.setApellido1(partes[2]);
						AlumnoEJ.setApellido2(partes[3]);
						ListaAlumnos.add(AlumnoEJ);
						
					} else if(partes.length <= 3) {
						Alumno AlumnoEJ = new Alumno();
						int ID = Integer.parseInt(partes[0]);
						AlumnoEJ.setId(ID);
						AlumnoEJ.setNombre(partes[1]);
						AlumnoEJ.setApellido1(partes[2]);
						ListaAlumnos.add(AlumnoEJ);
					}
				}

			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		return ListaAlumnos;
	}

	@Override
	public Alumno guardarUsuarios() {
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			Element eRaiz = doc.createElement("Alumnos");
			doc.appendChild(eRaiz);
			

			
			
			for(Alumno lista  : ListaAlumnos) {
				
				Element eAlumno = doc.createElement("Alumno");
				eRaiz.appendChild(eAlumno);
				
				Attr Attr = doc.createAttribute("id");
				eAlumno.setAttributeNode(Attr);
				Attr.setValue(String.valueOf(lista.getId()));
				
				Element eNombre = doc.createElement("Nombre");
				eAlumno.appendChild(eNombre);
				eNombre.setTextContent(lista.getNombre());
				
				Element eApellido1 = doc.createElement("Apellido1");
				eAlumno.appendChild(eApellido1);
				eApellido1.setTextContent(lista.getApellido1());
				
				Element eApellido2 = doc.createElement("Apellido2");
				eAlumno.appendChild(eApellido2);
				eApellido2.setTextContent(lista.getApellido2());
				
				
				
				
				
			}
			
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("./Recursos/alumnos-dam2.xml"));
			
			
			transformer.transform(source, result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	//NO TENGO CLARO QUE HACER, IBA A INTENTAR COMPARAR DOS LISTAS CON CADA UNO DE LOS FICHEROS PARA COMPROBAR EL ID Y SI NO ESTABA AÑADIRLO A LA LISTA
	public Alumno AltaAlumno(int id) {
		String ruta = "./Recursos/alumnos-dam2.xml";
		File file = new File(ruta);
		
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("alumno");
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String idXML= eElement.getAttribute("id");
					String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					String apellido1 = eElement.getElementsByTagName("apellido1").item(0).getTextContent();
					String apellido2 = eElement.getElementsByTagName("apellido2").item(0).getTextContent();
					Alumno alumno1 = new Alumno();
					alumno1.setId(Integer.parseInt(idXML));
					alumno1.setNombre(nombre);
					alumno1.setApellido1(apellido1);
					alumno1.setApellido2(apellido2);
					
					ListaAlumnos.add(alumno1);
					
							
					
				}
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String ruta1 = "./Recursos/alumnos-dam2-nuevos.xml";
			File file1 = new File(ruta1);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("alumno");
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String idXML= eElement.getAttribute("id");
					String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					String apellido1 = eElement.getElementsByTagName("apellido1").item(0).getTextContent();
					String apellido2 = eElement.getElementsByTagName("apellido2").item(0).getTextContent();
					Alumno alumno1 = new Alumno();
					alumno1.setId(Integer.parseInt(idXML));
					alumno1.setNombre(nombre);
					alumno1.setApellido1(apellido1);
					alumno1.setApellido2(apellido2);
					
					ListaAlumnos1.add(alumno1);
					
							
					
				}
			
			}
			
			Element eRaiz = doc.createElement("Alumnos");
			doc.appendChild(eRaiz);
			
			for(Alumno lista  : ListaAlumnos) {
				
				if(lista.getId() != id) {
					Element eAlumno = doc.createElement("Alumno");
					eRaiz.appendChild(eAlumno);
					
					Attr Attr = doc.createAttribute("id");
					eAlumno.setAttributeNode(Attr);
					Attr.setValue(String.valueOf(lista.getId()));
					
					Element eNombre = doc.createElement("Nombre");
					eAlumno.appendChild(eNombre);
					eNombre.setTextContent(lista.getNombre());
					
					Element eApellido1 = doc.createElement("Apellido1");
					eAlumno.appendChild(eApellido1);
					eApellido1.setTextContent(lista.getApellido1());
					
					Element eApellido2 = doc.createElement("Apellido2");
					eAlumno.appendChild(eApellido2);
					eApellido2.setTextContent(lista.getApellido2());
				}

			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("./Recursos/alumnos-dam2.xml"));
			
			
			transformer.transform(source, result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		


		
		return null;
	}

	@Override
	public Alumno BorrarAlumno(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno ModificarAlumno(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
