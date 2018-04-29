package modelo;

public class Usuario {

	private String Usuario_Cod;
	private String Usuario_pass;
	private String Usuario_tipo;
	
	public Usuario(){
   }  
	
	public Usuario(String pass,String tipo){
         pass = null;
        tipo=null;
    }
	
	public String getUsuario_Cod() {
		return Usuario_Cod;
	}
	public void setUsuario_Cod(String usuario_Cod) {
		Usuario_Cod = usuario_Cod;
	}
	public String getUsuario_pass() {
		return Usuario_pass;
	}
	public void setUsuario_pass(String usuario_pass) {
		Usuario_pass = usuario_pass;
	}
	public String getUsuario_tipo() {
		return Usuario_tipo;
	}
	public void setUsuario_tipo(String usuario_tipo) {
		Usuario_tipo = usuario_tipo;
	}
	
	public String seleccionarUsuarios(){
		
		String sql = "select * from USUARIOS where (Usuario_Cod = ? and Usuario_pass = ? and Usuario_tipo = ?); ";
		return sql;
		
	}
	
	public String mostrarUsuario(){
		
		String sql = "select * FROM USUARIOS";			
		return sql;
		
	}
	
	
}
