package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexionAccess {

	static Connection con ;
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConexionAccess.con = null;
	}

	static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
	static String url = "jdbc:ucanaccess://C:\\Users\\usuario\\Desktop\\COLEGIO.accdb";

	public static Connection obtenerConexion( ){
		
		try{
			if(con == null){
				Class.forName(driver);
				con = DriverManager.getConnection(url);
				JOptionPane.showMessageDialog(null,"Conexion Correcta");
			}

		}catch(Exception ex){
			ex.printStackTrace();
			con = null;
		}
		return con;
	}

	public static Connection cerrarConexion() throws Exception {
		try {

			con.close();
			JOptionPane.showMessageDialog(null,"Cierre correcto de la conexión con la base de datos");
		}
		catch (Exception e){
			throw new Exception("Al cerrar la conexión de la base de datos. " + e.getMessage());
		}
		return con;
	}
}


