package modelo;

import java.io.Serializable;

public class Asignatura implements Serializable {

	private String Asig_Cod;
	private String Asig_Nombre;
	private String Prof_Asig_Cod;
	
	public Asignatura() {
		
	}

	public Asignatura(String asig_Cod, String asig_Nombre, String codigo_Prof) {

		this.setAsig_Cod(asig_Cod);
		this.setAsig_Nombre(asig_Nombre);
		this.setProf_Asig_Cod(codigo_Prof);
		
	}

	public String getAsig_Cod() {
		return Asig_Cod;
	}
	public void setAsig_Cod(String asig_Cod) {
		Asig_Cod = asig_Cod;
	}
	public String getAsig_Nombre() {
		return Asig_Nombre;
	}
	public void setAsig_Nombre(String asig_Nombre) {
		Asig_Nombre = asig_Nombre;
	}
	public String getProf_Asig_Cod() {
		return Prof_Asig_Cod;
	}
	public void setProf_Asig_Cod(String prof_Asig_Cod) {
		Prof_Asig_Cod = prof_Asig_Cod;
	}

	public String mostrarAsignatura(){

		String sql = "select * FROM ASIGNATURAS";			
		return sql;

	}
}
