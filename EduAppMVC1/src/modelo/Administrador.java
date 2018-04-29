package modelo;

public class Administrador {
	
	private String Admin_Cod;
	private	String Admin_Nombre;
	private String Admin_Apellidos;
	private	int Admin_Edad;
	private	int Admin_Telefono;
	private String Admin_DNI;
	
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
	public int getAdmin_Edad() {
		return Admin_Edad;
	}
	public void setAdmin_Edad(int admin_Edad) {
		Admin_Edad = admin_Edad;
	}
	public int getAdmin_Telefono() {
		return Admin_Telefono;
	}
	public void setAdmin_Telefono(int admin_Telefono) {
		Admin_Telefono = admin_Telefono;
	}
	public String getAdmin_DNI() {
		return Admin_DNI;
	}
	public void setAdmin_DNI(String admin_DNI) {
		Admin_DNI = admin_DNI;
	} 
	
	
	public String nuevoProfesor(){
		
	String sql = "INSERT INTO PROFESORES (Prof_Codigo,Prof_Nombre,Prof_Apellidos,Prof_Edad,Prof_Telefono,Prof_DNI,Prof_Curso) VALUES (?,?,?,?,?,?,?)";
		return sql;
	}
	
	public String nuevoAlumno(){
		
		String sql = "INSERT INTO ALUMNOS (Alum_Codigo,Alum_Nombre,Alum_Apellidos,Alum_Edad,Alum_Telefono,Alum_DNI,Alum_Curso) VALUES (?,?,?,?,?,?,?)";
		return sql;
		
		}
	
	public String nuevoUsuario(){
		
		String sql = "INSERT INTO USUARIOS (Usuario_Cod,Usuario_pass,Usuario_tipo) VALUES (?,?,?)";
		return sql;
		
		}
	
	public String modificarAlumno(){
		
		String sql = "UPDATE ALUMNOS SET  Alum_Nombre=?, Alum_Apellidos=?, Alum_Edad=?, Alum_Telefono=?, Alum_DNI=?,Alum_Curso=? "
                + "WHERE Alum_Codigo=?";;
			return sql;
		}
	
	public String modificarProfesor(){
		
		String sql = "UPDATE PROFESORES SET  Prof_Nombre=?, Prof_Apellidos=?, Prof_Edad=?, Prof_Telefono=?, Prof_DNI=?,Prof_Curso=? "
                + "WHERE Prof_Codigo=?";
        return sql;
		}
	
	public String eliminarUsuario(){
		
	String sql = "DELETE FROM  USUARIOS WHERE Usuario_Cod=?";		
	return sql;
		
		}
	
	public String modificarUsuario(){
		
		String sql = "UPDATE USUARIOS SET  Usuario_pass=?, Usuario_tipo=? " + "WHERE Usuario_Cod=?";
		return sql;
	}
	
	public String nuevaAsignatura() {
		String sql = "INSERT INTO ASIGNATURAS (Asig_Codigo,Asig_Nombre,Prof_Asig_Cod) VALUES (?,?,?)";
		return sql;
	}
	
	public String eliminarAsignatura() {
		String sql = "DELETE FROM  ASIGNATURAS WHERE Asig_Codigo=?";
		return sql;
	}
	
	public String modificarAsignatura() {
		String sql = "UPDATE ASIGNATURAS SET  Asig_Nombre=?,Prof_Asig_Cod=?" + "WHERE Asig_Codigo=?"; 
		return sql;
	}

	public String generarListadoAlumnos(){
		
		String sql = "SELECT * FROM ALUMNOS WHERE Alum_Curso = ?";
		return sql;
	}
	
}
