package es.iestetuan.dvj.dao;

import java.util.List;
import es.iestetuan.dvj.dao.vo.Alumno;

public interface IAlumno {
	
	public Alumno getAlumno(int id);
	public List<Alumno> getListaAlumno();
	public void cargarProperties();
	public void crearFicheros();
	public void borrarArchivos();
	public void CrearDirectoriosJSON();
	public void CrearDirectoriosXML();
	public void ElegirModoUsoProperties();
}
