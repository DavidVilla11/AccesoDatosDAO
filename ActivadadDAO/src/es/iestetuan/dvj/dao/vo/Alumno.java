package es.iestetuan.dvj.dao.vo;

public class Alumno extends Profesor {
	
	protected int nia;


	public Alumno(int nia) {
		super();
		this.nia = nia;
	}
	
	public Alumno() {
		super();	
	}

	public int getNia() {
		return nia;
	}


	public void setNia(int nia) {
		this.nia = nia;
	}

	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", nie=" + nie + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", email=" + email + "]";
	}
	
	
	
	
	
}
