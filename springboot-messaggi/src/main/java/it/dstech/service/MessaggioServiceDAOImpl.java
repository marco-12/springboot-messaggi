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
	public boolean salvaUtente(Messaggio t) {
		
		LocalDateTime data = LocalDateTime.now();
		t.setUtenteI(t.getUtenteI());
		t.setUtenteR(t.getUtenteR());
		t.setData(data);
		Messaggio save = messaggioRepos.save(t);
		save.getUtenteI().getListaMessaggiInviati().add(save);
		save.getUtenteR().getListaMessaggiRicevuti().add(save);
		utenteRepos.save(save.getUtenteI());
		utenteRepos.save(save.getUtenteR());
		
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
	public List<Messaggio> listaMessaggiRicevutiUtente(String nickname) {
		return utenteRepos.findByNickname(nickname).getListaMessaggiRicevuti();
		
	}
	
	@Override
	public List<Messaggio> listaMessaggiInviatiUtente(String nickname) {
		return utenteRepos.findByNickname(nickname).getListaMessaggiInviati();
		
	}

	

}
