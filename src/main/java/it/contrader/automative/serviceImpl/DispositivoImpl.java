package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.repositories.DispositivoRepository;
import it.contrader.automative.serviceInterfaces.IDispositivo;

@Service
public class DispositivoImpl implements IDispositivo{

	private DispositivoRepository dispositivoRepository;
	
    @Autowired
    public DispositivoImpl(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }
	
	
	public Dispositivo insert(Dispositivo dispositivo) {
		Dispositivo a = dispositivoRepository.findById(dispositivo.getId());
        if(a == null){
            return dispositivoRepository.save(dispositivo);
        }
        else
            return a;
	}
	
}
