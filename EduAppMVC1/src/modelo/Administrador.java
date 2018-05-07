package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.ConexionAccess;
import database.AlumnoDB;
import database.AsignaturaDB;
import database.ProfesorDB;
import database.UsuarioDB;

public class Administrador {

	private String Admin_Cod;
	private	String Admin_Nombre;
	private String Admin_Apellidos;
	private	String Admin_Edad;
	private	String Admin_Telefono;
	private String Admin_DNI;
	private Connection connection;

	public Administrador() {

	}

	public Administrador(String cod, String nom, String app, String edad, String tlf, String dni) {

		connection=ConexionAccess.getCon();
		this.setAdmin_Apellidos(app);
		this.setAdmin_Cod(cod);
		this.setAdmin_DNI(dni);
		this.setAdmin_Edad(edad);
		this.setAdmin_Nombre(nom);
		this.setAdmin_Telefono(tlf);

	}

	public String getAdmin_Cod() {
		return Admin_Cod;
	}
	public void setAdmin_Cod(String admin_Cod) {
		Admin_Cod = admin_Cod;
	}
	public String getAdmin_Nombre() {
		return Admin_Nombre;
	}
	public void setAdmin_Nombre(String admin_Nombre) {
		Admin_Nombre = admin_Nombre;
	}
	public String getAdmin_Apellidos() {
		return Admin_Apellidos;
	}
	public void setAdmin_Apellidos(String admin_Apellidos) {
		Admin_Apellidos = admin_Apellidos;
	}
	public String getAdmin_Edad() {
		return Admin_Edad;
	}
	public void setAdmin_Edad(String admin_Edad) {
		Admin_Edad = admin_Edad;
	}
	public String getAdmin_Telefono() {
		return Admin_Telefono;
	}
	public void setAdmin_Telefono(String admin_Telefono) {
		Admin_Telefono = admin_Telefono;
	}
	public String getAdmin_DNI() {
		return Admin_DNI;
	}
	public void setAdmin_DNI(String admin_DNI) {
		Admin_DNI = admin_DNI;
	} 


