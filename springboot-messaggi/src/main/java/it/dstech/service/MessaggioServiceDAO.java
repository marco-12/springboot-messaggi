package it.dstech.service;

import java.util.List;

import it.dstech.model.Messaggio;
import it.dstech.model.Utente;



public interface MessaggioServiceDAO {
	
	
	
	boolean salvaUtente(Messaggio t);

	
	List<Messaggio>findByUtenteROrderByDataDesc(Utente utenteR); 

	void remove(Messaggio t);

	List<Messaggio> findByUtenteIOrderByDataDesc(Utente utente);

	List<Messaggio> listaMessaggiRicevutiUtente(String nickname);
	
	List<Messaggio> listaMessaggiInviatiUtente(String nickname);
	

}
