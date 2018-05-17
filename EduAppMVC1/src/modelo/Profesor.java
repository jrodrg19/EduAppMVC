package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Profesor {

	private String prof_Cod;
	private	String prof_Nombre;
	private String prof_Apellidos;
	private	String prof_Edad;
	private	String prof_Telefono;
	private String prof_DNI;
	private String prof_Curso;
	private Connection connection;

	public Profesor() {

	}

	public Profesor(String cod, String nombre, String apell, String edad, String tlf, String dni, String curso){

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
	public String getProf_Edad() {
		return prof_Edad;
	}
	public void setProf_Edad(String prof_Edad) {
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


	public void nuevaNota(Nota nueva){

		String sql = "INSERT INTO NOTAS (Nota_Codigo,Nota_Alum_Codigo,Nota_Asig_Codigo,Nota_Prof_Codigo,Nota_Trim1,Nota_Trim2,Nota_Trim3,Nota_Calif) VALUES (?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nueva.getNota_Cod());
			statement.setString(2, nueva.getNota_Alum_Cod());
			statement.setString(3, nueva.getNota_Asig_Cod());
			statement.setString(4, nueva.getNota_Prof_Cod());
			statement.setString(5, nueva.getNota_Trim1());
			statement.setString(6, nueva.getNota_Trim2());
			statement.setString(7, nueva.getNota_Trim3());
			statement.setString(8, nueva.getNota_Calif());

			int n=statement.executeUpdate();

		}catch (SQLException L) {
			// TODO Auto-generated catch block
			L.printStackTrace();

		}
	}


	public void modificarNota(Nota mod){

		String sql = "UPDATE NOTAS SET  Nota_Alum_Codigo=?, Nota_Asig_Codigo=?, Nota_Prof_Codigo=?, Nota_Trim1=?, Nota_Trim2=?,Nota_Trim3=?,Nota_Calif=? "
				+ "WHERE Nota_Codigo=?";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);



			statement.setString(1, mod.getNota_Alum_Cod());
			statement.setString(2, mod.getNota_Asig_Cod());
			statement.setString(3, mod.getNota_Prof_Cod());
			statement.setString(4, mod.getNota_Trim1());
			statement.setString(5, mod.getNota_Trim2());
			statement.setString(6, mod.getNota_Trim3());
			statement.setString(7, mod.buscarCalificacion());
			statement.setString(8, mod.getNota_Cod());

			statement.executeUpdate();

		} catch (SQLException i) {
			// TODO Auto-generated catch block
			i.printStackTrace();
		}

	}

	public void eliminarNota(String nota_Cod){

		String sql = "DELETE FROM  NOTAS WHERE Nota_Codigo=?";

		try {		

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nota_Cod);

			statement.executeUpdate();

		}catch (SQLException L) {
			// TODO Auto-generated catch block
			L.printStackTrace();
		}			

	}



	public String mostrarProfesor(){

		String sql = "select * FROM PROFESORES";			
		return sql;

	}





}
