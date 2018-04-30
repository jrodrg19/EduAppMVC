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
	public JTable table;
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
		setBounds(100, 100, 684, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
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
		
		JLabel lblCodigoProfesor = new JLabel("Codigo Profesor");
		
		JButton btnNuevaNota = new JButton("Nueva Nota");
		
		JButton btnModificarNota = new JButton("Modificar Nota");
		
		JButton btnMostrarNota = new JButton("Mostrar Nota");
		
		JButton btnEliminarNota = new JButton("Eliminar Nota");
	
		JButton btnMostrarProfesor = new JButton("Mostrar Profesor");
	
		JButton btnMostrarAlumno = new JButton("Mostrar Alumno");

		JButton btnBuscarNota = new JButton("Buscar Nota");
		
		TextCodigoAlum = new JTextField();
		TextCodigoAlum.setColumns(10);
		
		TextCodigoProfesor = new JTextField();
		TextCodigoProfesor.setColumns(10);
		
		JLabel lblCodigoAlumno_1 = new JLabel("Codigo Alumno");
		
		JLabel lblCodigoProfesor_1 = new JLabel("Codigo Profesor");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(lblNotaTrimestre_2)))
					.addContainerGap(89, Short.MAX_VALUE))
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
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Alumno", "Asignatura", "Profesor", "Trim1", "Trim2", "Trim3", "Final"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
