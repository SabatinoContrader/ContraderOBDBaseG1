package it.contrader.automative.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.TipologiaGuasto;

@Repository
@Transactional
public interface TipologiaGuastoRepository extends CrudRepository<TipologiaGuasto, String>{

	TipologiaGuasto findByCodice(String codice);
	
}
