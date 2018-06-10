package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AlumnoIG extends JFrame {

	public JPanel contentPane;
	public JTextField codigo_field;
	
	public JButton btnMostrarProfesor;
	public JButton btnMostrarAlumno;
	public JButton btnMostrarAsignatura;
	public JButton btnBuscarCalificacion;
	public JButton btnBuscarDatos;
	public JButton btnMostrarNota;
	private JLabel lblCodigo;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JLabel lblCurso;
	private JPanel panel_1;
	public JPanel panel;
	public JLabel cod;
	public JLabel nom;
	public JLabel ap;
	public JLabel edad;
	public JLabel dni;
	public JLabel tlf;
	public JLabel curso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoIG frame = new AlumnoIG();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlumnoIG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAlumno = new JLabel("ALUMNO");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnMostrarProfesor = new JButton("Mostrar Profesor");
		
		btnMostrarAlumno = new JButton("Mostrar Alumno");
		
		btnMostrarAsignatura = new JButton("Mostrar Asignatura");
		
		btnBuscarCalificacion = new JButton("Buscar calificacion");
		
		codigo_field = new JTextField();
		codigo_field.setColumns(10);
		
		JLabel lblCodigoAlumno = new JLabel("Codigo Alumno");
		
		btnBuscarDatos = new JButton("Buscar Datos");
		
		btnMostrarNota = new JButton("Mostrar Nota");
		
		panel = new JPanel();
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(237)
					.addComponent(lblAlumno)
					.addContainerGap(252, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnMostrarProfesor)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnMostrarAlumno)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnMostrarAsignatura))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnBuscarCalificacion)
										.addComponent(btnBuscarDatos))
									.addGap(18)
									.addComponent(lblCodigoAlumno)
									.addGap(18)
									.addComponent(codigo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
							.addComponent(btnMostrarNota)))
					.addGap(33))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAlumno)
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMostrarProfesor)
						.addComponent(btnMostrarAlumno)
						.addComponent(btnMostrarNota)
						.addComponent(btnMostrarAsignatura))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(btnBuscarCalificacion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscarDatos))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodigoAlumno)
								.addComponent(codigo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(72, 0, 60, 19);
		panel.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(142, 0, 60, 19);
		panel.add(lblApellidos);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(212, 0, 46, 19);
		panel.add(lblEdad);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 0, 60, 19);
		panel.add(lblCodigo);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(330, 0, 71, 19);
		panel.add(lblTelefono);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(269, 1, 51, 17);
		panel.add(lblDni);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(411, 0, 60, 19);
		panel.add(lblCurso);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 21, 471, 19);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		cod = new JLabel("");
		cod.setBounds(0, 0, 61, 19);
		panel_1.add(cod);
		
		nom = new JLabel("");
		nom.setBounds(58, 0, 61, 19);
		panel_1.add(nom);
		
		ap = new JLabel("");
		ap.setBounds(129, 0, 74, 19);
		panel_1.add(ap);
		
		edad = new JLabel("");
		edad.setBounds(201, 0, 53, 19);
		panel_1.add(edad);
		
		dni = new JLabel("");
		dni.setBounds(243, 0, 74, 19);
		panel_1.add(dni);
		
		tlf = new JLabel("");
		tlf.setBounds(315, 0, 74, 19);
		panel_1.add(tlf);
		
		curso = new JLabel("");
		curso.setBounds(399, 0, 74, 19);
		panel_1.add(curso);
		contentPane.setLayout(gl_contentPane);
	}
}
