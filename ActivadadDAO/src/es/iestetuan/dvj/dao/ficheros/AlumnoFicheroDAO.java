package es.iestetuan.dvj.dao.ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import es.iestetuan.dvj.dao.IAlumno;
import es.iestetuan.dvj.dao.vo.Alumno;

public class AlumnoFicheroDAO implements IAlumno {

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
