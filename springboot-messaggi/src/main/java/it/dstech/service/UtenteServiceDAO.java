package it.dstech.service;

import java.util.List;

import it.dstech.model.Messaggio;
import it.dstech.model.Utente;

public interface UtenteServiceDAO {

	boolean add(Utente t);

	List<Utente> findAll();
	
	void remove(Utente t);

	Utente getUtente(String t);
	
	List<Messaggio> findMessaggiRicevuti(Messaggio messaggio);
}
