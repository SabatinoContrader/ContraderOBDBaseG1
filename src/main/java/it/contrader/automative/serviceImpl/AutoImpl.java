package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Auto;
import it.contrader.automative.repositories.AutoRepository;
import it.contrader.automative.serviceInterfaces.IAuto;

@Service
public class AutoImpl implements IAuto{

	private AutoRepository autoRepository;
	
    @Autowired
    public AutoImpl(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }
	
    public Auto insert(Auto auto) {
    	Auto a = autoRepository.findById(auto.getId());
        if(a == null){
            return autoRepository.save(auto);
        }
        else
            return a;
    }
}
