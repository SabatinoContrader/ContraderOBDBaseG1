package it.contrader.automative.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Auto;

@Repository
@Transactional
public interface AutoRepository  extends CrudRepository<Auto, Long> {

	Auto findById(int id);
	
}
