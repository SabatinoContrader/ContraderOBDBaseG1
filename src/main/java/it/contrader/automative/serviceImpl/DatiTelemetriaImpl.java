package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.DatiTelemetria;
import it.contrader.automative.repositories.DatiTelemetriaRepository;
import it.contrader.automative.serviceInterfaces.IDatiTelemetria;

@Service
public class DatiTelemetriaImpl implements IDatiTelemetria{

	private DatiTelemetriaRepository datiTelemetriaRepository;
	
    @Autowired
    public DatiTelemetriaImpl(DatiTelemetriaRepository datiTelemetriaRepository) {
        this.datiTelemetriaRepository = datiTelemetriaRepository;
    }
	
	public DatiTelemetria insert(DatiTelemetria datiTelemetria) {
		DatiTelemetria a = datiTelemetriaRepository.findById(datiTelemetria.getId());
        if(a == null){
            return datiTelemetriaRepository.save(datiTelemetria);
        }
        else
            return a;
	}

}
