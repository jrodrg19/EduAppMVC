package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import modelo.*;
import vista.AlumnoIG;

/**
 * 
 * @author Javier
 *
 */
public class ControlAlumno implements ActionListener{

	public AlumnoIG ventanaAlum;

	public ControlAlumno(AlumnoIG controlAl) {

		this.ventanaAlum=controlAl;

		this.ventanaAlum.btnBuscarCalificacion.addActionListener(this);
		this.ventanaAlum.btnBuscarDatos.addActionListener(new BtnBuscarDatos(ventanaAlum));
		this.ventanaAlum.btnMostrarAlumno.addActionListener(new BtnMostrarAlumno(ventanaAlum));
		this.ventanaAlum.btnMostrarAsignatura.addActionListener(new BtnMostrarAsig(ventanaAlum));
		this.ventanaAlum.btnMostrarNota.addActionListener(new BtnMostrarNota(ventanaAlum));
		this.ventanaAlum.btnMostrarProfesor.addActionListener(new BtnMostrarProfesor(ventanaAlum));
		
	}
	
	/**
	 * 
	 * ActionListener para el boton de buscar califición 
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\usuario\\Desktop\\COLEGIO.accdb");
			
			String  Nota_Alum_Codigo = ventanaAlum.codigo_field.getText();
			
			//String sql = "SELECT * FROM NOTAS WHERE Nota_Alum_Codigo = ?";
			Nota nota = new Nota();
			String sql=nota.buscarCalificacion();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			
			 statement.setString(1, Nota_Alum_Codigo);
			
			ResultSet rst =statement.executeQuery( );
			ResultSetMetaData rsMD = rst.getMetaData();
			int numeroColumnas = rsMD.getColumnCount();
			
			DefaultTableModel modelo = new DefaultTableModel();
			ventanaAlum.table.setModel(modelo);
			
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
			}catch (ClassNotFoundException | SQLException L) {
			// TODO Auto-generated catch block
			L.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @author Javier
	 *
	 */
	class BtnBuscarDatos implements ActionListener{

		private AlumnoIG ventanaAl;
		
		public BtnBuscarDatos(AlumnoIG ventanaAlum) {

			this.ventanaAl=ventanaAlum;
		
		}
		
		public void actionPerformed(ActionEvent e) {
			try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\usuario\\Desktop\\COLEGIO.accdb");
			
			String  Nota_Alum_Codigo = ventanaAl.codigo_field.getText();
			
			//String sql = "SELECT * FROM ALUMNOS WHERE Alum_Codigo = ?";
			Alumno alu = new Alumno();
			String sql=alu.buscarDatos();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			
			 statement.setString(1, Nota_Alum_Codigo);
			
			ResultSet rst =statement.executeQuery( );
			ResultSetMetaData rsMD = rst.getMetaData();
			int numeroColumnas = rsMD.getColumnCount();
			
			DefaultTableModel modelo = new DefaultTableModel();
			ventanaAl.table.setModel(modelo);
			
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
			}catch (ClassNotFoundException | SQLException L) {
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
	class BtnMostrarAlumno implements ActionListener{

		private AlumnoIG ventanaAl;

		public BtnMostrarAlumno(AlumnoIG ventanaAlum) {

			this.ventanaAl=ventanaAlum;

		}		
		
		public void actionPerformed(ActionEvent e) {
			try{
				
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\usuario\\Desktop\\COLEGIO.accdb");
				
				Statement stm = connection.createStatement();
				Alumno alu = new Alumno();
				String sql=alu.mostrarAlumnos();
				//String sql = "select * FROM ALUMNOS";
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();
				
				DefaultTableModel modelo = new DefaultTableModel();
				ventanaAl.table.setModel(modelo);
				
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
				}catch (ClassNotFoundException | SQLException L) {
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
	class BtnMostrarAsig implements ActionListener{

		private AlumnoIG ventanaAl;

		public BtnMostrarAsig(AlumnoIG ventanaAlum) {

			this.ventanaAl=ventanaAlum;

		}

		public void actionPerformed(ActionEvent e) {
			
			try{

				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\usuario\\Desktop\\COLEGIO.accdb");

				Statement stm = connection.createStatement();
				//String sql = "select * FROM ASIGNATURAS";
				Asignatura asg = new Asignatura();
				String sql=asg.mostrarAsignatura();
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventanaAl.table.setModel(modelo);

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
			}catch (ClassNotFoundException | SQLException L) {
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
	class BtnMostrarNota implements ActionListener{

		private AlumnoIG ventanaAl;

		public BtnMostrarNota(AlumnoIG ventanaAlum) {

			this.ventanaAl=ventanaAlum;

		}

		public void actionPerformed(ActionEvent e) {

			try{

				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\usuario\\Desktop\\COLEGIO.accdb");

				Statement stm = connection.createStatement();
				Nota nota = new Nota();
				String sql=nota.mostrarNota();
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventanaAl.table.setModel(modelo);

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
			}catch (ClassNotFoundException | SQLException L) {
				// TODO Auto-generated catch block
				L.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @author Javier
	 *
	 *Clase creada para realizar la accion de mostrar un profesor
	 *
	 */
	class BtnMostrarProfesor implements ActionListener{

		public AlumnoIG ventanaAl;

		public BtnMostrarProfesor(AlumnoIG ventanaAlum) {

			this.ventanaAl=ventanaAlum;

		}

		public void actionPerformed(ActionEvent arg0) {
			try{


				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\usuario\\Desktop\\COLEGIO.accdb");

				Statement stm = connection.createStatement();
				Profesor prof = new Profesor();
				String sql=prof.mostrarProfesor();
				ResultSet rst = stm.executeQuery(sql);
				ResultSetMetaData rsMD = rst.getMetaData();
				int numeroColumnas = rsMD.getColumnCount();

				DefaultTableModel modelo = new DefaultTableModel();
				ventanaAl.table.setModel(modelo);

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
			}catch (ClassNotFoundException | SQLException L) {
				// TODO Auto-generated catch block
				L.printStackTrace();
			}
		}

	}

}
