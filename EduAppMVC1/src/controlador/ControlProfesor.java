package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		}

	}
	
}