	public void nuevoProfesor(Profesor nuevo){

		String sql = "INSERT INTO PROFESORES (Prof_Codigo,Prof_Nombre,Prof_Apellidos,Prof_Edad,Prof_Telefono,Prof_DNI,Prof_Curso) VALUES (?,?,?,?,?,?,?)";

		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(sql);

			statement.setString(1, nuevo.getProf_Cod());
			statement.setString(2, nuevo.getProf_Nombre());
			statement.setString(3, nuevo.getProf_Apellidos());
			statement.setString(4, nuevo.getProf_Edad());
			statement.setString(5, nuevo.getProf_Telefono());
			statement.setString(6, nuevo.getProf_DNI());
			statement.setString(7, nuevo.getProf_Curso());

			ProfesorDB profdb=new ProfesorDB();
			profdb.aniadir(statement);

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void nuevoAlumno(Alumno nuevo){

		String sql = "INSERT INTO ALUMNOS (Alum_Codigo,Alum_Nombre,Alum_Apellidos,Alum_Edad,Alum_Telefono,Alum_DNI,Alum_Curso) VALUES (?,?,?,?,?,?,?)";

		PreparedStatement statement;

		try {

			statement = connection.prepareStatement(sql);

			statement.setString(1, nuevo.getAlum_Cod());
			statement.setString(2, nuevo.getAlum_Nombre());
			statement.setString(3, nuevo.getAlum_Apellidos());
			statement.setString(4, nuevo.getAlum_Edad());
			statement.setString(5, nuevo.getAlum_Telefono());
			statement.setString(6, nuevo.getAlum_DNI());
			statement.setString(7, nuevo.getAlum_Curso());

			AlumnoDB alumDB=new AlumnoDB();
			alumDB.aniadir(statement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void nuevoUsuario(Usuario user){

		String sql = "INSERT INTO USUARIOS (Usuario_Cod,Usuario_pass,Usuario_tipo) VALUES (?,?,?)";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, user.getUsuario_Cod());
			statement.setString(2, user.getUsuario_pass());
			statement.setString(3, user.getUsuario_tipo());

			UsuarioDB userDB=new UsuarioDB();
			userDB.modificar(statement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modificarAlumno(Alumno modificado){

		String sql = "UPDATE ALUMNOS SET  Alum_Nombre=?, Alum_Apellidos=?, Alum_Edad=?, Alum_Telefono=?, Alum_DNI=?,Alum_Curso=? "
				+ "WHERE Alum_Codigo=?";

		try{

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, modificado.getAlum_Nombre());
			statement.setString(2, modificado.getAlum_Apellidos());
			statement.setString(3, modificado.getAlum_Edad());
			statement.setString(4, modificado.getAlum_Telefono());
			statement.setString(5, modificado.getAlum_DNI());
			statement.setString(6, modificado.getAlum_Curso());
			statement.setString(7, modificado.getAlum_Cod());

			AlumnoDB alumDB=new AlumnoDB();
			alumDB.modificar(statement);
		
		}catch (SQLException L) {
			// TODO Auto-generated catch block
			L.printStackTrace();
		}

	}

	public void modificarProfesor(Profesor mod){

		String sql = "UPDATE PROFESORES SET  Prof_Nombre=?, Prof_Apellidos=?, Prof_Edad=?, Prof_Telefono=?, Prof_DNI=?,Prof_Curso=? "
				+ "WHERE Prof_Codigo=?";

		PreparedStatement statement;
		try {

			statement = connection.prepareStatement(sql);

			statement.setString(1, mod.getProf_Cod());
			statement.setString(2, mod.getProf_Nombre());
			statement.setString(3, mod.getProf_Apellidos());
			statement.setString(4, mod.getProf_Edad());
			statement.setString(5, mod.getProf_Telefono());
			statement.setString(6, mod.getProf_DNI());
			statement.setString(7, mod.getProf_Curso());

			ProfesorDB modDB=new ProfesorDB();
			modDB.modificar(statement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void eliminarUsuario(String usuario_Cod){

		String sql = "DELETE FROM  USUARIOS WHERE Usuario_Cod=?";		

		PreparedStatement statement;
		try {

			statement = connection.prepareStatement(sql);

			statement.setString(1, usuario_Cod);

			UsuarioDB userDB=new UsuarioDB();

			userDB.eliminar(statement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modificarUsuario(Usuario user){

		String sql = "UPDATE USUARIOS SET  Usuario_pass=?, Usuario_tipo=? " + "WHERE Usuario_Cod=?";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, user.getUsuario_pass());
			statement.setString(2, user.getUsuario_tipo());
			statement.setString(3, user.getUsuario_Cod());

			UsuarioDB userDB=new UsuarioDB();
			userDB.modificar(statement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void nuevaAsignatura(Asignatura asig) {

		String sql = "INSERT INTO ASIGNATURAS (Asig_Codigo,Asig_Nombre,Prof_Asig_Cod) VALUES (?,?,?)";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, asig.getAsig_Cod());
			statement.setString(2, asig.getAsig_Nombre());
			statement.setString(3, asig.getProf_Asig_Cod());

			AsignaturaDB asigDB=new AsignaturaDB();

			asigDB.aniadir(statement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void eliminarAsignatura(String asignatura_Cod) {
		String sql = "DELETE FROM  ASIGNATURAS WHERE Asig_Codigo=?";

		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);

			statement.setString(1, asignatura_Cod);

			AsignaturaDB asigDB=new AsignaturaDB();
			asigDB.eliminar(statement);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modificarAsignatura(Asignatura mod) {
		String sql = "UPDATE ASIGNATURAS SET  Asig_Nombre=?,Prof_Asig_Cod=?" + "WHERE Asig_Codigo=?"; 

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(3, mod.getAsig_Cod());
			statement.setString(1, mod.getAsig_Nombre());
			statement.setString(2, mod.getProf_Asig_Cod());

			AsignaturaDB asigBD=new AsignaturaDB();
			asigBD.modificar(statement);

		}catch (SQLException L) {
			// TODO Auto-generated catch block
			L.printStackTrace();
		}

	}

	public String generarListadoAlumnos(){

		String sql = "SELECT * FROM ALUMNOS WHERE Alum_Curso = ?";
		return sql;
	}

}
