package modelo;

public class Asignatura {
	
	private String Asig_Cod;
	private String Asig_Nombre;
	private String Prof_Asig_Cod;
	
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
