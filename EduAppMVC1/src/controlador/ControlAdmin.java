package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import modelo.*;
import conexion.ConexionAccess;
import vista.AdministradorIG;

public class ControlAdmin implements ActionListener {

	private AdministradorIG ventanaAdmin;

	public ControlAdmin(AdministradorIG frame) {

		this.ventanaAdmin=frame;

		this.ventanaAdmin.btnEliminarAsignatura.addActionListener(this);
		this.ventanaAdmin.btnDropUser.addActionListener(new BtnDropUser(ventanaAdmin));
		this.ventanaAdmin.btnGenerarListadoCurso.addActionListener(new GeneraListado(ventanaAdmin));
		this.ventanaAdmin.btnModificarAlumno.addActionListener(new ModAlum(ventanaAdmin));
		this.ventanaAdmin.btnModificarAsignatura.addActionListener(new ModAsig(ventanaAdmin));
		this.ventanaAdmin.btnModificarProfesor.addActionListener(new ModProf(ventanaAdmin));
		this.ventanaAdmin.btnModificarUsuario.addActionListener(new ModUser(ventanaAdmin));
		this.ventanaAdmin.btnMostrarAlum.addActionListener(new MostrarAlum(ventanaAdmin));
		this.ventanaAdmin.btnMostrarAsignatura.addActionListener(new MostrarAsig(ventanaAdmin));
		this.ventanaAdmin.btnMostrarProf.addActionListener(new MostrarProf(ventanaAdmin));
		this.ventanaAdmin.btnMostrarUsuario.addActionListener(new MostrarUser(ventanaAdmin));
		this.ventanaAdmin.btnNewUser.addActionListener(new NewUser(ventanaAdmin));
		this.ventanaAdmin.btnNuevoAlumno.addActionListener(new NewAlum(ventanaAdmin));
		this.ventanaAdmin.btnNuevaAsignatura.addActionListener(new NewAsig(ventanaAdmin));
		this.ventanaAdmin.btnNuevoProfesor.addActionListener(new NewProf(ventanaAdmin));

	}

