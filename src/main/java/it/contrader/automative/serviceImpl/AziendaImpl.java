package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Azienda;
import it.contrader.automative.repositories.AziendaRepository;
import it.contrader.automative.serviceInterfaces.IAzienda;

@Service
public class AziendaImpl implements IAzienda{

	private AziendaRepository aziendaRepository;
	
	@Autowired
    public AziendaImpl(AziendaRepository aziendaRepository) {
        this.aziendaRepository = aziendaRepository;
    }
	
	public Azienda insert(Azienda azienda) {
    	Azienda a = aziendaRepository.findById(azienda.getId());
        if(a == null){
            return aziendaRepository.save(azienda);
        }
        else
            return a;
    }
}
