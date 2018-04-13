package it.contrader.automative.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.DatiTelemetria;
import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Telemetria;

@Repository
@Transactional
public interface TelemetriaRepository extends CrudRepository<Telemetria, Long>{

	Telemetria findById(int id);
	
	List<Telemetria> findByDispositivo(Dispositivo d);
	List<Telemetria> findByDatiTelemetria(DatiTelemetria dt);
	
}
