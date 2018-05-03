package it.contrader.automative.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Officina;

@Repository
@Transactional
public interface DispositivoRepository extends CrudRepository<Dispositivo, Long> {

	Dispositivo findById(int id);
	
	Dispositivo findByAuto(Auto a);
	
	Dispositivo findByCodice(String a);
	
	List<Dispositivo> findByOfficina(Officina o);
	
	List<Dispositivo> findAll();
	
}
