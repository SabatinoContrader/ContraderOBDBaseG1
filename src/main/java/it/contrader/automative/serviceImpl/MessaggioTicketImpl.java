package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.MessaggioTicket;
import it.contrader.automative.repositories.MessaggioTicketRepository;
import it.contrader.automative.serviceInterfaces.IMessaggioTicket;

@Service
public class MessaggioTicketImpl implements IMessaggioTicket{

	private MessaggioTicketRepository messaggioTicketRepository;
	
    @Autowired
    public MessaggioTicketImpl(MessaggioTicketRepository messaggioTicketRepository) {
        this.messaggioTicketRepository = messaggioTicketRepository;
    }
	
	
	public MessaggioTicket insert(MessaggioTicket ticket) {
		MessaggioTicket a = messaggioTicketRepository.findById(ticket.getId());
        if(a == null){
            return messaggioTicketRepository.save(ticket);
        }
        else
            return a;
	}
	
}
