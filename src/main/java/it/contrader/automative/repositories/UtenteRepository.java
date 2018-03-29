package it.contrader.automative.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Utente;


@Repository
@Transactional
public interface UtenteRepository extends CrudRepository<Utente, Long> {

	Utente findById(int id);
	
	Utente findByEmail(String email);
	
	Utente findByEmailAndPassword(String email, String password);
	
}
