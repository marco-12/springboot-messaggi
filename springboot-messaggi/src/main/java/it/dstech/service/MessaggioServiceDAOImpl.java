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
	public boolean add(Messaggio t ) {
		
		LocalDateTime data = LocalDateTime.now();
		Utente invio = t.getUtenteI();
		Utente riceve = t.getUtenteR();
		t.setUtenteI(invio);
		t.setUtenteR(riceve);
		t.setData(data);
		invio.getListaMessaggio().add(t);
		riceve.getListaMessaggio().add(t);
		Messaggio save = messaggioRepos.save(t);
		utenteRepos.save(invio);
		utenteRepos.save(riceve);
		
		return save != null;
	}
	
	@Override
	public void remove(Messaggio t) {
		messaggioRepos.delete(t);
	}

	@Override
	public List<Messaggio> findByUtenteROrderByDataDesc(Utente utenteR) {
		return messaggioRepos.findByUtenteROrderByDataDesc(utenteR);
		
	}

	@Override
	public List<Messaggio> findByUtenteIOrderByDataDesc(Utente utenteI) {
		return messaggioRepos.findByUtenteIOrderByDataDesc(utenteI);
	}

	@Override
	public List<Messaggio> listaMessaggiUtente(String nickname) {
		return utenteRepos.findByNickname(nickname).getListaMessaggio();
		
	}

}
