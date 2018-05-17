package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDB implements OperacionesDB{

	@Override
	public void aniadir(PreparedStatement nuevo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(PreparedStatement mod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(PreparedStatement drop) {
		// TODO Auto-generated method stub
		
	}

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

}
