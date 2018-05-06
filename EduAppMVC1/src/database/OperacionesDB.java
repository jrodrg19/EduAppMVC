package database;

public interface OperacionesDB {

	public abstract void aniadir();
	
	public abstract void modificar();
	
	public abstract void eliminar();
	
	public abstract Object consultar(String id);
	
}
