package it.dstech.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Messaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String testo;

	@ManyToOne
	private Utente utenteR;

	@ManyToOne
	private Utente utenteI;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime data;

	public Messaggio() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtenteR() {
		return utenteR;
	}

	public void setUtenteR(Utente utenteR) {
		this.utenteR = utenteR;
	}

	public Utente getUtenteI() {
		return utenteI;
	}

	public void setUtenteI(Utente utenteI) {
		this.utenteI = utenteI;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

}
