package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.TipologiaGuasto;
import it.contrader.automative.repositories.TipologiaGuastoRepository;
import it.contrader.automative.serviceInterfaces.ITipologiaGuasto;

@Service
public class TipologiaGuastoImpl implements ITipologiaGuasto{

	private TipologiaGuastoRepository tipologiaGuastoRepository;
	
    @Autowired
    public TipologiaGuastoImpl(TipologiaGuastoRepository tipologiaGuastoRepository) {
        this.tipologiaGuastoRepository = tipologiaGuastoRepository;
    }
	
	public TipologiaGuasto insert(TipologiaGuasto tipologiaGuasto) {
		TipologiaGuasto a = tipologiaGuastoRepository.findByCodice(tipologiaGuasto.getCodice());
        if(a == null){
            return tipologiaGuastoRepository.save(tipologiaGuasto);
        }
        else
            return a;
	}

}
