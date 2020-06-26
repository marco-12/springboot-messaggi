package it.dstech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

	@RequestMapping(value = "/utenti", method = RequestMethod.GET)
	@ApiOperation(value = "Recupera tutti gli utenti dal sistema", notes = "Con questa chiamata riceveremo tutti gli utenti registrati al sistema")
	public List<Utente> getAllUtente() {
		return utenteService.findAll();
	}
	
	// CREARE METODO PER STAMPARE SOLO I NICKNAME
	
	@RequestMapping(value = ("/aggiungi_utente"), method = RequestMethod.POST)
	@ApiOperation(value = "Aggiunge un utente dal sistema", notes = "Con questa chiamata inseriremo un utente nel sistema")
	public boolean addNewUtente(@ApiParam(value = "Oggetto utente per aggiungerlo al sistema", name = "utente") @RequestBody Utente persona) {
		
		return utenteService.add(persona);
	}
	
	@RequestMapping(value = ("/rimuovi_utente"), method = RequestMethod.DELETE)
	@ApiOperation(value = "Rimuove un utente dal sistema", notes = "Con questa chiamata rimuoviamo un utente nel sistema")
	public boolean removeUtente(@ApiParam(value = "Oggetto utente per rimuoverlo al sistema", name = "utente") @RequestBody Utente persona) {
		utenteService.remove(persona);
		return true;
	}
	
	
	@RequestMapping(value = "/lista_messaggi_ricevuti_utente", method = RequestMethod.POST)
	@ApiOperation(value = "Restituisce la lista dei messaggi ricevuti", notes = "Con questa chiamata riceveremo la lista dei messaggi ricevuti dall'utente nel sistema")
	public List<Messaggio> getMessaggiRiceuti(@ApiParam(value = "Oggetto utente per ricevere la sua lista di messaggi ricevuti", name = "utente") @RequestBody Utente utente) {
		return messaggioService.listaMessaggiRicevutiUtente(utente.getNickname());
	} 
	
	@RequestMapping(value = "/lista_messaggi_inviati_utente", method = RequestMethod.POST)
	@ApiOperation(value = "Restituisce la lista dei messaggi inviati", notes = "Con questa chiamata riceveremo la lista dei messaggi inviati dall'utente nel sistema")
	public List<Messaggio> getMessaggiInviati(@ApiParam(value = "Oggetto utente per ricevere la sua lista di messaggi inviati", name = "utente")@RequestBody Utente utente) {
		return messaggioService.listaMessaggiInviatiUtente(utente.getNickname());
	} 
	
	@RequestMapping(value = ("/invia_messaggio"), method = RequestMethod.POST)
	@ApiOperation(value = "Invia Messaggio", notes = "Questo metodo permette ad un utente di inviare un messaggio di testo")
	public boolean addNewMessaggio(@ApiParam(value = "Oggetto messaggio inviarlo al sistema", name = "messaggio") @RequestBody Messaggio messaggio) {
		messaggioService.salvaUtente(messaggio);
		return true;
	}
	
	
	
	@RequestMapping(value = ("/rimuovi_messaggio"), method = RequestMethod.DELETE)
	@ApiOperation(value = "Rimuove un messaggio dal sistema", notes = "Con questa chiamata rimuoviamo un messaggio nel sistema")
	public boolean removeMessaggio(@ApiParam(value = "Oggetto messaggio per rimuoverlo al sistema", name = "messaggio") @RequestBody Messaggio messaggio) {
		messaggioService.remove(messaggio);
		return true;
	}

//	@RequestMapping (value = ("/lista_messaggio_utente_ricevuti"), method = RequestMethod.GET)
//	public List<Messaggio>  vediMessaggiUtenteRicevuti(@RequestBody Utente utente) {
//		
//		return messaggioService.findByUtenteROrderByDataDesc(utenteService.getUtente(utente.getNickname()));
//	
//	} 
//	
//	@RequestMapping (value = ("/lista_messaggio_utente_inviati"), method = RequestMethod.GET)
//	public List<Messaggio> vediMessaggiUtenteInviati(@RequestBody Utente utente) {
//		
//		return messaggioService.findByUtenteIOrderByDataDesc(utenteService.getUtente(utente.getNickname()));
//	} 
	
}
