package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import conexion.ConexionAccess;
import modelo.*;
import vista.ProfesorIG;

public class ControlProfesor implements ActionListener{

	private ProfesorIG ventanaProf;

	public ControlProfesor(ProfesorIG frameProf) {

		this.ventanaProf=frameProf;

		this.ventanaProf.btnBuscarNota.addActionListener(this);
		this.ventanaProf.btnEliminarNota.addActionListener(new BtnEliminarNota(ventanaProf));
		this.ventanaProf.btnModificarNota.addActionListener(new BtnModNota(ventanaProf));
		this.ventanaProf.btnMostrarNota.addActionListener(new BtnMostrarNota(ventanaProf));
		this.ventanaProf.btnMostrarAlumno.addActionListener(new BtnMostrarAlum(ventanaProf));
		this.ventanaProf.btnMostrarProfesor.addActionListener(new BtnMostrarProf(ventanaProf));
		this.ventanaProf.btnNuevaNota.addActionListener(new BtnNuevaNota(ventanaProf));
		
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {

		try{
			
			Connection connection=ConexionAccess.getCon();

			String  Alum_Codigo = ventanaProf.TextCodigoAlum.getText();
			String  Prof_Codigo = ventanaProf.TextCodigoProfesor.getText();

			Nota nota = new Nota();
			String sql=nota.buscarNota();

			//String sql = "SELECT * FROM NOTAS WHERE Nota_Alum_Codigo = ? AND Nota_Prof_Codigo = ?  ";
			PreparedStatement statement = connection.prepareStatement(sql);


			statement.setString(1, Alum_Codigo);
			statement.setString(2, Prof_Codigo);

			ResultSet rst =statement.executeQuery( );
			ResultSetMetaData rsMD = rst.getMetaData();
			int numeroColumnas = rsMD.getColumnCount();

			DefaultTableModel modelo = new DefaultTableModel();
			ventanaProf.table.setModel(modelo);

			for ( int x=1 ; x<= numeroColumnas ; x++){
				modelo.addColumn(rsMD.getColumnLabel(x));

			}

			while (rst.next()){
				Object [] fila = new Object [numeroColumnas];

				for (int i = 0 ; i < numeroColumnas ; i++){
					fila[i]=rst.getObject(i+1);

				}

				modelo.addRow(fila);

			}
		}catch (SQLException L) {
			// TODO Auto-generated catch block
			L.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @author Javier
	 *
	 */
	class BtnEliminarNota implements ActionListener{

		private ProfesorIG ventProf;

		public BtnEliminarNota(ProfesorIG ventanaProf) {

			this.ventProf=ventanaProf;

		}

		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection=ConexionAccess.getCon();

				String Nota_Cod = ventanaProf.codigo_field.getText();

				//String sql = "DELETE FROM  NOTAS WHERE Nota_Codigo=?";
				Profesor prof = new Profesor();
				String sql=prof.eliminarNota();

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(1, Nota_Cod);

				int n=statement.executeUpdate();

			}catch (SQLException L) {
				// TODO Auto-generated catch block
				L.printStackTrace();
			}			
			
		}

	}

	/**
	 * 
	 * @author Javier
	 *
	 */
	class BtnModNota implements ActionListener{

		private ProfesorIG ventProf;

		public BtnModNota(ProfesorIG ventanaProf) {

			this.ventProf=ventanaProf;

		}

		public void actionPerformed(ActionEvent e) {

			try {
			    
				Connection connection = ConexionAccess.getCon();
		        
				String Nota_Codigo = ventanaProf.codigo_field.getText();
				String Nota_Alum_Codigo = ventanaProf.alumno_field.getText();
				String Nota_Asig_Codigo = ventanaProf.asignatura_field.getText();
				String Nota_Prof_Codigo = ventanaProf.profesor_field.getText();
				String Nota_Trim1 = ventanaProf.nota1_field.getText();
				String Nota_Trim2 = ventanaProf.nota2_field.getText();
				String Nota_Trim3 = ventanaProf.nota3_field.getText();
				String Nota_Calif = ventanaProf.nota4_field.getText();
				
				Profesor prof = new Profesor();
				String sql=prof.modificarNota();
		        /*String sql = "UPDATE NOTAS SET  Nota_Alum_Codigo=?, Nota_Asig_Codigo=?, Nota_Prof_Codigo=?, Nota_Trim1=?, Nota_Trim2=?,Nota_Trim3=?,Nota_Calif=? "
		                    + "WHERE Nota_Codigo=?";*/
		        
		        PreparedStatement statement = connection.prepareStatement(sql);
		        
				
				
				statement.setString(1, Nota_Alum_Codigo);
				statement.setString(2, Nota_Asig_Codigo);
				statement.setString(3, Nota_Prof_Codigo);
				statement.setString(4, Nota_Trim1);
				statement.setString(5, Nota_Trim2);
				statement.setString(6, Nota_Trim3);
				statement.setString(7, Nota_Calif);
				statement.setString(8, Nota_Codigo);
				
		        statement.executeUpdate();
		       
			} catch (SQLException i) {
				// TODO Auto-generated catch block
				i.printStackTrace();
			}
			
		}

	}
	
	/**
	 * 
	 * @author Javier
	 *
	 */
	class BtnMostrarNota implements ActionListener{

		private ProfesorIG ventProf;

		public BtnMostrarNota(ProfesorIG ventanaProf) {

			this.ventProf=ventanaProf;

		}

		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection= ConexionAccess.getCon();

				Statement stm = connection.createStatement();
				Nota nota = new Nota();
				String sql=nota.mostrarNota();
				//String sql = "select * FROM NOTAS";
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventanaProf.table.setModel(modelo);

				for ( int x=1 ; x<= numeroColumnas ; x++){
					modelo.addColumn(rsMD.getColumnLabel(x));

				}

				while (rst.next()){
					Object [] fila = new Object [numeroColumnas];

					for (int i = 0 ; i < numeroColumnas ; i++){
						fila[i]=rst.getObject(i+1);

					}

					modelo.addRow(fila);

				}
			}catch (SQLException L) {
				// TODO Auto-generated catch block
				L.printStackTrace();
			}

			
		}

	}

	/**
	 * 
	 * @author Javier
	 *
	 */
	class BtnMostrarAlum implements ActionListener{

		private ProfesorIG ventProf;

		public BtnMostrarAlum(ProfesorIG ventanaProf) {

			this.ventProf=ventanaProf;

		}

		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection=ConexionAccess.getCon();

				Statement stm = connection.createStatement();
				Alumno alum = new Alumno();
				String sql=alum.mostrarAlumnos();
				//String sql = "select * FROM ALUMNOS";
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventanaProf.table.setModel(modelo);

				for ( int x=1 ; x<= numeroColumnas ; x++){
					modelo.addColumn(rsMD.getColumnLabel(x));

				}

				while (rst.next()){
					Object [] fila = new Object [numeroColumnas];

					for (int i = 0 ; i < numeroColumnas ; i++){
						fila[i]=rst.getObject(i+1);

					}

					modelo.addRow(fila);

				}
			}catch (SQLException l) {
				// TODO Auto-generated catch block
				l.printStackTrace();
			}
			
		}

	}
	
	/**
	 * 
	 * @author Javier
	 *
	 */
	class BtnMostrarProf implements ActionListener{

		private ProfesorIG ventProf;

		public BtnMostrarProf(ProfesorIG ventanaProf) {

			this.ventProf=ventanaProf;

		}

		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection = ConexionAccess.getCon();
				
				Statement stm = connection.createStatement();
				Profesor prof = new Profesor();
				String sql=prof.mostrarProfesor();
				//String sql = "select * FROM PROFESORES";
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventanaProf.table.setModel(modelo);

				for ( int x=1 ; x<= numeroColumnas ; x++){
					modelo.addColumn(rsMD.getColumnLabel(x));

				}

				while (rst.next()){
					Object [] fila = new Object [numeroColumnas];

					for (int i = 0 ; i < numeroColumnas ; i++){
						fila[i]=rst.getObject(i+1);

					}

					modelo.addRow(fila);

				}
			}catch (SQLException L) {
				// TODO Auto-generated catch block
				L.printStackTrace();
			}
			
		}

	}
	
	/**
	 * 
	 * @author Javier
	 *
	 */
	class BtnNuevaNota implements ActionListener{

		private ProfesorIG ventProf;

		public BtnNuevaNota(ProfesorIG ventanaProf) {

			this.ventProf=ventanaProf;

		}

		public void actionPerformed(ActionEvent e) {

			try{
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\usuario\\Desktop\\COLEGIO.accdb");
				
				String Nota_Codigo = ventanaProf.codigo_field.getText();
				String Nota_Alum_Codigo = ventanaProf.alumno_field.getText();
				String Nota_Asig_Codigo = ventanaProf.asignatura_field.getText();
				String Nota_Prof_Codigo = ventanaProf.profesor_field.getText();
				String Nota_Trim1 = ventanaProf.nota1_field.getText();
				String Nota_Trim2 = ventanaProf.nota2_field.getText();
				String Nota_Trim3 = ventanaProf.nota3_field.getText();
				String Nota_Calif = ventanaProf.nota4_field.getText();
				
				//String sql = "INSERT INTO NOTAS (Nota_Codigo,Nota_Alum_Codigo,Nota_Asig_Codigo,Nota_Prof_Codigo,Nota_Trim1,Nota_Trim2,Nota_Trim3,Nota_Calif) VALUES (?,?,?,?,?,?,?,?)";
				Profesor prof = new Profesor();
				String sql=prof.nuevaNota();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, Nota_Codigo);
				statement.setString(2, Nota_Alum_Codigo);
				statement.setString(3, Nota_Asig_Codigo);
				statement.setString(4, Nota_Prof_Codigo);
				statement.setString(5, Nota_Trim1);
				statement.setString(6, Nota_Trim2);
				statement.setString(7, Nota_Trim3);
				statement.setString(8, Nota_Calif);
				
				int n=statement.executeUpdate();
				
				}catch (ClassNotFoundException | SQLException L) {
				// TODO Auto-generated catch block
				L.printStackTrace();
			}
			
		}

	}
	
}
