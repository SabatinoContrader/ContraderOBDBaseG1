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
import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Telemetria;
import it.contrader.automative.repositories.AutoRepository;
import it.contrader.automative.repositories.DispositivoRepository;
import it.contrader.automative.repositories.OfficinaRepository;
import it.contrader.automative.repositories.TelemetriaRepository;
import it.contrader.automative.serviceInterfaces.IDispositivo;
import it.contrader.automative.serviceInterfaces.ITelemetria;
import it.contrader.automative.serviceInterfaces.IDatiTelemetria;
import it.contrader.automative.utils.AutoLocation;
import it.contrader.automative.utils.GenericResponse;
import it.contrader.automative.utils.Posizione;

@RestController
@CrossOrigin(value = "*")
public class TelemetriaController {

	private IDispositivo IDispositivo;
	private static ITelemetria ITelemetria;
	private static IDatiTelemetria IDatiTelemetria;
	private OfficinaRepository officinaRepository;
	private AutoRepository autoRepository;
	private static DispositivoRepository dispositivoRepository;
	private TelemetriaRepository telemetriaRepository;

	@Autowired
	public TelemetriaController(AutoRepository autoRepository, OfficinaRepository officinaRepository,
			IDatiTelemetria IDatiTelemetria, IDispositivo IDispositivo, ITelemetria ITelemetria,
			DispositivoRepository dispositivoRepository, TelemetriaRepository telemetriaRepository) {

		this.IDispositivo = IDispositivo;
		this.ITelemetria = ITelemetria;
		this.IDatiTelemetria = IDatiTelemetria;
		this.autoRepository = autoRepository;
		this.dispositivoRepository = dispositivoRepository;
		this.telemetriaRepository = telemetriaRepository;
		this.officinaRepository = officinaRepository;

	}

	@RequestMapping(value = "/inserisciTelemetria", method = RequestMethod.POST)
	static public void inserisciTelemetria(@RequestBody DatiTelemetria datiTelemetria,
			@RequestParam("idDispositivo") int idDispositivo) {

		Telemetria telemetria = new Telemetria();

		telemetria.setData(new Date(System.currentTimeMillis()));

		IDatiTelemetria.insert(datiTelemetria);

		telemetria.setDatiTelemetria(datiTelemetria);
		telemetria.setDispositivo(dispositivoRepository.findById(idDispositivo));

		ITelemetria.insert(telemetria);

	}

	// Ultima telemetria del dispositivo passato
	@RequestMapping(value = "/ultimaTelemetria", method = RequestMethod.POST)
	public Telemetria ultimaTelemetria(@RequestParam("id") int idDispositivo) {

		Telemetria t = new Telemetria();

		t = telemetriaRepository.ultimaTelemetriADispositivo(idDispositivo);

		return t;
	}

	// + Lista tutte le Auto con posizione
	@RequestMapping(value = "/autoLocation", method = RequestMethod.POST)
	public List<AutoLocation> autoLocation() {

		List<Dispositivo> listaDispositivi = dispositivoRepository.findAll();
		List<AutoLocation> listaAutoLocation = new ArrayList();

		for (Dispositivo d : listaDispositivi) {
			Telemetria t = ultimaTelemetria(d.getId());
			Auto auto = d.getAuto();
			Posizione posizione = new Posizione();
			posizione.setLatitudine(t.getDatiTelemetria().getLatitudine());
			posizione.setLongitudine(t.getDatiTelemetria().getLongitudine());
			posizione.setIdDispositivo(d.getId());
			listaAutoLocation.add(new AutoLocation(auto, posizione));
		}

		return listaAutoLocation;

	}


		@RequestMapping(value = "/ultimeTelemetria", method = RequestMethod.POST)
		public List<Telemetria> ultimeTelemetria(@RequestParam("id") int idDispositivo) {
			
			List<Telemetria>  t = new ArrayList();
			
			t = telemetriaRepository.ultimeTelemetriADispositivo(idDispositivo);
			
			return t;
		}

		
		@RequestMapping(value = "/listaDispositiviOfficinaConTelemetria", method = RequestMethod.POST)
		public GenericResponse<List<Posizione>> listaDispositiviOfficinaConTelemetria(@RequestParam("idOfficina") int idOfficina){

			List<Dispositivo> lista = new ArrayList();
			
			List<Telemetria> listaTelemetrie = new ArrayList();
			
			

			Officina o = officinaRepository.findById(idOfficina);

			lista = dispositivoRepository.findByOfficina(o);
			
			
			for(int i = 0; i<lista.size(); i++) {
				listaTelemetrie.add(telemetriaRepository.ultimaTelemetriADispositivo(lista.get(i).getId()));
				System.out.println("\n\n\n\n"+ listaTelemetrie.get(i).getId() +" poi dispositivo " + listaTelemetrie.get(i).getDispositivo().getId() +"\n\n\n\n");
			}
			
			List<Posizione> listaPosizione = new ArrayList();
			
				for(int j=0; j<listaTelemetrie.size(); j++) 
				{
					Posizione posizione = new Posizione();
					posizione.setLatitudine(listaTelemetrie.get(j).getDatiTelemetria().getLatitudine()); 
					posizione.setLongitudine(listaTelemetrie.get(j).getDatiTelemetria().getLongitudine()); 
					posizione.setIdDispositivo(listaTelemetrie.get(j).getDispositivo().getId()); 
					listaPosizione.add(posizione);
				}
			
			
			return new GenericResponse<List<Posizione>>(listaPosizione);
		}
		
		// + Lista tutte le Auto con posizione
		@RequestMapping(value = "/autoLocationofficina", method = RequestMethod.POST)
		public List<AutoLocation> autoLocationofficina(@RequestParam("idOfficina") int idOfficina) {

			
			List<Dispositivo> listaDispositivi = dispositivoRepository.findByOfficina(officinaRepository.findById(idOfficina));
			List<AutoLocation> listaAutoLocation = new ArrayList();

			for (Dispositivo d : listaDispositivi) {
				Telemetria t = ultimaTelemetria(d.getId());
				if(t!=null) {
				Auto auto = d.getAuto();
				Posizione posizione = new Posizione();
				posizione.setLatitudine(t.getDatiTelemetria().getLatitudine());
				posizione.setLongitudine(t.getDatiTelemetria().getLongitudine());
				posizione.setIdDispositivo(d.getId());
				listaAutoLocation.add(new AutoLocation(auto, posizione));
				}
			}

			return listaAutoLocation;

		}

		
}
