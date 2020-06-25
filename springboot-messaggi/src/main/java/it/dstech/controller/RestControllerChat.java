package it.dstech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = ("/"), method = RequestMethod.POST)
	public boolean addNewUtente(@RequestBody Utente persona) {
		
		return utenteService.add(persona);
	}
	
	@RequestMapping(value = ("/"), method = RequestMethod.DELETE)
	public boolean removeUtente(@RequestBody Utente persona) {
		utenteService.remove(persona);
		return true;
	}
	
	
	@RequestMapping("/messaggio")
	public List<Messaggio> getAllMessaggi() {
		return messaggioService.findAll();
	}
	
	@RequestMapping(value = ("/messaggio"), method = RequestMethod.POST)
	public boolean addNewMessaggio(@RequestBody Messaggio messaggio) {
		return messaggioService.add(messaggio);
	}
	
	@RequestMapping(value = ("/messaggio"), method = RequestMethod.DELETE)
	public boolean removeMessaggio(@RequestBody Messaggio messaggio) {
		messaggioService.remove(messaggio);
		return true;
	}

//	@RequestMapping (value = ("/gestione_messaggio"))
}
