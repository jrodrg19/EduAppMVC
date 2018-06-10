package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import databaseModel.Alumnos;
import databaseModel.Notas;
import databaseModel.Profesores;

public class Profesor {

	private String prof_Cod;
	private	String prof_Nombre;
	private String prof_Apellidos;
	private	String prof_Edad;
	private	String prof_Telefono;
	private String prof_DNI;
	private String prof_Curso;
	private Connection connection;
	private Session session;


	public Profesor() {

	}

	public Profesor(String cod, String nombre, String apell, String edad, String tlf, String dni, String curso){

		this.setProf_Cod(cod);
		this.setProf_Nombre(nombre);
		this.setProf_Apellidos(apell);
		this.setProf_Edad(edad);
		this.setProf_Telefono(tlf);
		this.setProf_DNI(dni);
		this.setProf_Curso(curso);

	}

	public String getProf_Cod() {
		return prof_Cod;
	}
	public void setProf_Cod(String prof_Cod) {
		this.prof_Cod = prof_Cod;
	}
	public String getProf_Nombre() {
		return prof_Nombre;
	}
	public void setProf_Nombre(String prof_Nombre) {
		this.prof_Nombre = prof_Nombre;
	}
	public String getProf_Apellidos() {
		return prof_Apellidos;
	}
	public void setProf_Apellidos(String prof_Apellidos) {
		this.prof_Apellidos = prof_Apellidos;
	}
	public String getProf_Edad() {
		return prof_Edad;
	}
	public void setProf_Edad(String prof_Edad) {
		this.prof_Edad = prof_Edad;
	}
	public String getProf_Telefono() {
		return prof_Telefono;
	}
	public void setProf_Telefono(String prof_Telefono) {
		this.prof_Telefono = prof_Telefono;
	}
	public String getProf_DNI() {
		return prof_DNI;
	}
	public void setProf_DNI(String prof_DNI) {
		this.prof_DNI = prof_DNI;
	}
	public String getProf_Curso() {
		return prof_Curso;
	}
	public void setProf_Curso(String prof_Curso) {
		this.prof_Curso = prof_Curso;
	}


	public void nuevaNota(Nota nueva){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Notas nuevaBd=new Notas(nueva.getNota_Cod(),nueva.getNota_Alum_Cod(),nueva.getNota_Asig_Cod(),nueva.getNota_Prof_Cod(),
					nueva.getNota_Trim1(),nueva.getNota_Trim2(),nueva.getNota_Trim3(),nueva.getNota_Calif());  
			session.save(nuevaBd); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

	/**
	 * 
	 * @param mod
	 */
	public void modificarNota(Nota mod){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			Notas notaNueva = (Notas)session.get(Notas.class, mod.getNota_Cod()); 

			notaNueva.setNotaAlumCodigo(mod.getNota_Alum_Cod());
			notaNueva.setNotaAsigCodigo(mod.getNota_Asig_Cod());
			notaNueva.setNotaProfCodigo(mod.getNota_Prof_Cod());
			notaNueva.setNotaTrim1(mod.getNota_Trim1());
			notaNueva.setNotaTrim2(mod.getNota_Trim2());
			notaNueva.setNotaTrim3(mod.getNota_Trim3());


			session.update(notaNueva);
			tx.commit();

		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

	/**
	 * 
	 * @param nota_Cod
	 */
	public void eliminarNota(String nota_Cod){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Notas notaDel = (Notas)session.get(Notas.class, nota_Cod); 
			session.delete(notaDel); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}


	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<Profesores> mostrarProfesores(){
		ArrayList<Profesores> profesores =new ArrayList<>();
		session = HibernateConection.getSessionFactoru().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         List profesoresBd = session.createQuery("FROM Profesores").list(); 
	         for (Iterator iterator1 = profesoresBd.iterator(); iterator1.hasNext();){
	           profesores.add((Profesores) iterator1.next()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return profesores;

	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<Alumnos> mostrarAlumnos() {
		// TODO Auto-generated method stub
		ArrayList<Alumnos> alumnos =new ArrayList<>();
		session = HibernateConection.getSessionFactoru().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         List alumnosBD = session.createQuery("FROM Alumnos").list(); 
	         for (Iterator iterator1 = alumnosBD.iterator(); iterator1.hasNext();){
	           alumnos.add((Alumnos) iterator1.next()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return alumnos;

	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<Notas> mostrarNotas() {
		// TODO Auto-generated method stub

		ArrayList<Notas> notas =new ArrayList<>();
		session = HibernateConection.getSessionFactoru().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         List notasBD = session.createQuery("FROM Notas").list(); 
	         for (Iterator iterator1 = notasBD.iterator(); iterator1.hasNext();){
	           notas.add((Notas) iterator1.next()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return notas;

	}





}
