package it.contrader.automative.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Azienda;

@Repository
@Transactional
public interface AziendaRepository extends CrudRepository<Azienda, Long> {

	Azienda findById(int id);
	
}
