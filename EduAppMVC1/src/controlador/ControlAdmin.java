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

		String asignatura_Cod = ventanaAdmin.codigoasg_field.getText();

		Administrador adm = new Administrador();

		adm.eliminarAsignatura(asignatura_Cod);

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

			String usuario_Cod = ventAdmin.codigous_field.getText();

			Administrador adm = new Administrador();
			adm.eliminarUsuario(usuario_Cod);

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

			String Alum_Codigo = ventAdmin.codigo_field.getText();
			String Alum_Nombre = ventAdmin.nombre_field.getText();
			String Alum_Apellido = ventAdmin.apellido_field.getText();
			String Alum_Edad = ventAdmin.edad_field.getText();
			String Alum_Telef = ventAdmin.telef_field.getText();
			String Alum_DNI = ventAdmin.DNI_field.getText();
			String Alum_Curso = ventAdmin.Curso_field.getText();

			Alumno modificado=new Alumno(Alum_Codigo, Alum_Nombre, Alum_Apellido, Alum_Edad, Alum_Telef, Alum_DNI, Alum_Curso);

			Administrador adm = new Administrador();
			adm.modificarAlumno(modificado);

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

			String Asig_Cod = ventAdmin.codigoasg_field.getText();
			String Asig_Nombre = ventAdmin.nombreasg_field.getText();
			String Prof_Asig_Cod = ventAdmin.codigoprofasg_field.getText();

			Asignatura mod=new Asignatura(Asig_Cod, Asig_Nombre, Prof_Asig_Cod);

			Administrador adm = new Administrador();
			adm.modificarAsignatura(mod);

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

			String Prof_Codigo = ventAdmin.codigo_field.getText();
			String Prof_Nombre = ventAdmin.nombre_field.getText();
			String Prof_Apellido = ventAdmin.apellido_field.getText();
			String Prof_Edad = ventAdmin.edad_field.getText();
			String Prof_Telef = ventAdmin.telef_field.getText();
			String Prof_DNI = ventAdmin.DNI_field.getText();
			String Prof_Curso = ventAdmin.Curso_field.getText();

			Profesor mod=new Profesor(Prof_Codigo, Prof_Nombre, Prof_Apellido, Prof_Edad, Prof_Telef, Prof_DNI, Prof_Curso);

			Administrador adm =new Administrador();
			adm.modificarProfesor(mod);


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

			String usuario_Cod = ventAdmin.codigous_field.getText();
			String usuario_pass = ventAdmin.contra_field.getText();
			String usuario_tipo = ventAdmin.tipo_field.getText();

			Usuario user=new Usuario(usuario_Cod, usuario_pass, usuario_tipo);

			Administrador adm = new Administrador();
			adm.modificarUsuario(user);

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

			String usuario_Cod = ventAdmin.codigous_field.getText();
			String usuario_pass = ventAdmin.contra_field.getText();
			String usuario_tipo = ventAdmin.tipo_field.getText();

			Usuario nuevo=new Usuario(usuario_Cod, usuario_pass, usuario_tipo);

			Administrador adm = new Administrador();
			adm.nuevoUsuario(nuevo);

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

			String Alum_Cod = ventAdmin.codigo_field.getText();
			String Alum_Nombre = ventAdmin.nombre_field.getText();
			String Alum_Apellido = ventAdmin.apellido_field.getText();
			String Alum_Edad = ventAdmin.edad_field.getText();
			String Alum_Telef = ventAdmin.telef_field.getText();
			String Alum_DNI = ventAdmin.DNI_field.getText();
			String Alum_Curso = ventAdmin.Curso_field.getText();

			Alumno nuevo=new Alumno(Alum_Cod, Alum_Nombre, Alum_Apellido, Alum_Edad, Alum_Telef, Alum_DNI, Alum_Curso);

			Administrador adm = new Administrador();
			adm.nuevoAlumno(nuevo);
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

			String asig_Cod = ventAdmin.codigoasg_field.getText();
			String asig_Nombre = ventAdmin.nombreasg_field.getText();
			String codigo_Prof = ventAdmin.codigoprofasg_field.getText();

			Asignatura nueva=new Asignatura(asig_Cod,asig_Nombre,codigo_Prof);

			Administrador adm = new Administrador();
			adm.nuevaAsignatura(nueva);

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

			Administrador adm = new Administrador();

			String Prof_Codigo = ventAdmin.codigo_field.getText();
			String Prof_Nombre = ventAdmin.nombre_field.getText();
			String Prof_Apellido = ventAdmin.apellido_field.getText();
			String Prof_Edad = ventAdmin.edad_field.getText();
			String Prof_Telef = ventAdmin.telef_field.getText();
			String Prof_DNI = ventAdmin.DNI_field.getText();
			String Prof_Curso = ventAdmin.Curso_field.getText();

			Profesor nuevo=new Profesor(Prof_Codigo, Prof_Nombre, Prof_Apellido, Prof_Edad, Prof_Telef, Prof_DNI, Prof_Curso);
			adm.nuevoProfesor(nuevo);

		}

	}

}
