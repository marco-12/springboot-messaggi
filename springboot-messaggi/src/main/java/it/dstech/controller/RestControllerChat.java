package it.dstech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.model.Messaggio;
import it.dstech.model.Utente;
import it.dstech.service.MessaggioServiceDAO;
import it.dstech.service.UtenteServiceDAO;

@RestController 
public class RestControllerChat {
	
	@Autowired
	private UtenteServiceDAO utenteService;
	
	@Autowired
	private MessaggioServiceDAO messaggioService;

	@RequestMapping("/")
	public List<Utente> getAllUtente() {
		return utenteService.findAll();
	}
	
	@RequestMapping(value = ("/aggiungi_utente"), method = RequestMethod.POST)
	public boolean addNewUtente(@RequestBody Utente persona) {
		
		return utenteService.add(persona);
	}
	
	@RequestMapping(value = ("/rimuovi_utente"), method = RequestMethod.DELETE)
	public boolean removeUtente(@RequestBody Utente persona) {
		utenteService.remove(persona);
		return true;
	}
	
	
	@RequestMapping(value = "/lista_messaggi_utente", method = RequestMethod.POST)
	public List<Messaggio> getAllMessaggi(@RequestBody Utente utente) {
		return messaggioService.listaMessaggiUtente(utente.getNickname());
	} 
	
	@RequestMapping(value = ("/invia_messaggio"), method = RequestMethod.POST)
	public boolean addNewMessaggio(@RequestBody Messaggio messaggio) {
		return messaggioService.add(messaggio);
	}
	
	@RequestMapping(value = ("/rimuovi_messaggio"), method = RequestMethod.DELETE)
	public boolean removeMessaggio(@RequestBody Messaggio messaggio) {
		messaggioService.remove(messaggio);
		return true;
	}

	@RequestMapping (value = ("/lista_messaggo_utente_ricevuti"), method = RequestMethod.GET)
	public List<Messaggio>  vediMessaggiUtenteRicevuti(@RequestBody Utente utente) {
		
		return messaggioService.findByUtenteROrderByDataDesc(utenteService.getUtente(utente.getNickname()));
	
	} 
	
	@RequestMapping (value = ("/lista_messaggo_utente_inviati"), method = RequestMethod.GET)
	public List<Messaggio> vediMessaggiUtenteInviati(@RequestBody Utente utente) {
		
		return messaggioService.findByUtenteIOrderByDataDesc(utenteService.getUtente(utente.getNickname()));
	} 
	
}
