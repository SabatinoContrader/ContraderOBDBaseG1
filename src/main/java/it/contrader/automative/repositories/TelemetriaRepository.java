package it.contrader.automative.repositories;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
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
	
	@Query (value = "select * from telemetria where iddispositivo = ?1 order by id desc limit 1", nativeQuery = true)
	Telemetria ultimaTelemetriADispositivo(int idDispositivo);
	
	@Query (value = "select * from telemetria where iddispositivo = ?1 order by id desc limit 100", nativeQuery = true)
	List<Telemetria> ultimeTelemetriADispositivo(int idDispositivo);
	
	@Query (value = "select min(decimazione) from telemetria where (data >= DATE ?1 && data <= DATE ?2) && iddispositivo = ?3", nativeQuery = true)
	int primoDellaFinestra(String dataInizio, String dataFine, int idDispositivo);
	
	@Query (value = "select max(decimazione) from telemetria where (data >= DATE ?1 && data <= DATE ?2) && iddispositivo = ?3", nativeQuery = true)
	int ultimoDellaFinestra(String dataInizio, String dataFine, int idDispositivo);
	
	@Query (value = "select new list( min(decimazione) as min, max(decimazione) as max ) from telemetria where (data >= DATE ?1 && data <= DATE ?2) && iddispositivo = ?3", nativeQuery = true)
	Integer[] limitiDecimazione(String dataInizio, String dataFine, int idDispositivo);
	
	@Query (value = "select * from telemetria where decimazione = ?1 && iddispositivo = ?2 limit 1", nativeQuery = true)
	Telemetria ritornaDatoDecimazione(int decimazione, int idDispositivo);
	
	@Query (value = "select max(decimazione) from telemetria where iddispositivo = ?1", nativeQuery = true)
	int ultimaDecimazione(int idDispositivo);
}
