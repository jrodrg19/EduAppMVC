package modelo;

public class Nota {
	
	private String Nota_Cod;
	private String Nota_Alum_Cod;
	private	String Nota_Asig_Cod;
	private String Nota_Prof_Cod;
	private String Nota_Admin_Cod;
	private	int Nota_Trim1;
	private	int Nota_Trim2;
	private	int Nota_Trim3;
	private	int Nota_Calif;
	
	public String getNota_Cod() {
		return Nota_Cod;
	}
	public void setNota_Cod(String nota_Cod) {
		Nota_Cod = nota_Cod;
	}
	public String getNota_Alum_Cod() {
		return Nota_Alum_Cod;
	}
	public void setNota_Alum_Cod(String nota_Alum_Cod) {
		Nota_Alum_Cod = nota_Alum_Cod;
	}
	public String getNota_Asig_Cod() {
		return Nota_Asig_Cod;
	}
	public void setNota_Asig_Cod(String nota_Asig_Cod) {
		Nota_Asig_Cod = nota_Asig_Cod;
	}
	public String getNota_Prof_Cod() {
		return Nota_Prof_Cod;
	}
	public void setNota_Prof_Cod(String nota_Prof_Cod) {
		Nota_Prof_Cod = nota_Prof_Cod;
	}
	public String getNota_Admin_Cod() {
		return Nota_Admin_Cod;
	}
	public void setNota_Admin_Cod(String nota_Admin_Cod) {
		Nota_Admin_Cod = nota_Admin_Cod;
	}
	public int getNota_Trim1() {
		return Nota_Trim1;
	}
	public void setNota_Trim1(int nota_Trim1) {
		Nota_Trim1 = nota_Trim1;
	}
	public int getNota_Trim2() {
		return Nota_Trim2;
	}
	public void setNota_Trim2(int nota_Trim2) {
		Nota_Trim2 = nota_Trim2;
	}
	public int getNota_Trim3() {
		return Nota_Trim3;
	}
	public void setNota_Trim3(int nota_Trim3) {
		Nota_Trim3 = nota_Trim3;
	}
	public int getNota_Calif() {
		return Nota_Calif;
	}
	public void setNota_Calif(int nota_Calif) {
		Nota_Calif = nota_Calif;
	}
	
	public String mostrarNota(){
		
		String sql = "select * FROM NOTAS";			
		return sql;
		
	}
	
	public String buscarNota(){
		
		String sql = "SELECT * FROM NOTAS WHERE Nota_Alum_Codigo = ? AND Nota_Prof_Codigo = ?  ";		
		return sql;
		
	}
	
	public String buscarCalificacion(){
		
		String sql = "SELECT * FROM NOTAS WHERE Nota_Alum_Codigo = ?";			
		return sql;
		
	}
}
