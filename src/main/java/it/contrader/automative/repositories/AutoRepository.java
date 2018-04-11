package it.contrader.automative.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Utente;

@Repository
@Transactional
public interface AutoRepository  extends CrudRepository<Auto, Long> {

	Auto findById(int id);
	
	List<Auto> findByOfficina(Officina o);
	
}
