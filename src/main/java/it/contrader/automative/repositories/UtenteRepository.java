package it.contrader.automative.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Utente;


@Repository
@Transactional
public interface UtenteRepository extends CrudRepository<Utente, Long> {

	Utente findById(int id);
	
	List<Utente> findByOfficina(Officina o);
	
	Utente findByEmail(String email);
	
	Utente findByEmailAndPassword(String email, String password);
	
	long countByRuolo(int ruolo);
	
}
