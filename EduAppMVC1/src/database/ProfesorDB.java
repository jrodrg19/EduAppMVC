package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDB implements OperacionesDB{

	@Override
	public void aniadir(PreparedStatement nuevo) {
		// TODO Auto-generated method stub
		
		try {
			
			nuevo.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modificar(PreparedStatement mod) {
		
		try {
			mod.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(PreparedStatement drop) {
		// TODO Auto-generated method stub
		
	}


	
}
