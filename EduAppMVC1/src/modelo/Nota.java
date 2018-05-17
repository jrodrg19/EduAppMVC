package modelo;

public class Nota {
	
	private String nota_Cod;
	private String nota_Alum_Cod;
	private	String nota_Asig_Cod;
	private String nota_Prof_Cod;
	private String Nota_Admin_Cod;
	private	String nota_Trim1;
	private	String nota_Trim2;
	private	String nota_Trim3;
	private	String nota_Calif;
	
	public Nota() {
		
	}
	
	public Nota(String cod,String notaAl,String notAs,String notaProf, String notaAd, String trim1, String trim2, String trim3, String calif) {
		
		this.setNota_Admin_Cod(notaAd);
		this.setNota_Cod(cod);
		this.setNota_Alum_Cod(notaAl);
		this.setNota_Asig_Cod(notAs);
		this.setNota_Prof_Cod(notaProf);
		this.setNota_Trim1(trim1);
		this.setNota_Trim2(trim2);
		this.setNota_Trim3(trim3);
		this.setNota_Calif(calif);
		
	}
	
	public String getNota_Cod() {
		return nota_Cod;
	}

	public void setNota_Cod(String nota_Cod) {
		this.nota_Cod = nota_Cod;
	}

	public String getNota_Alum_Cod() {
		return nota_Alum_Cod;
	}

	public void setNota_Alum_Cod(String nota_Alum_Cod) {
		this.nota_Alum_Cod = nota_Alum_Cod;
	}

	public String getNota_Asig_Cod() {
		return nota_Asig_Cod;
	}

	public void setNota_Asig_Cod(String nota_Asig_Cod) {
		this.nota_Asig_Cod = nota_Asig_Cod;
	}

	public String getNota_Prof_Cod() {
		return nota_Prof_Cod;
	}

	public void setNota_Prof_Cod(String nota_Prof_Cod) {
		this.nota_Prof_Cod = nota_Prof_Cod;
	}

	public String getNota_Admin_Cod() {
		return Nota_Admin_Cod;
	}

	public void setNota_Admin_Cod(String nota_Admin_Cod) {
		Nota_Admin_Cod = nota_Admin_Cod;
	}

	public String getNota_Trim1() {
		return nota_Trim1;
	}

	public void setNota_Trim1(String nota_Trim1) {
		this.nota_Trim1 = nota_Trim1;
	}

	public String getNota_Trim2() {
		return nota_Trim2;
	}

	public void setNota_Trim2(String nota_Trim2) {
		this.nota_Trim2 = nota_Trim2;
	}

	public String getNota_Trim3() {
		return nota_Trim3;
	}

	public void setNota_Trim3(String nota_Trim3) {
		this.nota_Trim3 = nota_Trim3;
	}

	public String getNota_Calif() {
		return nota_Calif;
	}

	public void setNota_Calif(String nota_Calif) {
		this.nota_Calif = nota_Calif;
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
