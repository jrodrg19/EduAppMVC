package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionAccess {

	private static String driver = "com.mysql.jdbc.Driver";

	private static String linea_Conectar = "jdbc:mysql://localhost:3306/colegio?useSSL=false";

	private static String usuario = "root";

	private static String passwd = "";

	private static Connection conection = null;

	/**
	 * 
	 * @return
	 */
	public static Connection getCon() {

		try {

			Class.forName(driver);

			conection=DriverManager.getConnection(linea_Conectar,usuario,passwd);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conection;

	}
}


