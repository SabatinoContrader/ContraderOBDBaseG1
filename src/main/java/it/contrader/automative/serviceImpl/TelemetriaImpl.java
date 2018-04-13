package it.contrader.automative.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.automative.model.Telemetria;
import it.contrader.automative.repositories.TelemetriaRepository;
import it.contrader.automative.serviceInterfaces.ITelemetria;

@Service
public class TelemetriaImpl implements ITelemetria{

	private TelemetriaRepository telemetriaRepository;
	
    @Autowired
    public TelemetriaImpl(TelemetriaRepository telemetriaRepository) {
        this.telemetriaRepository = telemetriaRepository;
    }
	
	@Override
	public Telemetria insert(Telemetria telemetria) {
		Telemetria a = telemetriaRepository.findById(telemetria.getId());
        if(a == null){
            return telemetriaRepository.save(telemetria);
        }
        else
            return a;
	}

}
