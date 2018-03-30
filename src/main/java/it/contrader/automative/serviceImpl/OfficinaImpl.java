package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Officina;
import it.contrader.automative.repositories.OfficinaRepository;
import it.contrader.automative.serviceInterfaces.IOfficina;

@Service
public class OfficinaImpl implements IOfficina{

	private OfficinaRepository officinaRepository;
	
    @Autowired
    public OfficinaImpl(OfficinaRepository officinaRepository) {
        this.officinaRepository = officinaRepository;
    }

	public Officina insert(Officina officina) {
		Officina a = officinaRepository.findById(officina.getId());
        if(a == null){
            return officinaRepository.save(officina);
        }
        else
            return a;
	}
}
