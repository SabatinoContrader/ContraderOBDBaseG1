package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Preventivo;
import it.contrader.automative.repositories.PreventivoRepository;
import it.contrader.automative.serviceInterfaces.IPreventivo;

@Service
public class PreventivoImpl implements IPreventivo{

	private PreventivoRepository preventivoRepository;
	
    @Autowired
    public PreventivoImpl(PreventivoRepository preventivoRepository) {
        this.preventivoRepository = preventivoRepository;
    }

	public Preventivo insert(Preventivo preventivo) {
		Preventivo a = preventivoRepository.findById(preventivo.getId());
        if(a == null){
            return preventivoRepository.save(preventivo);
        }
        else
            return a;
	}
	
}
