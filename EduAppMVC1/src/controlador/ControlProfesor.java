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
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import databaseModel.Alumnos;
import databaseModel.Notas;
import databaseModel.Profesores;
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

			String  Alum_Codigo = ventanaProf.TextCodigoAlum.getText();
			String  Prof_Codigo = ventanaProf.TextCodigoProfesor.getText();

			

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

			ArrayList<Notas> profesores=new ArrayList<>();
			
			Profesor prof = new Profesor();

			profesores=prof.mostrarNotas();

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

			ArrayList<Alumnos> profesores=new ArrayList<>();
			
			Profesor prof = new Profesor();

			profesores=prof.mostrarAlumnos();

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

			ArrayList<Profesores> profesores=new ArrayList<>();
			
			Profesor prof = new Profesor();

			profesores=prof.mostrarProfesores();

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
