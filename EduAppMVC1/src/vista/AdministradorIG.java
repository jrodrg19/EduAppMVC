package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdministradorIG extends JFrame {

	public JPanel JTable1;
	public JTextField nombre_field;
	public JTextField apellido_field;
	public JTextField edad_field;
	public JTextField telef_field;
	public JTextField DNI_field;
	public JTextField Curso_field;
	public JTextField codigo_field;
	public JTextField codigous_field;
	public JTextField contra_field;
	public JTextField tipo_field;
	public JTextField codigoasg_field;
	public JTextField nombreasg_field;
	public JTextField TextCurso;
	public JTextField codigoprofasg_field;
	public JLabel lblCodigo;
	public JButton btnMostrarAlum;
	public JButton btnMostrarProf;
	public JButton btnNuevoProfesor;
	public JButton btnNuevoAlumno;
	public JButton btnNewUser;
	public JButton btnMostrarUsuario;
	public JButton btnDropUser;
	public JButton btnModificarProfesor;
	public JButton btnModificarAlumno;
	public JButton btnModificarUsuario;
	public JButton btnNuevaAsignatura;
	public JButton btnMostrarAsignatura;
	public JButton btnEliminarAsignatura;
	public JButton btnModificarAsignatura;
	public JButton btnGenerarListadoCurso;
	private JPanel panel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	public JPanel panel_1;
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
		
	}

	/**
	 * Create the frame.
	 */
	public AdministradorIG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 552);
		JTable1 = new JPanel();
		JTable1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JTable1);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		JLabel lblEdad = new JLabel("Edad");
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		JLabel lblDni = new JLabel("DNI");
		
		JLabel lblCurso = new JLabel("Curso");
		
		nombre_field = new JTextField();
		nombre_field.setColumns(10);
		
		apellido_field = new JTextField();
		apellido_field.setColumns(10);
		
		edad_field = new JTextField();
		edad_field.setColumns(10);
		
		telef_field = new JTextField();
		telef_field.setColumns(10);
		
		DNI_field = new JTextField();
		DNI_field.setColumns(10);
		
		Curso_field = new JTextField();
		Curso_field.setColumns(10);
		
		btnMostrarAlum = new JButton("Mostrar Alumnos");
		
		btnMostrarProf = new JButton("Mostrar Profesor");
		
		codigo_field = new JTextField();
		codigo_field.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		btnNuevoProfesor = new JButton("Nuevo Profesor");
		
		btnNuevoAlumno = new JButton("Nuevo Alumno");
		
		JLabel lblCodigo_1 = new JLabel("Codigo");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		JLabel lblTipo = new JLabel("Tipo");
		
		codigous_field = new JTextField();
		codigous_field.setColumns(10);
		
		contra_field = new JTextField();
		contra_field.setColumns(10);
		
		tipo_field = new JTextField();
		tipo_field.setColumns(10);
		
		btnNewUser = new JButton("Nuevo Usuario");
		
		btnMostrarUsuario = new JButton("Mostrar Usuario");
		
		btnDropUser = new JButton("Eliminar Usuario");
		
		btnModificarProfesor = new JButton("Modificar Profesor");
		
		JLabel lblAlumnoprofesor = new JLabel("ALUMNO/PROFESOR");
		
		JLabel lblUsuario = new JLabel("USUARIO");
		
		btnModificarAlumno = new JButton("Modificar Alumno");
		
		btnModificarUsuario = new JButton("Modificar Usuario");
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		
		JLabel lblCodigo_2 = new JLabel("Codigo");
		
		JLabel label = new JLabel("");
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		
		JLabel lblAsignatura = new JLabel("ASIGNATURA");
		
		codigoasg_field = new JTextField();
		codigoasg_field.setColumns(10);
		
		nombreasg_field = new JTextField();
		nombreasg_field.setColumns(10);
		
		btnNuevaAsignatura = new JButton("Nueva Asignatura");
		
		btnMostrarAsignatura = new JButton("Mostrar Asignatura");

		btnEliminarAsignatura = new JButton("Eliminar Asignatura");

		btnModificarAsignatura = new JButton("Modificar Asignatura");

		TextCurso = new JTextField();
		TextCurso.setColumns(10);
		
		btnGenerarListadoCurso = new JButton("Generar Listado Curso");

		JLabel lblCurso_1 = new JLabel("Curso");
		
		JLabel lblCodigoProfesor = new JLabel("Codigo profesor");
		
		codigoprofasg_field = new JTextField();
		codigoprofasg_field.setColumns(10);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		label_1 = new JLabel("Nombre");
		label_1.setBounds(72, 0, 60, 19);
		panel.add(label_1);
		
		label_2 = new JLabel("Apellidos");
		label_2.setBounds(142, 0, 60, 19);
		panel.add(label_2);
		
		label_3 = new JLabel("Edad");
		label_3.setBounds(212, 0, 46, 19);
		panel.add(label_3);
		
		label_4 = new JLabel("Codigo");
		label_4.setBounds(10, 0, 60, 19);
		panel.add(label_4);
		
		label_5 = new JLabel("Telefono");
		label_5.setBounds(330, 0, 71, 19);
		panel.add(label_5);
		
		label_6 = new JLabel("Dni");
		label_6.setBounds(269, 1, 51, 17);
		panel.add(label_6);
		
		label_7 = new JLabel("Curso");
		label_7.setBounds(411, 0, 60, 19);
		panel.add(label_7);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 21, 471, 19);
		panel.add(panel_1);
		
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
		
		GroupLayout gl_JTable1 = new GroupLayout(JTable1);
		gl_JTable1.setHorizontalGroup(
			gl_JTable1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JTable1.createSequentialGroup()
					.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JTable1.createSequentialGroup()
							.addGap(43)
							.addComponent(lblAlumnoprofesor))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addGap(365)
							.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_JTable1.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblUsuario)
									.addComponent(lblAdministrador))
								.addComponent(lblContrasea)
								.addComponent(lblCodigo_1)
								.addComponent(lblTipo))))
					.addContainerGap(402, Short.MAX_VALUE))
				.addGroup(gl_JTable1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JTable1.createSequentialGroup()
							.addComponent(lblCodigo)
							.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
							.addComponent(codigo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addComponent(nombre_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addComponent(lblApellido)
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addComponent(apellido_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addComponent(lblEdad)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(edad_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addComponent(lblTelefono)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(telef_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addComponent(lblDni)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(DNI_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addComponent(lblCurso)
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addComponent(Curso_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnGenerarListadoCurso))
					.addGap(18)
					.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JTable1.createSequentialGroup()
							.addComponent(lblCurso_1)
							.addGap(18)
							.addComponent(TextCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addGroup(gl_JTable1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNuevoAlumno, Alignment.LEADING)
								.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
									.addComponent(btnMostrarAlum)
									.addGroup(gl_JTable1.createSequentialGroup()
										.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
											.addComponent(btnModificarAlumno)
											.addComponent(btnNuevoProfesor)
											.addComponent(btnModificarProfesor)
											.addComponent(btnMostrarProf))
										.addGap(145)
										.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_JTable1.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_JTable1.createParallelGroup(Alignment.TRAILING)
													.addComponent(btnNewUser)
													.addComponent(btnMostrarUsuario)
													.addComponent(btnDropUser)
													.addComponent(btnModificarUsuario)))
											.addGroup(gl_JTable1.createSequentialGroup()
												.addGap(17)
												.addGroup(gl_JTable1.createParallelGroup(Alignment.TRAILING)
													.addComponent(contra_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(tipo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(codigous_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))))
							.addGap(57)
							.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_JTable1.createSequentialGroup()
									.addGap(14)
									.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(lblCodigo_2)
										.addComponent(lblNombre_1)
										.addComponent(lblCodigoProfesor, Alignment.TRAILING))
									.addGap(30)
									.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
										.addComponent(codigoprofasg_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(nombreasg_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(codigoasg_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAsignatura)))
								.addGroup(gl_JTable1.createSequentialGroup()
									.addGap(74)
									.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNuevaAsignatura)
										.addComponent(btnMostrarAsignatura)
										.addComponent(btnEliminarAsignatura)
										.addComponent(btnModificarAsignatura))))))
					.addGap(94))
				.addGroup(gl_JTable1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(361, Short.MAX_VALUE))
		);
		gl_JTable1.setVerticalGroup(
			gl_JTable1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JTable1.createSequentialGroup()
					.addComponent(lblAdministrador)
					.addGap(8)
					.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlumnoprofesor)
						.addComponent(lblAsignatura)
						.addComponent(lblUsuario))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(gl_JTable1.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_JTable1.createSequentialGroup()
							.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodigo)
								.addComponent(codigo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNuevoAlumno)
								.addComponent(codigous_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo_1))
							.addGap(18)
							.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMostrarAlum)
								.addComponent(lblNombre)
								.addComponent(lblContrasea)
								.addComponent(contra_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nombre_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
								.addComponent(codigoasg_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre_1)
								.addComponent(nombreasg_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_JTable1.createSequentialGroup()
							.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
								.addComponent(apellido_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModificarAlumno)
								.addComponent(lblApellido)
								.addComponent(tipo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipo)
								.addComponent(lblCodigoProfesor)
								.addComponent(codigoprofasg_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_JTable1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_JTable1.createSequentialGroup()
									.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
										.addComponent(edad_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEdad))
									.addGap(15))
								.addGroup(gl_JTable1.createSequentialGroup()
									.addComponent(btnNewUser)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(btnMostrarUsuario)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
									.addComponent(DNI_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblDni)
									.addComponent(btnMostrarProf))
								.addComponent(btnDropUser)))
						.addGroup(gl_JTable1.createSequentialGroup()
							.addGap(20)
							.addComponent(label)
							.addGap(49)
							.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNuevaAsignatura)
								.addComponent(telef_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNuevoProfesor)
								.addComponent(lblTelefono))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMostrarAsignatura)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JTable1.createSequentialGroup()
							.addGroup(gl_JTable1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
									.addComponent(Curso_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCurso)
									.addComponent(btnModificarProfesor))
								.addComponent(btnEliminarAsignatura))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModificarAsignatura)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_JTable1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnGenerarListadoCurso)
								.addComponent(TextCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurso_1)))
						.addComponent(btnModificarUsuario))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		JTable1.setLayout(gl_JTable1);
	}
}
