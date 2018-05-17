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

			String nota_Cod = ventanaProf.codigo_field.getText();

			Profesor prof = new Profesor();
			prof.eliminarNota(nota_Cod);

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


			String nota_Codigo = ventanaProf.codigo_field.getText();
			String nota_Alum_Codigo = ventanaProf.alumno_field.getText();
			String nota_Asig_Codigo = ventanaProf.asignatura_field.getText();
			String nota_Prof_Codigo = ventanaProf.profesor_field.getText();
			String nota_Trim1 = ventanaProf.nota1_field.getText();
			String nota_Trim2 = ventanaProf.nota2_field.getText();
			String nota_Trim3 = ventanaProf.nota3_field.getText();
			String nota_Calif = ventanaProf.nota4_field.getText();

			Nota mod=new Nota(nota_Codigo, nota_Alum_Codigo, nota_Asig_Codigo, nota_Prof_Codigo, "", nota_Trim1, nota_Trim2, nota_Trim3, nota_Calif);

			Profesor prof = new Profesor();
			prof.modificarNota(mod);

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

			String nota_Codigo = ventanaProf.codigo_field.getText();
			String nota_Alum_Codigo = ventanaProf.alumno_field.getText();
			String nota_Asig_Codigo = ventanaProf.asignatura_field.getText();
			String nota_Prof_Codigo = ventanaProf.profesor_field.getText();
			String nota_Trim1 = ventanaProf.nota1_field.getText();
			String nota_Trim2 = ventanaProf.nota2_field.getText();
			String nota_Trim3 = ventanaProf.nota3_field.getText();
			String nota_Calif = ventanaProf.nota4_field.getText();

			Nota nueva=new Nota(nota_Codigo, nota_Alum_Codigo, nota_Asig_Codigo, nota_Prof_Codigo, "", nota_Trim1, nota_Trim2, nota_Trim3, nota_Calif);

			Profesor prof = new Profesor();
			prof.nuevaNota(nueva);			

		}

	}

}
