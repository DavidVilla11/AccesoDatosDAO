package es.iestetuan.dvj.dao;

import java.util.List;

import es.iestetuan.dvj.dao.vo.Alumno;

public interface IAlumnoXML {

	public Alumno getAlumno(int id);
	public List<Alumno> getListaAlumno();
	public List<Alumno> getListaAlumnoInicial();
	public Alumno guardarUsuarios ();
	public Alumno AltaAlumno(int id);
	public Alumno BorrarAlumno(int id);
	public Alumno ModificarAlumno(int id);
	
}
