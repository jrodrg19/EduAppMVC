package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import databaseModel.Notas;
import databaseModel.Alumnos;
import databaseModel.Asignaturas;
import databaseModel.Profesores;
import databaseModel.Usuarios;

public class Alumno {

	private String alum_Cod;
	private	String alum_Nombre;
	private String alum_Apellidos;
	private	String alum_Edad;
	private	String alum_Telefono;
	private String alum_DNI;
	private String alum_Curso;	
	private Session session;

	public Alumno(){

	}

	public Alumno(String cod,String nom, String apell, String edad, String tlf, String dni, String curso ) {

		this.setAlum_Cod(cod);
		this.setAlum_Nombre(nom);
		this.setAlum_Apellidos(apell);
		this.setAlum_Edad(edad);
		this.setAlum_Telefono(tlf);
		this.setAlum_DNI(dni);
		this.setAlum_Curso(curso);

	}

	public String getAlum_Cod() {
		return alum_Cod;
	}
	public void setAlum_Cod(String alum_Cod) {
		this.alum_Cod = alum_Cod;
	}

	public String getAlum_Nombre() {
		return alum_Nombre;
	}
	public void setAlum_Nombre(String alum_Nombre) {
		this.alum_Nombre = alum_Nombre;
	}

	public String getAlum_Apellidos() {
		return alum_Apellidos;
	}
	public void setAlum_Apellidos(String alum_Apellidos) {
		this.alum_Apellidos = alum_Apellidos;
	}

	public String getAlum_Edad() {
		return alum_Edad;
	}
	public void setAlum_Edad(String alum_Edad) {
		this.alum_Edad = alum_Edad;
	}

	public String getAlum_Telefono() {
		return alum_Telefono;
	}
	public void setAlum_Telefono(String alum_Telefono) {
		this.alum_Telefono = alum_Telefono;
	}

	public String getAlum_DNI() {
		return alum_DNI;
	}
	public void setAlum_DNI(String alum_DNI) {
		this.alum_DNI = alum_DNI;
	}

	public String getAlum_Curso() {
		return alum_Curso;
	}
	public void setAlum_Curso(String alum_Curso) {
		this.alum_Curso = alum_Curso;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<Asignaturas> mostrarAsignaturas() {

		ArrayList<Asignaturas> asignaturas =new ArrayList<>();
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List asigBD = session.createQuery("FROM Asignaturas").list(); 
			for (Iterator iterator1 = asigBD.iterator(); iterator1.hasNext();){
				asignaturas.add((Asignaturas) iterator1.next()); 
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return asignaturas;

	}

	public Notas buscarCalificacion(String cod_Nota){

		Notas notaAlum=null;
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			notaAlum = (Notas)session.get(Notas.class, cod_Nota); 
			tx.commit();

		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

		return notaAlum;
		
	}
	


}
