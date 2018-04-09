package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Ticket;
import it.contrader.automative.repositories.TicketRepository;
import it.contrader.automative.serviceInterfaces.ITicket;

@Service
public class TicketImpl implements ITicket{

	private TicketRepository ticketRepository;
	
    @Autowired
    public TicketImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
	
	
	public Ticket insert(Ticket ticket) {
		Ticket a = ticketRepository.findById(ticket.getId());
        if(a == null){
            return ticketRepository.save(ticket);
        }
        else
            return a;
	}
	
}
