package it.dstech.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Messaggio;
import it.dstech.model.Utente;
import it.dstech.repository.MessaggioRepository;
import it.dstech.repository.UtenteRepository;

@Service
public class MessaggioServiceDAOImpl implements MessaggioServiceDAO{
	
	@Autowired
	private MessaggioRepository messaggioRepos;
	
	@Autowired
	private UtenteRepository utenteRepos;

	@Override
	public boolean salvaUtente(String nickname, Messaggio t) {
		Utente utenteR = utenteRepos.findByNickname(t.getUtenteR().getNickname());
		LocalDateTime data = LocalDateTime.now();
		t.setUtenteR(utenteR);
		t.setNicknameMittente(nickname);
		t.setData(data);
		Messaggio save = messaggioRepos.save(t);
		
		Utente mittente = utenteRepos.findByNickname(nickname);
		mittente.getListaMessaggiInviati().add(t);
		utenteRepos.save(mittente);
		
		
		return save != null;
	}
	
	
	
	@Override
	public void remove(Messaggio t) {
		messaggioRepos.delete(t);
	}

	@Override
	public List<Messaggio> findByUtenteR(Utente utenteR) {
		
		return messaggioRepos.findByUtenteR(utenteR);
		
	}

	
	@Override
	public List<Messaggio> listaMessaggiInviatiUtente(String nickname) {
		
		return utenteRepos.findByNickname(nickname).getListaMessaggiInviati();
		
		
		
	}

	

}
