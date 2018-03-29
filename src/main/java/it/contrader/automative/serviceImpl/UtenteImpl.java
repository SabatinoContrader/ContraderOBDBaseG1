package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Utente;
import it.contrader.automative.repositories.UtenteRepository;
import it.contrader.automative.serviceInterfaces.IUtente;


@Service
public class UtenteImpl implements IUtente{

	private UtenteRepository utenteRepository;

    @Autowired
    public UtenteImpl(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }
	
	public Utente selectByEmail(String email) {
		return utenteRepository.findByEmail(email);
	}

	public Utente insert(Utente utente) {
		Utente a = utenteRepository.findById(utente.getId());
        if(a == null){
            return utenteRepository.save(utente);
        }
        else
            return a;
	}
	

	

}