	/**
	 * 
	 * ELIMINAR ASIGNATURA
	 * 
	 */
	public void actionPerformed(ActionEvent e) {

		try{

			Connection connection = ConexionAccess.getCon();

			String Asignatura_Cod = ventanaAdmin.codigoasg_field.getText();


			Administrador adm = new Administrador();
			String sql=adm.eliminarAsignatura();
			//String sql = "DELETE FROM  ASIGNATURAS WHERE Asig_Codigo=?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, Asignatura_Cod);

			int n=statement.executeUpdate();

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
	class BtnDropUser implements ActionListener{

		private AdministradorIG ventAdmin;

		public BtnDropUser(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}
		
		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection = ConexionAccess.getCon();

				String Usuario_Cod = ventAdmin.codigous_field.getText();

				Administrador adm = new Administrador();
				String sql=adm.eliminarUsuario();
				//String sql = "DELETE FROM  USUARIOS WHERE Usuario_Cod=?";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(1, Usuario_Cod);

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
	class GeneraListado implements ActionListener{
		
		private AdministradorIG ventAdmin;

		public GeneraListado(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}

		public void actionPerformed(ActionEvent e) {

			try{
				Connection connection = ConexionAccess.getCon();

				String  Curso = ventAdmin.TextCurso.getText();

				Administrador adm = new Administrador();
				String sql=adm.generarListadoAlumnos();
				//String sql = "SELECT * FROM ALUMNOS WHERE Alum_Curso = ?";
				PreparedStatement statement = connection.prepareStatement(sql);


				statement.setString(1, Curso);

				ResultSet rst =statement.executeQuery( );
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventAdmin.table.setModel(modelo);

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
	class ModAlum implements ActionListener{
		
		private AdministradorIG ventAdmin;

		public ModAlum(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}

		public void actionPerformed(ActionEvent e) {

			try {

				Connection connection = ConexionAccess.getCon();

				String Alum_Codigo = ventAdmin.codigo_field.getText();
				String Alum_Nombre = ventAdmin.nombre_field.getText();
				String Alum_Apellido = ventAdmin.apellido_field.getText();
				String Alum_Edad = ventAdmin.edad_field.getText();
				String Alum_Telef = ventAdmin.telef_field.getText();
				String Alum_DNI = ventAdmin.DNI_field.getText();
				String Alum_Curso = ventAdmin.Curso_field.getText();

				Administrador adm = new Administrador();
				String sql=adm.modificarAlumno();
				/*String sql = "UPDATE ALUMNOS SET  Alum_Nombre=?, Alum_Apellidos=?, Alum_Edad=?, Alum_Telefono=?, Alum_DNI=?,Alum_Curso=? "
		                    + "WHERE Alum_Codigo=?";*/

				PreparedStatement statement = connection.prepareStatement(sql);


				statement.setString(1, Alum_Nombre);
				statement.setString(2, Alum_Apellido);
				statement.setString(3, Alum_Edad);
				statement.setString(4, Alum_Telef);
				statement.setString(5, Alum_DNI);
				statement.setString(6, Alum_Curso);
				statement.setString(7, Alum_Codigo);

				statement.executeUpdate();

			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
		}

	}

	/**
	 * 
	 * @author Javier
	 *
	 */
	class ModAsig implements ActionListener{
		
		private AdministradorIG ventAdmin;

		public ModAsig(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}

		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection = ConexionAccess.getCon();

				String Asig_Cod = ventAdmin.codigoasg_field.getText();
				String Asig_Nombre = ventAdmin.nombreasg_field.getText();
				String Prof_Asig_Cod = ventAdmin.codigoprofasg_field.getText();

				Administrador adm = new Administrador();
				String sql=adm.modificarAsignatura();
				//String sql = "UPDATE ASIGNATURAS SET  Asig_Nombre=?,Prof_Asig_Cod=?" + "WHERE Asig_Codigo=?"; 

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(3, Asig_Cod);
				statement.setString(1, Asig_Nombre);
				statement.setString(2, Prof_Asig_Cod);


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
	class ModProf implements ActionListener{

		private AdministradorIG ventAdmin;

		public ModProf(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}
		
		public void actionPerformed(ActionEvent e) {

			try {

				Connection connection = ConexionAccess.getCon();

				String Prof_Codigo = ventAdmin.codigo_field.getText();
				String Prof_Nombre = ventAdmin.nombre_field.getText();
				String Prof_Apellido = ventAdmin.apellido_field.getText();
				String Prof_Edad = ventAdmin.edad_field.getText();
				String Prof_Telef = ventAdmin.telef_field.getText();
				String Prof_DNI = ventAdmin.DNI_field.getText();
				String Prof_Curso = ventAdmin.Curso_field.getText();

				Administrador adm = new Administrador();
				String sql=adm.modificarProfesor();
				/*String sql = "UPDATE PROFESORES SET  Prof_Nombre=?, Prof_Apellidos=?, Prof_Edad=?, Prof_Telefono=?, Prof_DNI=?,Prof_Curso=? "
		                    + "WHERE Prof_Codigo=?";*/

				PreparedStatement statement = connection.prepareStatement(sql);


				statement.setString(1, Prof_Nombre);
				statement.setString(2, Prof_Apellido);
				statement.setString(3, Prof_Edad);
				statement.setString(4, Prof_Telef);
				statement.setString(5, Prof_DNI);
				statement.setString(6, Prof_Curso);
				statement.setString(7, Prof_Codigo);

				statement.executeUpdate();

			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
		}

	}

	/**
	 * 
	 * @author Javier
	 *
	 */
	class ModUser implements ActionListener{

		private AdministradorIG ventAdmin;

		public ModUser(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}
		
		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection = ConexionAccess.getCon();

				String Usuario_Cod = ventAdmin.codigous_field.getText();
				String Usuario_pass = ventAdmin.contra_field.getText();
				String Usuario_tipo = ventAdmin.tipo_field.getText();

				Administrador adm = new Administrador();
				String sql=adm.modificarUsuario();
				//String sql = "UPDATE USUARIOS SET  Usuario_pass=?, Usuario_tipo=? " + "WHERE Usuario_Cod=?";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(1, Usuario_pass);
				statement.setString(2, Usuario_tipo);
				statement.setString(3, Usuario_Cod);


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
	class MostrarAlum implements ActionListener{
		
		private AdministradorIG ventAdmin;

		public MostrarAlum(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}

		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection = ConexionAccess.getCon();

				Statement stm = connection.createStatement();
				Alumno alu = new Alumno();
				String sql=alu.mostrarAlumnos();
				//String sql = "select * FROM ALUMNOS";
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventAdmin.table.setModel(modelo);

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
			}catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
		}

	}

	/**
	 * 
	 * @author Javier
	 *
	 */
	class MostrarAsig implements ActionListener{
		
		private AdministradorIG ventAdmin;

		public MostrarAsig(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}
		
		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection = ConexionAccess.getCon();


				Statement stm = connection.createStatement();
				Asignatura asg = new Asignatura();
				String sql = asg.mostrarAsignatura();
				//String sql = "select * FROM ASIGNATURAS";
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventAdmin.table.setModel(modelo);

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
	class MostrarProf implements ActionListener{

		private AdministradorIG ventAdmin;

		public MostrarProf(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
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
				ventAdmin.table.setModel(modelo);

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
	class MostrarUser implements ActionListener{

		private AdministradorIG ventAdmin;

		public MostrarUser(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}
		
		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection = ConexionAccess.getCon();

				Statement stm = connection.createStatement();
				Usuario us = new Usuario();
				String sql=us.mostrarUsuario();
				//String sql = "select * FROM USUARIOS";
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventAdmin.table.setModel(modelo);

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
	class NewUser implements ActionListener{
		
		private AdministradorIG ventAdmin;

		public NewUser(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}

		public void actionPerformed(ActionEvent e) {
			try{

				Connection connection = ConexionAccess.getCon();

				String Usuario_Cod = ventAdmin.codigous_field.getText();
				String Usuario_pass = ventAdmin.contra_field.getText();
				String Usuario_tipo = ventAdmin.tipo_field.getText();

				Administrador adm = new Administrador();
				String sql=adm.nuevoUsuario();
				//String sql = "INSERT INTO USUARIOS (Usuario_Cod,Usuario_pass,Usuario_tipo) VALUES (?,?,?)";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(1, Usuario_Cod);
				statement.setString(2, Usuario_pass);
				statement.setString(3, Usuario_tipo);


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
	class NewAlum implements ActionListener{

		private AdministradorIG ventAdmin;

		public NewAlum(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}
		
		public void actionPerformed(ActionEvent e) {

			try{
				
				Connection connection = ConexionAccess.getCon();

				String Alum_Cod = ventAdmin.codigo_field.getText();
				String Alum_Nombre = ventAdmin.nombre_field.getText();
				String Alum_Apellido = ventAdmin.apellido_field.getText();
				String Alum_Edad = ventAdmin.edad_field.getText();
				String Alum_Telef = ventAdmin.telef_field.getText();
				String Alum_DNI = ventAdmin.DNI_field.getText();
				String Alum_Curso = ventAdmin.Curso_field.getText();

				Administrador adm = new Administrador();
				String sql=adm.nuevoAlumno();
				//String sql = "INSERT INTO ALUMNOS (Alum_Codigo,Alum_Nombre,Alum_Apellidos,Alum_Edad,Alum_Telefono,Alum_DNI,Alum_Curso) VALUES (?,?,?,?,?,?,?)";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(1, Alum_Cod);
				statement.setString(2, Alum_Nombre);
				statement.setString(3, Alum_Apellido);
				statement.setString(4, Alum_Edad);
				statement.setString(5, Alum_Telef);
				statement.setString(6, Alum_DNI);
				statement.setString(7, Alum_Curso);

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
	class NewAsig implements ActionListener{
		
		private AdministradorIG ventAdmin;

		public NewAsig(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}

		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection = ConexionAccess.getCon();

				String Asig_Cod = ventAdmin.codigoasg_field.getText();
				String Asig_Nombre = ventAdmin.nombreasg_field.getText();
				String Codigo_Prof = ventAdmin.codigoprofasg_field.getText();

				Administrador adm = new Administrador();
				String sql=adm.nuevaAsignatura();
				//String sql = "INSERT INTO ASIGNATURAS (Asig_Codigo,Asig_Nombre,Prof_Asig_Cod) VALUES (?,?,?)";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(1, Asig_Cod);
				statement.setString(2, Asig_Nombre);
				statement.setString(3, Codigo_Prof);


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
	class NewProf implements ActionListener{

		private AdministradorIG ventAdmin;

		public NewProf(AdministradorIG ventanaAdmin) {

			this.ventAdmin=ventanaAdmin;
		
		}
		
		public void actionPerformed(ActionEvent e) {

			try{

				Connection connection = ConexionAccess.getCon();

				String Prof_Codigo = ventAdmin.codigo_field.getText();
				String Prof_Nombre = ventAdmin.nombre_field.getText();
				String Prof_Apellido = ventAdmin.apellido_field.getText();
				String Prof_Edad = ventAdmin.edad_field.getText();
				String Prof_Telef = ventAdmin.telef_field.getText();
				String Prof_DNI = ventAdmin.DNI_field.getText();
				String Prof_Curso = ventAdmin.Curso_field.getText();

				Administrador adm = new Administrador();
				String sql=adm.nuevoProfesor();
				//String sql = "INSERT INTO PROFESORES (Prof_Codigo,Prof_Nombre,Prof_Apellidos,Prof_Edad,Prof_Telefono,Prof_DNI,Prof_Curso) VALUES (?,?,?,?,?,?,?)";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(1, Prof_Codigo);
				statement.setString(2, Prof_Nombre);
				statement.setString(3, Prof_Apellido);
				statement.setString(4, Prof_Edad);
				statement.setString(5, Prof_Telef);
				statement.setString(6, Prof_DNI);
				statement.setString(7, Prof_Curso);

				int n=statement.executeUpdate();

			}catch (SQLException L) {
				// TODO Auto-generated catch block
				L.printStackTrace();
			}
			
		}

	}

}
