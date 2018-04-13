package it.contrader.automative.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.DatiTelemetria;
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Telemetria;
import it.contrader.automative.repositories.DispositivoRepository;
import it.contrader.automative.repositories.TelemetriaRepository;
import it.contrader.automative.serviceInterfaces.IDispositivo;
import it.contrader.automative.serviceInterfaces.ITelemetria;
import it.contrader.automative.serviceInterfaces.IDatiTelemetria;
import it.contrader.automative.utils.GenericResponse;

@RestController
@CrossOrigin(value = "*")
public class TelemetriaController {

	private IDispositivo IDispositivo;
	private static ITelemetria ITelemetria;
	private static IDatiTelemetria IDatiTelemetria;
	
	private static DispositivoRepository dispositivoRepository;
	private TelemetriaRepository telemetriaRepository;

	@Autowired
	public TelemetriaController(IDatiTelemetria IDatiTelemetria, IDispositivo IDispositivo, ITelemetria ITelemetria, DispositivoRepository dispositivoRepository, TelemetriaRepository telemetriaRepository) {
		
		this.IDispositivo = IDispositivo;
		this.ITelemetria = ITelemetria;
		this.IDatiTelemetria = IDatiTelemetria;
		
		this.dispositivoRepository = dispositivoRepository;
		this.telemetriaRepository = telemetriaRepository;
		
	}
	
	
	
	@RequestMapping(value = "/inserisciTelemetria", method = RequestMethod.POST)
	static public void inserisciTelemetria(@RequestBody DatiTelemetria datiTelemetria, @RequestParam("idDispositivo") int idDispositivo) {

		Telemetria telemetria = new Telemetria();
		
		telemetria.setData(new Date(System.currentTimeMillis()));
		
		IDatiTelemetria.insert(datiTelemetria);
		
		telemetria.setDatiTelemetria(datiTelemetria);
		telemetria.setDispositivo(dispositivoRepository.findById(idDispositivo));
		
		
		ITelemetria.insert(telemetria);

	}
	
	
	
}
