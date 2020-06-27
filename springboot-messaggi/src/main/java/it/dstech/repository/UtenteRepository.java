package it.dstech.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import it.dstech.model.Utente;


public interface UtenteRepository extends JpaRepository<Utente, String>{
	
	@Query(value = "SELECT u FROM Utente u WHERE u.nickname LIKE '%' || :keyword || '%'")
	public List<Utente> search(@Param("keyword") String keyword);

	public Utente findByNickname(String nickname);

	public boolean existsById(Long id);
	 
}
