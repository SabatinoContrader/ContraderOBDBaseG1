package it.contrader.automative.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Utente;

@Repository
@Transactional
public interface NoleggioRepository  extends CrudRepository<Noleggio, Long> {

	Noleggio findById(int id);
	
	List<Noleggio> findByGuidatore(Utente u);
	
	List<Noleggio> findByOfficina(Officina o);
	
	
}
