package controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Usuario;
import vista.Login;
import vista.*;

public class ControlLog implements ActionListener{
	
	private Login log;
	
	public ControlLog(Login log) {
		
		this.log=log;
		this.log.btnLogin.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		try {
							
			String Usuario_Cod = log.getUsername_field().getText();
			String Usuario_pass = log.password_field.getText();
			String Usuario_tipo = log.tipe_field.getText();
			
			Usuario us = new Usuario(Usuario_Cod,Usuario_pass,Usuario_tipo);
			
			ResultSet set=us.seleccionarUsuario();
			
			if(set.next())
			{
				JOptionPane.showMessageDialog(null, "Bienvenido a Edduapp"+" "+ Usuario_Cod);
				
				if(log.tipe_field.getText().equals("Administrador")){
					
					EventQueue.invokeLater(new Runnable() {
						
						public void run() {
							try {
								AdministradorIG frame = new AdministradorIG();
								ControlAdmin controlAdmin=new ControlAdmin(frame);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
				}
				
				if(log.tipe_field.getText().equals("Profesor")){
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ProfesorIG frame = new ProfesorIG();
								ControlProfesor controlProfe=new ControlProfesor(frame);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
				}
				
				if(log.tipe_field.getText().equals("Alumno")){
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								AlumnoIG frame = new AlumnoIG();
								ControlAlumno controalAl=new ControlAlumno(frame);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
				}
						
			}
			
			else{
				JOptionPane.showMessageDialog(null, "Acceso Denegado");
			}
			
			
		} catch ( SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}
	
}
