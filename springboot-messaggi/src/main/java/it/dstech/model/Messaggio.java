package it.dstech.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
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
	
	private String nicknameMittente;

	@ManyToOne(cascade = {CascadeType.ALL})
	private Utente utenteR;


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

	public String getNicknameMittente() {
		return nicknameMittente;
	}

	public void setNicknameMittente(String nicknameMittente) {
		this.nicknameMittente = nicknameMittente;
	}
	
	

}
