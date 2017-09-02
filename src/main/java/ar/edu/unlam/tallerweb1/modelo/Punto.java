package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Punto {
	
	@Id
	private Long idPunto;
	private String latitud;
	private String longitud;
	

	public Long getIdPunto() {
		return idPunto;
	}

	public void setIdPunto(Long idPunto) {
		this.idPunto = idPunto;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	
	
}
