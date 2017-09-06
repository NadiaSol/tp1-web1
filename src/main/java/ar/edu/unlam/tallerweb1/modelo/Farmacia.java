package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Farmacia {
	
	@Id @GeneratedValue
	private Long idFarmacia;
	private String nombre;
	private String telefono;
	private String diadeturno;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "idDireccion")
	private Direccion direccion;
	
	@OneToOne
	private Punto punto;

	public Long getIdFarmacia() {
		return idFarmacia;
	}

	public void setIdFarmacia(Long idFarmacia) {
		this.idFarmacia = idFarmacia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDiadeturno() {
		return diadeturno;
	}

	public void setDiadeturno(String diadeturno) {
		this.diadeturno = diadeturno;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	
	

}
