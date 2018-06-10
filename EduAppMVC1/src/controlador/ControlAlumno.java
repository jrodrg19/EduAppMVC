package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.omg.IOP.CodecFactoryOperations;

import databaseModel.Alumnos;
import databaseModel.Asignaturas;
import databaseModel.Notas;
import databaseModel.Profesores;
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

		Alumno nuevo=new Alumno();

		String  nota_Alum_Codigo = ventanaAlum.codigo_field.getText();
		
		Notas notaAl=nuevo.buscarCalificacion(nota_Alum_Codigo);

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
			
			Alumno nuevo=new Alumno();

			String  nota_Alum_Codigo = ventanaAl.codigo_field.getText();
			
			Notas notaAl=nuevo.buscarCalificacion(nota_Alum_Codigo);

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

			Profesor alumn=new Profesor();

			ArrayList<Alumnos> alumnos=alumn.mostrarAlumnos();

			for(int i=0;i< alumnos.size();i++) {

				ventanaAl.cod.setText(alumnos.get(i).getAlumCodigo());
				ventanaAl.nom.setText(alumnos.get(i).getAlumNombre());
				ventanaAl.ap.setText(alumnos.get(i).getAlumApellidos());
				ventanaAl.edad.setText(alumnos.get(i).getAlumEdad());
				ventanaAl.dni.setText(alumnos.get(i).getAlumDni());
				ventanaAl.tlf.setText(alumnos.get(i).getAlumTelefono());
				ventanaAl.curso.setText(alumnos.get(i).getAlumCurso());

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

			Alumno alumn=new Alumno();

			ArrayList<Asignaturas> asig=alumn.mostrarAsignaturas();

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

			Profesor alumn=new Profesor();

			ArrayList<Notas> notas=alumn.mostrarNotas();
			
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

			Profesor alumn=new Profesor();

			ArrayList<Profesores> notas=alumn.mostrarProfesores();

		}

	}

}
