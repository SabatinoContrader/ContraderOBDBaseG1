package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Noleggio;
import it.contrader.automative.repositories.NoleggioRepository;
import it.contrader.automative.serviceInterfaces.INoleggio;

@Service
public class NoleggioImpl implements INoleggio{

	private NoleggioRepository noleggioRepository;
	
    @Autowired
    public NoleggioImpl(NoleggioRepository noleggioRepository) {
        this.noleggioRepository = noleggioRepository;
    }

	public Noleggio insert(Noleggio noleggio) {
		Noleggio a = noleggioRepository.findById(noleggio.getId());
        if(a == null){
            return noleggioRepository.save(noleggio);
        }
        else
            return a;
	}
	
}
