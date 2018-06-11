package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Promozione;
import it.contrader.automative.repositories.PromozioneRepository;
import it.contrader.automative.serviceInterfaces.IPromozione;

@Service
public class PromozioneImpl implements IPromozione{

	private PromozioneRepository promozioneRepository;
	
	@Autowired
    public PromozioneImpl(PromozioneRepository promozioneRepository) {
        this.promozioneRepository = promozioneRepository;
    }
	
	public Promozione insert(Promozione promozione) {
    	Promozione a = promozioneRepository.findById(promozione.getId());
        if(a == null){
            return promozioneRepository.save(promozione);
        }
        else
            return a;
    }

}
