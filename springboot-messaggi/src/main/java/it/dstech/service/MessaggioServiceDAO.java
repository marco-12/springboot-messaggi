package it.dstech.service;

import java.util.List;

import it.dstech.model.Messaggio;
import it.dstech.model.Utente;



public interface MessaggioServiceDAO {
	
	
	boolean add(Messaggio t);

	List<Messaggio> findAll();
	
	List<Messaggio>findByUtenteROrderByDataDesc(Utente utenteR); 

	void remove(Messaggio t);

	List<Messaggio> findByUtenteIOrderByDataDesc(Utente utente);
	

}
