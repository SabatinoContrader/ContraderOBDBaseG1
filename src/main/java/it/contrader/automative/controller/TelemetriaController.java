package it.contrader.automative.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.mapping.Value;
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
import it.contrader.automative.serviceInterfaces.IDatiDispositivo;

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
	private IDatiDispositivo IDatiDispositivo;

	@Autowired
	public TelemetriaController(AutoRepository autoRepository, OfficinaRepository officinaRepository,
			IDatiTelemetria IDatiTelemetria, IDispositivo IDispositivo, ITelemetria ITelemetria,
			DispositivoRepository dispositivoRepository, TelemetriaRepository telemetriaRepository,
			IDatiDispositivo IDatiDispositivo) {

		this.IDispositivo = IDispositivo;
		this.ITelemetria = ITelemetria;
		this.IDatiTelemetria = IDatiTelemetria;
		this.autoRepository = autoRepository;
		this.dispositivoRepository = dispositivoRepository;
		this.telemetriaRepository = telemetriaRepository;
		this.officinaRepository = officinaRepository;
		this.IDatiDispositivo = IDatiDispositivo;

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
			if (t != null) {
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

	@RequestMapping(value = "/ultimeTelemetria", method = RequestMethod.POST)
	public List<Telemetria> ultimeTelemetria(@RequestParam("id") int idDispositivo) {

		List<Telemetria> t = new ArrayList();

		t = telemetriaRepository.ultimeTelemetriADispositivo(idDispositivo);

		return t;
	}

	@RequestMapping(value = "/listaDispositiviOfficinaConTelemetria", method = RequestMethod.POST)
	public GenericResponse<List<Posizione>> listaDispositiviOfficinaConTelemetria(
			@RequestParam("idOfficina") int idOfficina) {

		List<Dispositivo> lista = new ArrayList();

		List<Telemetria> listaTelemetrie = new ArrayList();

		Officina o = officinaRepository.findById(idOfficina);

		lista = dispositivoRepository.findByOfficina(o);

		for (int i = 0; i < lista.size(); i++) {
			listaTelemetrie.add(telemetriaRepository.ultimaTelemetriADispositivo(lista.get(i).getId()));
			System.out.println("\n\n\n\n" + listaTelemetrie.get(i).getId() + " poi dispositivo "
					+ listaTelemetrie.get(i).getDispositivo().getId() + "\n\n\n\n");
		}

		List<Posizione> listaPosizione = new ArrayList();

		for (int j = 0; j < listaTelemetrie.size(); j++) {
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

		List<Dispositivo> listaDispositivi = dispositivoRepository
				.findByOfficina(officinaRepository.findById(idOfficina));
		List<AutoLocation> listaAutoLocation = new ArrayList();

		for (Dispositivo d : listaDispositivi) {
			Telemetria t = ultimaTelemetria(d.getId());
			if (t != null) {
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

	@RequestMapping(value = "/inviaTelemetria", method = RequestMethod.POST)
	public int inviaTelemetria(@RequestParam("telemetria") String dati) {

		Telemetria telemetria = new Telemetria();

		try {
			telemetria = IDatiDispositivo.getTelemetria(dati);

			IDatiTelemetria.insert(telemetria.getDatiTelemetria());
			ITelemetria.insert(telemetria);
		} catch (Exception e) {
			System.out.println("Invio Telemetria Fallito!");
			return 0;
		}

		if (telemetria == null)
			return 0;
		else
			return 1;
	}

/* 	@RequestMapping(value = "/riceviFinestra", method = RequestMethod.POST)
	public List<Telemetria> riceviFinestra(@RequestParam("dataInizio") String dataInizio,
			@RequestParam("dataFine") String dataFine, @RequestParam("idDispositivo") int idDispositivo) {

		List<Telemetria> lista = new ArrayList();

		int decimazioneInizio = telemetriaRepository.primoDellaFinestra(dataInizio, dataFine, idDispositivo);
		int decimazioneFine = telemetriaRepository.ultimoDellaFinestra(dataInizio, dataFine, idDispositivo);

		System.out.println(
				"\n\nDecimazione Inizio: " + decimazioneInizio + "\nDecimazione Fine: " + decimazioneFine + "\n\n");

		int numeroDati = (decimazioneFine - decimazioneInizio) + 1;

		for (int i = 0; i < numeroDati; i++) {
			lista.add(telemetriaRepository.ritornaDatoDecimazione(decimazioneInizio, idDispositivo));
			decimazioneInizio++;
		}

		return lista;
	} */

	@RequestMapping(value = "/telemetriaDecimata", method = RequestMethod.POST)
	public List<Telemetria> TelemetriaDecimata(@RequestParam("inizio") String inizio, @RequestParam("fine") String fine,
			@RequestParam("id") int id) {

		int dec_rate;
		double dec_rest;
		int max_data = 100; // Numero di dati richiesti nell'intervallo

		int start;
		int stop;
		
		try {
		
//		Integer[] minmax = telemetriaRepository.limitiDecimazione(inizio, fine, id);
		 start = telemetriaRepository.primoDellaFinestra(inizio, fine, id);
		 stop = telemetriaRepository.ultimoDellaFinestra(inizio, fine, id);
		} catch(Exception e) {return new ArrayList<Telemetria>();}
		
//		Integer start = minmax[0];
//		Integer stop = minmax[1];

		List<Integer> n_array = new ArrayList<Integer>();

		int total_data = stop - start;
		
		if(total_data > max_data) {
		dec_rate = total_data / (max_data - 1);
		int rest = total_data % (max_data - 1);
		dec_rest = (double) rest / (max_data - 1);
		}
		else
		{
			max_data = total_data;
			dec_rate = 1;
			dec_rest = 0;
		}

		int next = start;
		double resto = 0;

		for (int i = 0; i < max_data; i++) {
			if (i == max_data - 1) {
				n_array.add(stop);
			} else {
				n_array.add(next);
				resto = resto + dec_rest;
				if (resto >= 1) {
					next = next + dec_rate + 1;
					resto = resto - 1;
				} else {
					next = next + dec_rate;
				}
			}
		}
		
		StringBuilder decString = new StringBuilder();
		decString.append("(");
		for (int i=0; i<n_array.size(); i++) {
			decString.append(n_array.get(i));
			if(i<n_array.size()-1)
				decString.append(",");
		}
		decString.append(")");
		
		List<Telemetria> dati = new ArrayList<Telemetria>();
		
		dati = telemetriaRepository.ritornaListaDatiDecimati(decString.toString(), id);

//		for (int decimazione : n_array) {
//			Telemetria telemetria = telemetriaRepository.ritornaDatoDecimazione(decimazione, id);
//			dati.add(telemetria);
//		}

		return dati;

	}

}
