package es.iestetuan.dvj.dao.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.Property;

import es.iestetuan.dvj.dao.IAlumno;
import es.iestetuan.dvj.dao.vo.Alumno;

public class AlumnoFicheroDAO implements IAlumno {

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
	
	public void CrearDirectoriosJSON() {

		Properties properties = new Properties();
		try {
			
			properties.load(new FileReader("C:/Users/David/eclipse-workspace/ActivadadDAO/src/Recursos/info-configuracion.properties.txt"));
			JSONObject jsonObject = Property.toJSONObject(properties);
			Enumeration<Object> keys = properties.keys();

			
			while(keys.hasMoreElements()) {
				Object key = keys.nextElement();
				if(!key.toString().contains("CrearInfoTemporalXML") && !key.toString().contains("CrearInfoTemporalTexto")){
				File directorio = new File((String) jsonObject.get(key.toString()));
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
					}else {
						System.out.println("No se ha creado");
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
	
	public void CrearDirectoriosXML() {
		Properties properties = new Properties();
		try {
			FileInputStream ficheroPropiedades = new FileInputStream("C:/Users/David/eclipse-workspace/ActivadadDAO/src/Recursos/info-configuracion.xml");
			properties.load(ficheroPropiedades);
			
			Enumeration<Object> keys = properties.keys();
			while(keys.hasMoreElements()) {
				Object key = keys.nextElement();
				if(!key.toString().contains("CrearInfoTemporalXML") && !key.toString().contains("CrearInfoTemporalTexto")){
				File directorio = new File((String) properties.get(key.toString()));
				if(!directorio.exists()) {
					if(directorio.mkdirs()) {
						continue;
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
	
	public Alumno getAlumno(int id) {
		String ruta = "C:/xampp/htdocs/aadd/recursos/alumnos-dam2-nuevos.txt";
		FileReader fr = null;
		BufferedReader bf = null;
		String Linea = null;
		Alumno AlumnoEJ = new Alumno();
		boolean primeraVez = true;
		try {
			fr = new FileReader(ruta, StandardCharsets.UTF_8);
			bf = new BufferedReader(fr);

			while ((Linea = bf.readLine()) != null) {
				String[] partes = Linea.split(",");
				if (primeraVez) {
					primeraVez = false;
				} else {
					int IDRecuperado = Integer.parseInt(partes[0]);
					if (id == IDRecuperado) {
						AlumnoEJ.setNia(IDRecuperado);
						AlumnoEJ.setNombre(partes[1]);
						AlumnoEJ.setApellido1(partes[2]);
						AlumnoEJ.setApellido2(partes[3]);
					}
				}
			}

		} catch (IOException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return AlumnoEJ;

	}

	@Override
	public List<Alumno> getListaAlumno() {
		String ruta = "C:/xampp/htdocs/aadd/recursos/alumnos-dam2-nuevos.txt";
		FileReader fr = null;
		BufferedReader bf = null;
		String Linea = null;
		List<Alumno> ListadoAlumno = new ArrayList<Alumno>();
		boolean primeraVez = true;
		try {
			fr = new FileReader(ruta, StandardCharsets.UTF_8);
			bf = new BufferedReader(fr);

			while ((Linea = bf.readLine()) != null) {
				String[] partes = Linea.split(",");
				if (primeraVez) {
					primeraVez = false;
				} else {
					if (partes.length > 3) {
						Alumno AlumnoEJ = new Alumno();
						int ID = Integer.parseInt(partes[0]);
						AlumnoEJ.setNia(ID);
						AlumnoEJ.setNombre(partes[1]);
						AlumnoEJ.setApellido1(partes[2]);
						AlumnoEJ.setApellido2(partes[3]);
						ListadoAlumno.add(AlumnoEJ);

					} else if (partes.length <= 3) {
						Alumno AlumnoEJ = new Alumno();
						int ID = Integer.parseInt(partes[0]);
						AlumnoEJ.setNia(ID);
						AlumnoEJ.setNombre(partes[1]);
						AlumnoEJ.setApellido1(partes[2]);
						ListadoAlumno.add(AlumnoEJ);
					}
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return ListadoAlumno;
	}

}
