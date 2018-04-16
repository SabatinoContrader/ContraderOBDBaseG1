package it.contrader.automative.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Officina;

@Repository
@Transactional
public interface OfficinaRepository  extends CrudRepository<Officina, Long> {

	Officina findById(int id);
	
	long count();
	
}
