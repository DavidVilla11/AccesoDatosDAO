package es.iestetuan.dvj.dao.vo;

public class Alumno extends Profesor {
	
	protected int id;


	public Alumno(int id) {
		super();
		this.id = id;
	}
	
	public Alumno() {
		super();	
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Alumno [nia=" + id + ", nie=" + nie + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", email=" + email + "]";
	}
	
	
	
	
	
}
