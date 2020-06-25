package it.dstech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.model.Messaggio;
import it.dstech.model.Utente;


public interface MessaggioRepository extends JpaRepository<Messaggio, Long>{
	
	public List<Messaggio>findByUtenteROrderByDataDesc(Utente utenteR); 
	
	public List<Messaggio>findByUtenteIOrderByDataDesc(Utente utenteI); 
	
	 

}