package it.contrader.automative.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Ticket;
import it.contrader.automative.model.Utente;

@Repository
@Transactional
public interface TicketRepository extends CrudRepository<Ticket, Long> {

	Ticket findById(int id);
	
	List<Ticket> findByUtente(Utente u);
	List<Ticket> findByOfficina(Officina o);
	
}
