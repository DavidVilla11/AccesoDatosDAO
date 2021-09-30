package es.iestetuan.dvj;

import es.iestetuan.dvj.dao.IAlumno;
import es.iestetuan.dvj.dao.ficheros.AlumnoFicheroDAO;

public class GestorUsuarios {

	public static void main(String[] args) {
		
		IAlumno prueba = new AlumnoFicheroDAO();
		
		System.out.println(prueba.getAlumno(171).getApellido2());
		prueba.getListaAlumno().forEach(System.out::println);

	}

}
