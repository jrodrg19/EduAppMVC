package database;

public interface OperacionesDB {

	public abstract void aniadir(java.sql.PreparedStatement nuevo);
	
	public abstract void modificar(java.sql.PreparedStatement mod);
	
	public abstract void eliminar(java.sql.PreparedStatement drop);
		
}
