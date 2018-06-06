package databaseModel;
// Generated 06-jun-2018 11:37:45 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Asignaturas generated by hbm2java
 */
@Entity
@Table(name = "asignaturas", catalog = "colegio")
public class Asignaturas implements java.io.Serializable {

	private String asigCodigo;
	private String asigNombre;
	private String profAsigCod;

	public Asignaturas() {
	}

	public Asignaturas(String asigCodigo, String asigNombre, String profAsigCod) {
		this.asigCodigo = asigCodigo;
		this.asigNombre = asigNombre;
		this.profAsigCod = profAsigCod;
	}

	@Id

	@Column(name = "Asig_Codigo", unique = true, nullable = false, length = 10)
	public String getAsigCodigo() {
		return this.asigCodigo;
	}

	public void setAsigCodigo(String asigCodigo) {
		this.asigCodigo = asigCodigo;
	}

	@Column(name = "Asig_Nombre", nullable = false, length = 10)
	public String getAsigNombre() {
		return this.asigNombre;
	}

	public void setAsigNombre(String asigNombre) {
		this.asigNombre = asigNombre;
	}

	@Column(name = "Prof_Asig_Cod", nullable = false, length = 10)
	public String getProfAsigCod() {
		return this.profAsigCod;
	}

	public void setProfAsigCod(String profAsigCod) {
		this.profAsigCod = profAsigCod;
	}

}
