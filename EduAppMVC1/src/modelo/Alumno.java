package modelo;

public class Alumno {
	
		private String Alum_Cod;
		private	String Alum_Nombre;
		private String Alum_Apellidos;
		private	int Alum_Edad;
		private	int Alum_Telefono;
		private String Alum_DNI;
		private String Alum_Curso;
		
		public String getAlum_Cod() {
			return Alum_Cod;
		}
		public void setAlum_Cod(String alum_Cod) {
			Alum_Cod = alum_Cod;
		}
		
		public String getAlum_Nombre() {
			return Alum_Nombre;
		}
		public void setAlum_Nombre(String alum_Nombre) {
			Alum_Nombre = alum_Nombre;
		}
		
		public String getAlum_Apellidos() {
			return Alum_Apellidos;
		}
		public void setAlum_Apellidos(String alum_Apellidos) {
			Alum_Apellidos = alum_Apellidos;
		}
		
		public int getAlum_Edad() {
			return Alum_Edad;
		}
		public void setAlum_Edad(int alum_Edad) {
			Alum_Edad = alum_Edad;
		}
		
		public int getAlum_Telefono() {
			return Alum_Telefono;
		}
		public void setAlum_Telefono(int alum_Telefono) {
			Alum_Telefono = alum_Telefono;
		}
		
		public String getAlum_DNI() {
			return Alum_DNI;
		}
		public void setAlum_DNI(String alum_DNI) {
			Alum_DNI = alum_DNI;
		}
		
		public String getAlum_Curso() {
			return Alum_Curso;
		}
		public void setAlum_Curso(String alum_Curso) {
			Alum_Curso = alum_Curso;
		}
		
		public String mostrarAlumnos(){
			
			String sql = "select * FROM ALUMNOS";			
			return sql;
			
		}
		
		
		public String buscarDatos(){
			
			String sql = "SELECT * FROM ALUMNOS WHERE Alum_Codigo = ?";			
			return sql;
			
		}
		
		
		
		
		
}
