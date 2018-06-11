package it.contrader.automative.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Appuntamento;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Utente;

@Repository
@Transactional
public interface AppuntamentoRepository extends CrudRepository<Appuntamento, Long>{

	Appuntamento findById(int id);
	
	List<Appuntamento> findByUtente(Utente u);
	List<Appuntamento> findByOfficina(Officina o);
}
