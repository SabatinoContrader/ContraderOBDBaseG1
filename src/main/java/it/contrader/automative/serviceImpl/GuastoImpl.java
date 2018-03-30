package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Guasto;
import it.contrader.automative.repositories.GuastoRepository;
import it.contrader.automative.serviceInterfaces.IGuasto;

@Service
public class GuastoImpl implements IGuasto{

	private GuastoRepository guastoRepository;
	
    @Autowired
    public GuastoImpl(GuastoRepository guastoRepository) {
        this.guastoRepository = guastoRepository;
    }
	
	public Guasto insert(Guasto guasto) {
		Guasto a = guastoRepository.findById(guasto.getId());
        if(a == null){
            return guastoRepository.save(guasto);
        }
        else
            return a;
	}

}
