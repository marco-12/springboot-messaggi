package it.dstech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.repository.MessaggioRepository;
import it.dstech.repository.UtenteRepository;
import javassist.expr.NewArray;
import it.dstech.model.Messaggio;
import it.dstech.model.Utente;

@Service
public class UtenteServiceDAOImpl implements UtenteServiceDAO {
	

	@Autowired
	private UtenteRepository utenteRepos;
	
	@Autowired
	private MessaggioRepository messageRepos;

	@Override
	public boolean add(Utente t) {
		if (utenteRepos.existsById(t.getId())) {
			Utente sovrascriviUtente = t;
			
			utenteRepos.save(sovrascriviUtente);
		}
		
		Utente save = utenteRepos.save(t);
		return save != null;
	}

	@Override
	public List<Utente> findAll() {
	return utenteRepos.findAll();
	}
	
	@Override
	public List<String> findNickname() {
		List<Utente> u = utenteRepos.findAll();
		List<String> listaNickname = new ArrayList<String>();
		for (Utente utente : u) {
			listaNickname.add(utente.getNickname());
			
		}
		return listaNickname;
	}

	@Override
	public void remove(Utente t) {
		utenteRepos.delete(t);
	}

	@Override
	public Utente getUtente(String t) {
		return utenteRepos.findByNickname(t);
	}

	@Override
	public List<Messaggio> findMessaggiRicevuti(String nickname) {
		return messageRepos.findByUtenteR(utenteRepos.findByNickname(nickname));
	}


}
