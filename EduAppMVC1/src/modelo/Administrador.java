package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import databaseModel.Notas;
import databaseModel.Profesores;
import databaseModel.Usuarios;
import databaseModel.Alumnos;
import databaseModel.Asignaturas;


public class Administrador {

	private String Admin_Cod;
	private	String Admin_Nombre;
	private String Admin_Apellidos;
	private	String Admin_Edad;
	private	String Admin_Telefono;
	private String Admin_DNI;
	private Connection connection;
	private Session session;

	public Administrador() {

	}

	public Administrador(String cod, String nom, String app, String edad, String tlf, String dni) {

		this.setAdmin_Apellidos(app);
		this.setAdmin_Cod(cod);
		this.setAdmin_DNI(dni);
		this.setAdmin_Edad(edad);
		this.setAdmin_Nombre(nom);
		this.setAdmin_Telefono(tlf);

	}

	public String getAdmin_Cod() {
		return Admin_Cod;
	}
	public void setAdmin_Cod(String admin_Cod) {
		Admin_Cod = admin_Cod;
	}
	public String getAdmin_Nombre() {
		return Admin_Nombre;
	}
	public void setAdmin_Nombre(String admin_Nombre) {
		Admin_Nombre = admin_Nombre;
	}
	public String getAdmin_Apellidos() {
		return Admin_Apellidos;
	}
	public void setAdmin_Apellidos(String admin_Apellidos) {
		Admin_Apellidos = admin_Apellidos;
	}
	public String getAdmin_Edad() {
		return Admin_Edad;
	}
	public void setAdmin_Edad(String admin_Edad) {
		Admin_Edad = admin_Edad;
	}
	public String getAdmin_Telefono() {
		return Admin_Telefono;
	}
	public void setAdmin_Telefono(String admin_Telefono) {
		Admin_Telefono = admin_Telefono;
	}
	public String getAdmin_DNI() {
		return Admin_DNI;
	}
	public void setAdmin_DNI(String admin_DNI) {
		Admin_DNI = admin_DNI;
	} 


	public void nuevoProfesor(Profesor nuevo){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Profesores nuevoBd=new Profesores(nuevo.getProf_Cod(),nuevo.getProf_Nombre(),nuevo.getProf_Apellidos(),
											  nuevo.getProf_Edad(),nuevo.getProf_Telefono(),
											  nuevo.getProf_DNI(), nuevo.getProf_Curso());  
			session.save(nuevoBd); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

	public void nuevoAlumno(Alumno nuevo){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Alumnos nuevaBd=new Alumnos(nuevo.getAlum_Cod(),nuevo.getAlum_Nombre(),nuevo.getAlum_Apellidos(),
							          nuevo.getAlum_Edad(),nuevo.getAlum_Telefono(),nuevo.getAlum_DNI(),
							          nuevo.getAlum_Curso());  
			session.save(nuevaBd); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

	public void nuevoUsuario(Usuario user){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Usuarios nuevaBd=new Usuarios(user.getUsuario_Cod(),user.getUsuario_pass(),user.getUsuario_tipo());  
			session.save(nuevaBd); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

	public void modificarAlumno(Alumno mod){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			Alumnos alumMod = (Alumnos)session.get(Alumnos.class, mod.getAlum_Cod()); 
			
			alumMod.setAlumCodigo(mod.getAlum_Cod());
			alumMod.setAlumNombre(mod.getAlum_Nombre());
			alumMod.setAlumApellidos(mod.getAlum_Apellidos());
			alumMod.setAlumEdad(mod.getAlum_Edad());
			alumMod.setAlumTelefono(mod.getAlum_Telefono());
			alumMod.setAlumDni(mod.getAlum_DNI());
			alumMod.setAlumCurso(mod.getAlum_Curso());
			
			session.update(alumMod);
			tx.commit();

		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

	public void modificarProfesor(Profesor mod){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			Profesores profMod = (Profesores)session.get(Profesores.class, mod.getProf_Cod()); 

			profMod.setProfCodigo(mod.getProf_Cod());
			profMod.setProfNombre(mod.getProf_Nombre());
			profMod.setProfApellidos(mod.getProf_Apellidos());
			profMod.setProfEdad(mod.getProf_Edad());
			profMod.setProfTelefono(mod.getProf_Telefono());
			profMod.setProfDni(mod.getProf_DNI());
			profMod.setProfCurso(mod.getProf_Curso());

			session.update(profMod);
			tx.commit();

		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	

	}

	public void eliminarUsuario(String usuario_Cod){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Usuarios userDel = (Usuarios)session.get(Usuarios.class, usuario_Cod); 
			session.delete(userDel); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
	}

	public void modificarUsuario(Usuario user){

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			Usuarios userMod = (Usuarios)session.get(Usuarios.class, user.getUsuario_Cod()); 

			userMod.setUsuarioCod(user.getUsuario_Cod());
			userMod.setUsuarioPass(user.getUsuario_pass());
			userMod.setUsuarioTipo(user.getUsuario_tipo());

			session.update(userMod);
			tx.commit();

		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

	public void nuevaAsignatura(Asignatura asig) {

		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Asignaturas nuevaBd=new Asignaturas(asig.getAsig_Cod(),asig.getAsig_Nombre(),asig.getProf_Asig_Cod());  
			session.save(nuevaBd); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

	public void eliminarAsignatura(String asignatura_Cod) {
		
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Asignaturas asigDel = (Asignaturas)session.get(Asignaturas.class, asignatura_Cod); 
			session.delete(asigDel); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
	}

	public void modificarAsignatura(Asignatura mod) {
		
		session = HibernateConection.getSessionFactoru().openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			Asignaturas asiNueva = (Asignaturas)session.get(Asignaturas.class, mod.getAsig_Cod()); 

			asiNueva.setAsigCodigo(mod.getAsig_Cod());
			asiNueva.setAsigNombre(mod.getAsig_Nombre());
			asiNueva.setProfAsigCod(mod.getProf_Asig_Cod());

			session.update(asiNueva);
			tx.commit();

		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}

	public ArrayList<Alumnos> generarListadoAlumnos(String curso){

		ArrayList<Alumnos> alumnos =new ArrayList<>();
		session = HibernateConection.getSessionFactoru().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         List alumnosBD = session.createQuery("FROM Alumnos WHERE curso = "+curso).list(); 
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

	public ArrayList<Usuarios> mostrarUsers() {

		ArrayList<Usuarios> usuarios =new ArrayList<>();
		session = HibernateConection.getSessionFactoru().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         List userBD = session.createQuery("FROM Usuarios").list(); 
	         for (Iterator iterator1 = userBD.iterator(); iterator1.hasNext();){
	           usuarios.add((Usuarios) iterator1.next()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return usuarios;
		
	}

}
