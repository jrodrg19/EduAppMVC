package modelo;

public class Profesor {
	
	private String prof_Cod;
	private	String prof_Nombre;
	private String prof_Apellidos;
	private	int prof_Edad;
	private	String prof_Telefono;
	private String prof_DNI;
	private String prof_Curso;
	
	public Profesor() {

	}
	
	public Profesor(String cod, String nombre, String apell, int edad, String tlf, String dni, String curso){
				
		this.setProf_Cod(cod);
		this.setProf_Nombre(nombre);
		this.setProf_Apellidos(apell);
		this.setProf_Edad(edad);
		this.setProf_Telefono(tlf);
		this.setProf_DNI(dni);
		this.setProf_Curso(curso);
		
	}
	
	public String getProf_Cod() {
		return prof_Cod;
	}
	public void setProf_Cod(String prof_Cod) {
		this.prof_Cod = prof_Cod;
	}
	public String getProf_Nombre() {
		return prof_Nombre;
	}
	public void setProf_Nombre(String prof_Nombre) {
		this.prof_Nombre = prof_Nombre;
	}
	public String getProf_Apellidos() {
		return prof_Apellidos;
	}
	public void setProf_Apellidos(String prof_Apellidos) {
		this.prof_Apellidos = prof_Apellidos;
	}
	public int getProf_Edad() {
		return prof_Edad;
	}
	public void setProf_Edad(int prof_Edad) {
		this.prof_Edad = prof_Edad;
	}
	public String getProf_Telefono() {
		return prof_Telefono;
	}
	public void setProf_Telefono(String prof_Telefono) {
		this.prof_Telefono = prof_Telefono;
	}
	public String getProf_DNI() {
		return prof_DNI;
	}
	public void setProf_DNI(String prof_DNI) {
		this.prof_DNI = prof_DNI;
	}
	public String getProf_Curso() {
		return prof_Curso;
	}
	public void setProf_Curso(String prof_Curso) {
		this.prof_Curso = prof_Curso;
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
