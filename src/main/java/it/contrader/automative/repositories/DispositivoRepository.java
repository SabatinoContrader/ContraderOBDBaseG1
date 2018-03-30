package it.contrader.automative.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Dispositivo;

@Repository
@Transactional
public interface DispositivoRepository extends CrudRepository<Dispositivo, Long> {

	Dispositivo findById(int id);
	
	Dispositivo findByAuto(Auto a);
	
}
