package modelo;

public class Profesor {
	
	private String Prof_Cod;
	private	String Prof_Nombre;
	private String Prof_Apellidos;
	private	int Prof_Edad;
	private	int Prof_Telefono;
	private String Prof_DNI;
	private String Prof_Curso;
	
	public String getProf_Cod() {
		return Prof_Cod;
	}
	public void setProf_Cod(String prof_Cod) {
		Prof_Cod = prof_Cod;
	}
	public String getProf_Nombre() {
		return Prof_Nombre;
	}
	public void setProf_Nombre(String prof_Nombre) {
		Prof_Nombre = prof_Nombre;
	}
	public String getProf_Apellidos() {
		return Prof_Apellidos;
	}
	public void setProf_Apellidos(String prof_Apellidos) {
		Prof_Apellidos = prof_Apellidos;
	}
	public int getProf_Edad() {
		return Prof_Edad;
	}
	public void setProf_Edad(int prof_Edad) {
		Prof_Edad = prof_Edad;
	}
	public int getProf_Telefono() {
		return Prof_Telefono;
	}
	public void setProf_Telefono(int prof_Telefono) {
		Prof_Telefono = prof_Telefono;
	}
	public String getProf_DNI() {
		return Prof_DNI;
	}
	public void setProf_DNI(String prof_DNI) {
		Prof_DNI = prof_DNI;
	}
	public String getProf_Curso() {
		return Prof_Curso;
	}
	public void setProf_Curso(String prof_Curso) {
		Prof_Curso = prof_Curso;
	}
	
	
	public String nuevaNota(){
		
		String sql = "INSERT INTO NOTAS (Nota_Codigo,Nota_Alum_Codigo,Nota_Asig_Codigo,Nota_Prof_Codigo,Nota_Trim1,Nota_Trim2,Nota_Trim3,Nota_Calif) VALUES (?,?,?,?,?,?,?,?)";
		return sql;
		
	}
	
	
	public String modificarNota(){
		
	String sql = "UPDATE NOTAS SET  Nota_Alum_Codigo=?, Nota_Asig_Codigo=?, Nota_Prof_Codigo=?, Nota_Trim1=?, Nota_Trim2=?,Nota_Trim3=?,Nota_Calif=? "
            + "WHERE Nota_Codigo=?";
	return sql;
	
	}
	
	public String eliminarNota(){
		
		String sql = "DELETE FROM  NOTAS WHERE Nota_Codigo=?";
		return sql;
	}
	
	
	
	public String mostrarProfesor(){
		
		String sql = "select * FROM PROFESORES";			
		return sql;
		
	}
	
	
	
	
	
}
