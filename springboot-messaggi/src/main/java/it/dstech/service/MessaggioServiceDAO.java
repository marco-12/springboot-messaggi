package it.dstech.service;

import java.util.List;

import it.dstech.model.Messaggio;
import it.dstech.model.Utente;



public interface MessaggioServiceDAO {
	
	
	
	boolean salvaUtente(String nickname, Messaggio t);

	
	List<Messaggio>findByUtenteR(Utente utenteR); 

	void remove(Messaggio t);


	List<Messaggio> listaMessaggiInviatiUtente(String nickname);
	

}
