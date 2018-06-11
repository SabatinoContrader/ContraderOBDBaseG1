package it.contrader.automative.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.DatiTelemetria;

@Repository
@Transactional
public interface DatiTelemetriaRepository extends CrudRepository<DatiTelemetria, Long> {

	DatiTelemetria findById(int id);
	
}
