package es.iestetuan.dvj;

import es.iestetuan.dvj.dao.IAlumno;
import es.iestetuan.dvj.dao.IAlumnoXML;
import es.iestetuan.dvj.dao.ficheros.AlumnoFicheroDAO;
import es.iestetuan.dvj.dao.xml.UsuarioFicheroXMLDao;
import es.iestetuan.dvj.practica2.Metodos;

public class GestorUsuarios {

	public static void main(String[] args) {
		
		IAlumnoXML prueba = new UsuarioFicheroXMLDao();
		prueba.getListaAlumnoInicial();
		prueba.guardarUsuarios();
	}

}
