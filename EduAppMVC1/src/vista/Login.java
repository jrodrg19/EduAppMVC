package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField username_field;
	public JTextField password_field;
	public JTextField tipe_field;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setUsername_field(new JTextField());
		getUsername_field().setBounds(163, 78, 176, 33);
		contentPane.add(getUsername_field());
		getUsername_field().setColumns(10);
		
		password_field = new JTextField();
		password_field.setBounds(163, 122, 176, 33);
		contentPane.add(password_field);
		password_field.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(39, 84, 91, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasea.setBounds(28, 128, 102, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblEduapp = new JLabel("EDUAPP");
		lblEduapp.setFont(new Font("Wide Latin", Font.PLAIN, 26));
		lblEduapp.setBounds(87, 11, 234, 44);
		contentPane.add(lblEduapp);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario");
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeUsuario.setBounds(10, 172, 131, 23);
		contentPane.add(lblTipoDeUsuario);
		
		tipe_field = new JTextField();
		tipe_field.setColumns(10);
		tipe_field.setBounds(163, 170, 176, 33);
		contentPane.add(tipe_field); 
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.setBounds(202, 214, 89, 23);
		contentPane.add(btnLogin);
		
		
	}

	public JTextField getUsername_field() {
		return username_field;
	}

	public void setUsername_field(JTextField username_field) {
		this.username_field = username_field;
	}
}
