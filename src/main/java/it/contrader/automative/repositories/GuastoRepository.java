package it.contrader.automative.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Guasto;

@Repository
@Transactional
public interface GuastoRepository extends CrudRepository<Guasto, Long>{

	Guasto findById(int id);
	
	List<Guasto> findByDispositivo(Dispositivo d);
}
