package it.dstech.service;

import java.util.List;

import it.dstech.model.Messaggio;


public interface MessaggioServiceDAO {
	
	boolean add(Messaggio t);

	List<Messaggio> findAll();

	void remove(Messaggio t);

}
