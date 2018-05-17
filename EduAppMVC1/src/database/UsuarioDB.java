package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDB implements OperacionesDB{

	public ResultSet obtenerUsuario(PreparedStatement statement) {
		
		ResultSet user=null;
		
		try {
			user= statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}

	@Override
	public void aniadir(Object nuevo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Object mod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Object drop) {
		// TODO Auto-generated method stub
		
	}

}
