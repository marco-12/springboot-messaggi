package it.dstech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Messaggio;
import it.dstech.repository.MessaggioRepository;

@Service
public class MessaggioServiceDAOImpl implements MessaggioServiceDAO{
	
	@Autowired
	private MessaggioRepository messaggioRepos;

	@Override
	public boolean add(Messaggio t) {
		Messaggio save = messaggioRepos.save(t);
		return save != null;
	}

	@Override
	public List<Messaggio> findAll() {
		return messaggioRepos.findAll();
	}

	@Override
	public void remove(Messaggio t) {
		messaggioRepos.delete(t);
	}

}