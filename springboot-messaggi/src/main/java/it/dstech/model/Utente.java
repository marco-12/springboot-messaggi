package it.dstech.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Utente {

	@Id
	private String nickname;

	private String nome;
	
	private String cognome;

	private int eta;
	
	
	@OneToMany
	private List<Messaggio> listaMessaggiRicevuti;
	
	@OneToMany
	private List<Messaggio> listaMessaggiInviati;
	
	public Utente() {
		
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public List<Messaggio> getListaMessaggiRicevuti() {
		return listaMessaggiRicevuti;
	}

	public void setListaMessaggiRicevuti(List<Messaggio> listaMessaggiRicevuti) {
		this.listaMessaggiRicevuti = listaMessaggiRicevuti;
	}

	public List<Messaggio> getListaMessaggiInviati() {
		return listaMessaggiInviati;
	}

	public void setListaMessaggiInviati(List<Messaggio> listaMessaggiInviati) {
		this.listaMessaggiInviati = listaMessaggiInviati;
	}

	

}
