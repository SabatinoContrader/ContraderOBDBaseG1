package it.contrader.automative.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.MessaggioTicket;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Utente;

@Repository
@Transactional
public interface MessaggioTicketRepository extends CrudRepository<MessaggioTicket, Long> {

	MessaggioTicket findById(int id);
	
	List<MessaggioTicket> findByUtente(Utente u);
	List<MessaggioTicket> findByOfficina(Officina o);
	
}
