package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionAccess;
import database.UsuarioDB;

public class Usuario {

	private String Usuario_Cod;
	private String Usuario_pass;
	private String Usuario_tipo;
	private Connection connection;
	
	public Usuario(){
	}  

	public Usuario(String cod,String pass,String tipo){
		
		connection = ConexionAccess.getCon();
		
		this.setUsuario_Cod(cod);
		this.setUsuario_pass(pass);
		this.setUsuario_tipo(tipo);
		
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

	public ResultSet seleccionarUsuario(){

		UsuarioDB usuarioDB=new UsuarioDB();
		
		String sql = "select * from USUARIOS where (Usuario_Cod = ? and Usuario_pass = ? and Usuario_tipo = ?); ";
		
		PreparedStatement statement=null;;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, Usuario_Cod);
			statement.setString(2, Usuario_pass);
			statement.setString(3, Usuario_tipo);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet set=usuarioDB.obtenerUsuario(statement);
		
		return set;

	}

	public String mostrarUsuario(){

		String sql = "select * FROM USUARIOS";			
		return sql;

	}


}
