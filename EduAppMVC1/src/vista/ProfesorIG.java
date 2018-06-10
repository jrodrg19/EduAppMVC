package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
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

public class ProfesorIG extends JFrame {

	public JPanel contentPane;
	public JTextField codigo_field;
	public JTextField alumno_field;
	public JTextField asignatura_field;
	public JTextField nota1_field;
	public JTextField nota2_field;
	public JTextField nota3_field;
	public JTextField nota4_field;
	public JTextField profesor_field;
	public JTextField TextCodigoAlum;
	public JTextField TextCodigoProfesor;
	public JLabel lblCodigoProfesor;
	public JButton btnNuevaNota;
	public JButton btnModificarNota;
	public JButton btnMostrarNota;
	public JButton btnEliminarNota ;
	public JButton btnMostrarProfesor;
	public JButton btnMostrarAlumno;
	public JButton btnBuscarNota;
	private JPanel panel;
	private JLabel lblAlumno;
	private JLabel lblAsignatura;
	private JLabel lblProfesor_1;
	private JLabel label_3;
	private JLabel lblTrim_1;
	private JLabel lblTrim;
	private JLabel lblTrim_2;
	private JPanel panel_1;
	private JLabel cod;
	private JLabel alum;
	private JLabel asig;
	private JLabel prof;
	private JLabel trim1;
	private JLabel trim2;
	private JLabel trim3;
	private JLabel lblFinal;
	private JLabel notaFin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public ProfesorIG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblProfesor = new JLabel("PROFESOR");
		
		JLabel lblNotas = new JLabel("NOTAS");
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		codigo_field = new JTextField();
		codigo_field.setColumns(10);
		
		alumno_field = new JTextField();
		alumno_field.setColumns(10);
		
		JLabel lblCodigoAlumno = new JLabel("Codigo Alumno");
		
		JLabel lblCodigoAsignatura = new JLabel("Codigo Asignatura");
		
		asignatura_field = new JTextField();
		asignatura_field.setColumns(10);
		
		nota1_field = new JTextField();
		nota1_field.setColumns(10);
		
		JLabel lblNotaTrimestre = new JLabel("Nota Trimestre 1");
		
		JLabel lblNotaTrimestre_1 = new JLabel("Nota Trimestre 2");
		
		nota2_field = new JTextField();
		nota2_field.setColumns(10);
		
		JLabel lblNotaTrimestre_2 = new JLabel("Nota Trimestre 3");
		
		nota3_field = new JTextField();
		nota3_field.setColumns(10);
		
		nota4_field = new JTextField();
		nota4_field.setColumns(10);
		
		JLabel lblNotaFinal = new JLabel("Nota Final");
		
		profesor_field = new JTextField();
		profesor_field.setColumns(10);
		
		lblCodigoProfesor = new JLabel("Codigo Profesor");
		
		btnNuevaNota = new JButton("Nueva Nota");
		
		btnModificarNota = new JButton("Modificar Nota");
		
		btnMostrarNota = new JButton("Mostrar Nota");
		
		btnEliminarNota = new JButton("Eliminar Nota");
	
		btnMostrarProfesor = new JButton("Mostrar Profesor");
	
		btnMostrarAlumno = new JButton("Mostrar Alumno");

		btnBuscarNota = new JButton("Buscar Nota");
		
		TextCodigoAlum = new JTextField();
		TextCodigoAlum.setColumns(10);
		
		TextCodigoProfesor = new JTextField();
		TextCodigoProfesor.setColumns(10);
		
		JLabel lblCodigoAlumno_1 = new JLabel("Codigo Alumno");
		
		JLabel lblCodigoProfesor_1 = new JLabel("Codigo Profesor");
		
		panel = new JPanel();
		panel.setLayout(null);
		
		lblAlumno = new JLabel("Alumno");
		lblAlumno.setBounds(72, 0, 60, 19);
		panel.add(lblAlumno);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(142, 0, 60, 19);
		panel.add(lblAsignatura);
		
		lblProfesor_1 = new JLabel("Profesor");
		lblProfesor_1.setBounds(212, 0, 46, 19);
		panel.add(lblProfesor_1);
		
		label_3 = new JLabel("Codigo");
		label_3.setBounds(10, 0, 60, 19);
		panel.add(label_3);
		
		lblTrim_1 = new JLabel("Trim2");
		lblTrim_1.setBounds(330, 0, 71, 19);
		panel.add(lblTrim_1);
		
		lblTrim = new JLabel("Trim1");
		lblTrim.setBounds(269, 1, 51, 17);
		panel.add(lblTrim);
		
		lblTrim_2 = new JLabel("Trim3");
		lblTrim_2.setBounds(411, 0, 60, 19);
		panel.add(lblTrim_2);
		
		lblFinal = new JLabel("Final");
		lblFinal.setBounds(481, 2, 60, 19);
		panel.add(lblFinal);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 21, 544, 19);
		panel.add(panel_1);
		
		cod = new JLabel("");
		cod.setBounds(0, 0, 61, 19);
		panel_1.add(cod);
		
		alum = new JLabel("");
		alum.setBounds(58, 0, 61, 19);
		panel_1.add(alum);
		
		asig = new JLabel("");
		asig.setBounds(129, 0, 74, 19);
		panel_1.add(asig);
		
		prof = new JLabel("");
		prof.setBounds(201, 0, 53, 19);
		panel_1.add(prof);
		
		trim1 = new JLabel("");
		trim1.setBounds(243, 0, 74, 19);
		panel_1.add(trim1);
		
		trim2 = new JLabel("");
		trim2.setBounds(315, 0, 74, 19);
		panel_1.add(trim2);
		
		trim3 = new JLabel("");
		trim3.setBounds(399, 0, 74, 19);
		panel_1.add(trim3);
		
		notaFin = new JLabel("");
		notaFin.setBounds(463, 0, 74, 19);
		panel_1.add(notaFin);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(65)
									.addComponent(lblNotas))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNotaFinal)
										.addComponent(lblNotaTrimestre_1)
										.addComponent(lblNotaTrimestre)
										.addComponent(lblCodigoAsignatura)
										.addComponent(lblCodigoAlumno)
										.addComponent(lblCodigo)
										.addComponent(lblCodigoProfesor))
									.addGap(37)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(nota4_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(nota1_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(profesor_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(asignatura_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(alumno_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(codigo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(nota2_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(nota3_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProfesor)
								.addComponent(btnMostrarNota)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNuevaNota)
										.addComponent(btnModificarNota))
									.addGap(64)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnMostrarAlumno)
										.addComponent(btnMostrarProfesor)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnBuscarNota)
										.addComponent(btnEliminarNota))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCodigoAlumno_1)
										.addComponent(lblCodigoProfesor_1))
									.addGap(14)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(TextCodigoProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(TextCodigoAlum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNotaTrimestre_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNotas)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodigo)
								.addComponent(codigo_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNuevaNota)
								.addComponent(btnMostrarProfesor))
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodigoAlumno)
								.addComponent(alumno_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModificarNota)
								.addComponent(btnMostrarAlumno))
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodigoAsignatura)
								.addComponent(asignatura_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMostrarNota))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodigoProfesor)
								.addComponent(profesor_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminarNota))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNotaTrimestre)
								.addComponent(nota1_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblProfesor))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNotaTrimestre_1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(nota2_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscarNota)
							.addComponent(TextCodigoAlum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCodigoAlumno_1)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(lblNotaTrimestre_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nota3_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TextCodigoProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigoProfesor_1))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNotaFinal))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(nota4_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
