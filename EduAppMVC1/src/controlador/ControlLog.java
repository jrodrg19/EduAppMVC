package controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.ConexionAccess;
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
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\usuario\\Desktop\\COLEGIO.accdb");
			
			
			String Usuario_Cod = log.getUsername_field().getText();
			String Usuario_pass = log.password_field.getText();
			String Usuario_tipo = log.tipe_field.getText();
			
			Usuario us = new Usuario();
			String sql=us.seleccionarUsuarios();
			//String sql = "select * from USUARIOS where (Usuario_Cod = ? and Usuario_pass = ? and Usuario_tipo = ?); ";
			PreparedStatement statement = connection.prepareStatement(sql);
		

			statement.setString(1, Usuario_Cod);
			statement.setString(2, Usuario_pass);
			statement.setString(3, Usuario_tipo);
			
			ResultSet set =statement.executeQuery();
			
			if(set.next())
			{
				JOptionPane.showMessageDialog(null, "Bienvenido a Edduapp"+" "+ Usuario_Cod);
				
				if(log.tipe_field.getText().equals("Administrador")){
					
					EventQueue.invokeLater(new Runnable() {
						
						public void run() {
							try {
								AdministradorIG frame = new AdministradorIG();
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
			
			
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}
	
}
