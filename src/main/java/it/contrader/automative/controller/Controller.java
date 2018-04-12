package it.contrader.automative.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.automative.model.Appuntamento;
import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Azienda;
import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Guasto;
import it.contrader.automative.model.MessaggioTicket;
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Preventivo;
import it.contrader.automative.model.Ticket;
import it.contrader.automative.model.Utente;
import it.contrader.automative.repositories.AppuntamentoRepository;
import it.contrader.automative.repositories.AutoRepository;
import it.contrader.automative.repositories.AziendaRepository;
import it.contrader.automative.repositories.DispositivoRepository;
import it.contrader.automative.repositories.GuastoRepository;
import it.contrader.automative.repositories.MessaggioTicketRepository;
import it.contrader.automative.repositories.NoleggioRepository;
import it.contrader.automative.repositories.OfficinaRepository;
import it.contrader.automative.repositories.PreventivoRepository;
import it.contrader.automative.repositories.UtenteRepository;
import it.contrader.automative.repositories.TicketRepository;
import it.contrader.automative.serviceInterfaces.IAppuntamento;
import it.contrader.automative.serviceInterfaces.IAuto;
import it.contrader.automative.serviceInterfaces.IDispositivo;
import it.contrader.automative.serviceInterfaces.INoleggio;
import it.contrader.automative.serviceInterfaces.IPreventivo;
import it.contrader.automative.serviceInterfaces.IUtente;
import it.contrader.automative.serviceInterfaces.IAzienda;
import it.contrader.automative.utils.Alerts;
import it.contrader.automative.utils.AutoScadenze;
import it.contrader.automative.utils.GenericResponse;
import it.contrader.automative.utils.LogInUtente;
import it.contrader.automative.utils.StatoAuto;
import it.contrader.automative.utils.TicketDTO;



@RestController
@CrossOrigin(value = "*")
//@RequestMapping("/login")
public class Controller {

	private IUtente IUtente;
	private IPreventivo IPreventivo;
	private IAppuntamento IAppuntamento;
	private IAzienda IAzienda;
	private IAuto IAuto;
	private IDispositivo IDispositivo;

	private INoleggio noleggioService;

	private AziendaRepository aziendaRepository;

	private AutoRepository autoRepository;
	private NoleggioRepository noleggioRepository;
	private DispositivoRepository dispositivoRepository;
	private GuastoRepository guastoRepository;
	private PreventivoRepository preventivoRepository;
	private AppuntamentoRepository appuntamentoRepository;
	private UtenteRepository utenteRepository;
	private OfficinaRepository officinaRepository;
	private TicketRepository ticketRepository;
	private MessaggioTicketRepository messaggioTicketRepository;

	@Autowired
	public Controller(IAzienda IAzienda, AziendaRepository aziendaRepository, IAuto IAuto, IDispositivo IDispositivo, IUtente IUtente, IPreventivo IPreventivo,IAppuntamento IAppuntamento, UtenteRepository utenteRepository ,AutoRepository autoRepository,  MessaggioTicketRepository messaggioTicketRepository ,NoleggioRepository noleggioRepository,TicketRepository ticketRepository, OfficinaRepository officinaRepository, DispositivoRepository dispositivoRepository, GuastoRepository guastoRepository, PreventivoRepository preventivoRepository, AppuntamentoRepository appuntamentoRepository, INoleggio noleggioService) {
		this.IUtente = IUtente;
		this.IPreventivo = IPreventivo;
		this.IAppuntamento=IAppuntamento;
		this.utenteRepository = utenteRepository;
		this.autoRepository = autoRepository;
		this.noleggioRepository = noleggioRepository;
		this.dispositivoRepository = dispositivoRepository;
		this.guastoRepository = guastoRepository;
		this.ticketRepository = ticketRepository;
		this.preventivoRepository = preventivoRepository;
		this.appuntamentoRepository = appuntamentoRepository;
		this.officinaRepository = officinaRepository;
		this.messaggioTicketRepository = messaggioTicketRepository;
		this.noleggioService = noleggioService;
		this.IAuto = IAuto;
		this.IDispositivo = IDispositivo;
		this.aziendaRepository = aziendaRepository;
		this.IAzienda = IAzienda;
	}


	// '+' : Revisionati
	// '!' : Dovrebbero funzionare
	// '?' : Saltato per ora
	// '?!' : Saltato per ora ma dovrebbe funzionare


	//+ Lista tutte le Auto mai (anche noleggi scaduti) associate al Cliente (Utente)
	@RequestMapping(value = "/autoNoleggiCliente", method = RequestMethod.POST)
	public GenericResponse<List<Auto>> getAutoNoleggiCliente(@RequestParam("id") int idUtente) {

		List<Auto> lista = new ArrayList();

		List<Noleggio> listaNoleggi = getNoleggiCliente(idUtente).getData();

		for(int i = 0; i<listaNoleggi.size(); i++) lista.add(listaNoleggi.get(i).getAuto());

		return new GenericResponse<List<Auto>>(lista);

	}

	//+ Lista tutte le Auto "attualmente" in noleggio dal Cliente 
	@RequestMapping(value = "/autoCliente", method = RequestMethod.POST)
	public GenericResponse<List<Auto>> getAutoCliente(@RequestParam("id") int idUtente) {

		List<Auto> lista = new ArrayList();

		List<Noleggio> listaNoleggi = getNoleggiCliente(idUtente).getData();

		for(int i = 0; i<listaNoleggi.size(); i++) if(listaNoleggi.get(i).getDataFineNoleggio().after(new Date(System.currentTimeMillis()))) lista.add(listaNoleggi.get(i).getAuto());

		return new GenericResponse<List<Auto>>(lista);

	}

	//+ Lista Auto Officina
	@RequestMapping(value = "/autoOfficina", method = RequestMethod.POST)
	public GenericResponse<List<Auto>> getAutoOfficina(@RequestParam("id") int idUtente) {

		return new GenericResponse<List<Auto>>(autoRepository.findByOfficina(utenteRepository.findById(idUtente).getOfficina()));

	}

	//+ Lista Guasti Irrisolti (sia officina che cliente) e esteso anche ad Amministratore Azienda e/o Dipendente
	@RequestMapping(value = "/getGuastiIrrisolti", method = RequestMethod.POST)
	public GenericResponse<List<Guasto>> getGuastiIrrisolti(@RequestParam("id") int idUtente) {

		List<Guasto> listaGuasti = new ArrayList();

		Utente u = utenteRepository.findById(idUtente);

		List<Auto> listaAuto = new ArrayList();
		if(u.getRuolo() == 0 || u.getRuolo() == 2) listaAuto = getAutoCliente(idUtente).getData();
		else listaAuto = getAutoOfficina(idUtente).getData();

		for(int i = 0; i<listaAuto.size(); i++) {
			List<Guasto> g = guastoRepository.findByDispositivo(dispositivoRepository.findByAuto(listaAuto.get(i)));

			for(int e=0; e<g.size(); e++) { 
				//if(!g.get(e).getStatoRisoluzione().equals("Risolto")) 
				if(!g.get(e).getStatoRisoluzione().equals("Risolto")) listaGuasti.add(g.get(e));

			}
		}

		return new GenericResponse<List<Guasto>>(listaGuasti);
	}

	//+ Lista TUTTI Guasti (sia officina che cliente) e esteso anche ad Amministratore Azienda e/o Dipendente
	@RequestMapping(value = "/getGuasti", method = RequestMethod.POST)
	public GenericResponse<List<Guasto>> getGuasti(@RequestParam("id") int idUtente) {

		List<Guasto> listaGuasti = new ArrayList();

		Utente u = utenteRepository.findById(idUtente);

		List<Auto> listaAuto = new ArrayList();
		if(u.getRuolo() == 0 || u.getRuolo() == 2) listaAuto = getAutoCliente(idUtente).getData();
		else listaAuto = getAutoOfficina(idUtente).getData();

		for(int i = 0; i<listaAuto.size(); i++) {
			List<Guasto> g = guastoRepository.findByDispositivo(dispositivoRepository.findByAuto(listaAuto.get(i)));

			for(int e=0; e<g.size(); e++) listaGuasti.add(g.get(e));
		}

		return new GenericResponse<List<Guasto>>(listaGuasti);
	}

	//+ Lista Noleggi Officina
	@RequestMapping(value = "/noleggiOfficina", method = RequestMethod.POST)
	public GenericResponse<List<Noleggio>> getNoleggiOfficina(@RequestParam("id") int idOfficina) {

		List<Noleggio> listaNoleggiOff = new ArrayList();

		listaNoleggiOff = noleggioRepository.findByOfficina(officinaRepository.findById(idOfficina));

		return new GenericResponse<List<Noleggio>>(listaNoleggiOff);

	}

	//+ Lista Noleggi Cliente (Anche assegnate da azienda a dipendente)
	@RequestMapping(value = "/noleggiCliente", method = RequestMethod.POST)
	public GenericResponse<List<Noleggio>> getNoleggiCliente(@RequestParam("id") int idUtente) {

		List<Noleggio> listaNoleggi = new ArrayList();

		listaNoleggi = noleggioRepository.findByGuidatore(utenteRepository.findById(idUtente));

		return new GenericResponse<List<Noleggio>>(listaNoleggi);

	}

	//+ Lista auto in scadenza (sia officina che cliente) e esteso anche ad Amministratore Azienda e/o Dipendente
	@RequestMapping(value = "/autoInScadenza", method = RequestMethod.POST)
	public GenericResponse<List<AutoScadenze>> getAutoInScadenza(@RequestParam("id") int idUtente) {

		List<AutoScadenze> lista = new ArrayList();

		Utente u = utenteRepository.findById(idUtente);

		List<Auto> listaAuto = new ArrayList();
		if(u.getRuolo() == 0 || u.getRuolo() == 2) listaAuto = getAutoCliente(idUtente).getData();
		else listaAuto = getAutoOfficina(idUtente).getData();

		lista = Alerts.listaAutoInScadenza(listaAuto);

		return new GenericResponse<List<AutoScadenze>>(lista);

	}

	
	
	
	
	//+ Lista Auto Azienda
		@RequestMapping(value = "/autoAzienda", method = RequestMethod.POST)
		public GenericResponse<List<Auto>> getAutoAzienda(@RequestParam("id") int idAzienda) {

			List<Auto> listaAuto = new ArrayList();
			List<Noleggio> noleggi = getNoleggiAzienda(idAzienda).getData();
					
			for(int i = 0; i<noleggi.size(); i++) listaAuto.add(noleggi.get(i).getAuto());
			
			return new GenericResponse<List<Auto>>(listaAuto);

		}
	
	//+ Lista Noleggi Azienda
		@RequestMapping(value = "/noleggiAzienda", method = RequestMethod.POST)
		public GenericResponse<List<Noleggio>> getNoleggiAzienda(@RequestParam("id") int idAzienda) {

			List<Noleggio> listaNoleggiAzienda = new ArrayList();

			listaNoleggiAzienda = noleggioRepository.findByAzienda(aziendaRepository.findById(idAzienda));

			return new GenericResponse<List<Noleggio>>(listaNoleggiAzienda);

		}
	
	
	//! Lista auto con status associato
	public List<StatoAuto> statoAuto(List<Auto> listaAuto, Utente u){
		
		List<StatoAuto> lista = new ArrayList();
		
		List<Auto> rimanenti = new ArrayList();
		List<Auto> rimanenti1 = new ArrayList();
		List<Auto> rimanenti2 = new ArrayList();
		
		//Cerco auto con guasti
		List<Guasto> autoConGuasti = new ArrayList();
		if(listaAuto.size() != 0) { autoConGuasti = getGuastiIrrisolti(u.getId()).getData();}
		System.out.println("\n\narrivato000\n\n");
		
		if((autoConGuasti.size() != 0)){
			System.out.println("\n\narrivato001\n\n");
			for(int i=0; i<listaAuto.size(); i++){
				
				boolean trovato = false;
				
				for(int e=0; e<autoConGuasti.size() &&  !trovato; e++) {
					
					if(listaAuto.get(i).equals(autoConGuasti.get(e).getDispositivo().getAuto())){
						trovato = true;
						lista.add(new StatoAuto(listaAuto.get(i), "Danger"));
						
						//autoConGuasti.remove(e);
					}
				}
				
				if(!trovato) rimanenti.add(listaAuto.get(i));
			}
			
		} else rimanenti = listaAuto;
		
		
		List<AutoScadenze> autoInScadenza = new ArrayList();
		if(rimanenti.size() != 0) { autoInScadenza = getAutoInScadenza(u.getId()).getData();}
		
		if((autoInScadenza.size() != 0)){
			System.out.println("\n\narrivato002\n\n");
			for(int i=0; i<rimanenti.size(); i++){

				boolean trovato = false;

				for(int e=0; e<autoInScadenza.size() &&  !trovato; e++) {

					if(listaAuto.get(i).equals(autoInScadenza.get(e).getAuto())){
						trovato = true;
						lista.add(new StatoAuto(rimanenti.get(i), "Warning"));
						
						//autoInScadenza.remove(e);
					}
				}

				if(!trovato) rimanenti1.add(rimanenti.get(i));
			}

		} else rimanenti1 = rimanenti;
		
		
		List<Auto> kmScadenza = new ArrayList();
		if(rimanenti1.size() != 0) { 
			
			System.out.println("\n\narrivato\n\n");
			
			if((u.getRuolo() == 0) || (u.getRuolo() == 2)) {
				List<Noleggio> n = getNoleggiKmInScadenzaCliente(u.getId()).getData();
				for(int i = 0; i<n.size(); i++) kmScadenza.add(n.get(i).getAuto());
			} else {
				List<Noleggio> n = getNoleggiKmInScadenzaOfficina(u.getOfficina().getId()).getData();
				for(int i = 0; i<n.size(); i++) kmScadenza.add(n.get(i).getAuto());
			}
		} else rimanenti2 = rimanenti1;

		if((kmScadenza.size() != 0)){

			System.out.println("\n\narrivato 2\n\n");
			for(int i=0; i<rimanenti1.size(); i++){

				boolean trovato = false;

				for(int e=0; e<kmScadenza.size() &&  !trovato; e++) {

					if(rimanenti1.get(i).equals(kmScadenza.get(e))){
						trovato = true;
						lista.add(new StatoAuto(rimanenti1.get(i), "Warning"));
						
						//kmScadenza.remove(e);
					}
				}

				if(!trovato) rimanenti2.add(rimanenti1.get(i));
			}

		}
		
		
		
		for(int i = 0; i<rimanenti2.size(); i++) lista.add(new StatoAuto(rimanenti2.get(i), "Success"));
		
		return lista;
	}
	
	//Situazione Auto
	@RequestMapping(value = "/situazioneAuto", method = RequestMethod.POST)
	public HashMap<String, String> situazioneAuto(@RequestParam("id") int idAuto){
		
		HashMap<String, String> problemi = new HashMap<String, String>();
		
		Auto a = autoRepository.findById(idAuto);
		List<Guasto> guasti = guastoRepository.findByDispositivo(dispositivoRepository.findByAuto(a));
		for(int i=0; i<guasti.size(); i++) problemi.put("danger", guasti.get(i).getTipologiaGuasto().getCodice());
		
		List<Auto> auto = new ArrayList();
		auto.add(a);
		List<AutoScadenze> scadenze = Alerts.listaAutoInScadenza(auto);
		if(scadenze != null) {
			for(int i=0; i<scadenze.get(0).cosaStaPerScadere().size(); i++) problemi.put("warning", scadenze.get(0).cosaStaPerScadere().get(i));
			for(int i=0; i<scadenze.get(0).cosaEScaduto().size(); i++) problemi.put("warning", scadenze.get(0).cosaEScaduto().get(i)+" (Scaduto)");
		}
		
		List<Noleggio> listaKmInScadenza = new ArrayList();
		listaKmInScadenza = Alerts.kmNoleggioInScadenza(noleggioRepository.findByAuto(a));
		for(int i=0; i<listaKmInScadenza.size(); i++) problemi.put("warning", "Km del Noleggio in Scadenza");
		 
		if(problemi.isEmpty()) problemi.put("success", "Nessun Problema");
		
		return problemi;
	}
	
	
	
	
	//+ Lista Noleggi con KmNoleggio in Scadenza dell'officina
	@RequestMapping(value = "/kmInScadenzaOfficina", method = RequestMethod.POST)
	public GenericResponse<List<Noleggio>> getNoleggiKmInScadenzaOfficina(@RequestParam("id") int idOfficina) {

		List<Noleggio> listaKmInScadenza = new ArrayList();

		listaKmInScadenza = Alerts.kmNoleggioInScadenza(getNoleggiOfficina(idOfficina).getData());

		return new GenericResponse<List<Noleggio>>(listaKmInScadenza);

	}

	//+ Lista Noleggi con KmNoleggio in Scadenza del cliente (sia business che normale)
	@RequestMapping(value = "/kmInScadenzaCliente", method = RequestMethod.POST)
	public GenericResponse<List<Noleggio>> getNoleggiKmInScadenzaCliente(@RequestParam("id") int idUtente) {

		List<Noleggio> listaKmInScadenza = new ArrayList();

		listaKmInScadenza = Alerts.kmNoleggioInScadenza(getNoleggiCliente(idUtente).getData());

		return new GenericResponse<List<Noleggio>>(listaKmInScadenza);

	}

	//?! Lista Preventivi del Cliente
	@RequestMapping(value = "/preventiviCliente", method = RequestMethod.POST)
	public GenericResponse<List<Preventivo>> getPreventiviCliente(@RequestParam("id") int idUtente) {

		List<Preventivo> listaPreventivi = new ArrayList();

		listaPreventivi = preventivoRepository.findByUtente(utenteRepository.findById(idUtente));

		return new GenericResponse<List<Preventivo>>(listaPreventivi);


	}

	//! Lista Preventivi dell'Officina
	@RequestMapping(value = "/preventiviOfficina", method = RequestMethod.POST)
	public GenericResponse<List<Preventivo>> getPreventiviOfficina(@RequestParam("id") int idOfficina) {

		List<Preventivo> listaPreventiviOfficina = new ArrayList();

		listaPreventiviOfficina = preventivoRepository.findByOfficina(officinaRepository.findById(idOfficina));

		return new GenericResponse<List<Preventivo>>(listaPreventiviOfficina);

	}

	//?! Lista Appuntamenti del Cliente
	@RequestMapping(value = "/appuntamentiCliente", method = RequestMethod.POST)
	public GenericResponse<List<Appuntamento>> getAppuntamentiCliente(@RequestParam("id") int idUtente) {

		List<Appuntamento> listaAppuntamenti = new ArrayList();

		listaAppuntamenti = appuntamentoRepository.findByUtente(utenteRepository.findById(idUtente));

		return new GenericResponse<List<Appuntamento>>(listaAppuntamenti);

	}

	//! Lista Appuntamenti dell'Officina
	@RequestMapping(value = "/appuntamentiOfficina", method = RequestMethod.POST)
	public GenericResponse<List<Appuntamento>> getAppuntamentiOfficina(@RequestParam("id") int idOfficina) {

		List<Appuntamento> listaAppuntamentiOfficina = new ArrayList();

		listaAppuntamentiOfficina = appuntamentoRepository.findByOfficina(officinaRepository.findById(idOfficina));

		return new GenericResponse<List<Appuntamento>>(listaAppuntamentiOfficina);

	}

	//! Lista Clienti NORMALI dell'Officina
	@RequestMapping(value = "/clientiOfficina", method = RequestMethod.POST)
	public GenericResponse<List<Utente>> getClientiOfficina(@RequestParam("id") int idOfficina) {

		List<Utente> listaUtenti = new ArrayList();

		listaUtenti = utenteRepository.findByOfficina(officinaRepository.findById(idOfficina));

		//Rimuovi i clienti aziendali
		for (int i = 0; i<listaUtenti.size(); i++) if(listaUtenti.get(i).getRuolo() == 2) listaUtenti.remove(i);

		return new GenericResponse<List<Utente>>(listaUtenti);

	}

	//! Lista Clienti Business (Aziende) dell'Officina
	@RequestMapping(value = "/clientiAziendeOfficina", method = RequestMethod.POST)
	public GenericResponse<List<Utente>> getClientiAziendeOfficina(@RequestParam("id") int idOfficina) {

		List<Utente> listaUtenti = new ArrayList();
		List<Utente> aziende = new ArrayList();

		listaUtenti = utenteRepository.findByOfficina(officinaRepository.findById(idOfficina));

		//Rimuovi i clienti aziendali
		for (int i = 0; i<listaUtenti.size(); i++) if(listaUtenti.get(i).getRuolo() == 2) aziende.add(listaUtenti.get(i));

		return new GenericResponse<List<Utente>>(aziende);

	}

	//+ LOGIN
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LogInUtente getUser(@RequestParam("email") String email, @RequestParam("pwd") String password){

		Utente u = IUtente.selectByEmail(email);

		LogInUtente dati = new LogInUtente();

		if(u!=null && u.getPassword().equals(password)) {

			int guasti=0;

			switch (u.getRuolo()) {
			case 0 :

				List<Auto> listaAutoCliente = getAutoCliente(u.getId()).getData();
				dati = new LogInUtente(u, getGuastiIrrisolti(u.getId()).getData().size(), getAutoInScadenza(u.getId()).getData().size(), getNoleggiKmInScadenzaCliente(u.getId()).getData().size(), statoAuto(listaAutoCliente, u));
				break;

			case 1 : 

				List<Auto> listaAutoOfficina = getAutoOfficina(u.getId()).getData();
				dati = new LogInUtente(u, getGuastiIrrisolti(u.getId()).getData().size(), getAutoInScadenza(u.getId()).getData().size(), getNoleggiKmInScadenzaOfficina(u.getOfficina().getId()).getData().size(), statoAuto(listaAutoOfficina, u));
				break;
			case 2 :

				System.out.println("\n\n");
				System.out.println(u.getAzienda().getId());
				List<Auto> listaAutoAzienda = getAutoAzienda(u.getAzienda().getId()).getData();
				dati = new LogInUtente(u, getGuastiIrrisolti(u.getId()).getData().size(), getAutoInScadenza(u.getId()).getData().size(), getNoleggiKmInScadenzaCliente(u.getId()).getData().size(), statoAuto(listaAutoAzienda, u));
				break;
			}

		}
		return dati;
	}



	//Operazioni Vecchio Sprint (le ho modificare per funzionare con Rest, sono modifiche banali quindi NON ho testato)


	//?! Inserimenti nel DB
	@RequestMapping(value = "/inviapreventivo", method = RequestMethod.POST)
	public void inviapreventivo(@RequestParam("email") String email, @RequestParam("dettagli") String dettagli, @RequestParam("idauto") String idauto)
	{
		Utente u = IUtente.selectByEmail(email);
		Auto a = autoRepository.findById(Integer.parseInt(idauto));
		Officina o = u.getOfficina();

		// create a java calendar instance
		Calendar calendar = Calendar.getInstance();

		// get a java date (java.util.Date) from the Calendar instance.
		// this java date will represent the current date, or "now".
		java.util.Date currentDate = calendar.getTime();

		// now, create a java.sql.Date from the java.util.Date
		java.sql.Date date = new java.sql.Date(currentDate.getTime());


		//Creazione nuovo preventivo
		Preventivo p = new Preventivo();
		p.setAuto(a);
		p.setUtente(u);
		p.setOfficina(o);
		p.setData(date);
		p.setDettagli(dettagli);
		p.setCosto(0);
		p.setStato(0);
		p.setRisposta("");

		// p = new Preventivo(a,u,o,date,dettagli,0,0,"");
		// Inserimento preventivo creato in database

		IPreventivo.insert(p);

	}

	@RequestMapping(value = "/richiediappuntamento", method = RequestMethod.POST)
	public void richiediappuntamento(@RequestParam("emailapp") String email, @RequestParam("dettagliapp") String dettagli, @RequestParam("ora") String ora,@RequestParam("dataAppuntamento") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataAppuntamento)
	{
		Utente u = IUtente.selectByEmail(email);

		Officina o = u.getOfficina();

		/*// create a java calendar instance
			Calendar calendar = Calendar.getInstance();

			// get a java date (java.util.Date) from the Calendar instance.
			// this java date will represent the current date, or "now".
			java.util.Date currentDate = calendar.getTime();

			// now, create a java.sql.Date from the java.util.Date
			java.sql.Date date = new java.sql.Date(currentDate.getTime());
		 */

		//Creazione nuovo appuntamento
		Appuntamento a = new Appuntamento();
		a.setUtente(u);
		a.setOfficina(o);
		a.setData(dataAppuntamento);
		a.setOra(ora);
		a.setDettagli(dettagli);
		a.setStato(0);
		a.setRisposta("");
		//	    	Appuntamento a = new Appuntamento(2,u,o,date,ora,dettagli,0,"");
		// Inserimento appuntamento creato in database

		IAppuntamento.insert(a);
	}

	@RequestMapping(value = "/rispondipreventivo", method = RequestMethod.POST)
	public void rispondipreventivo( @RequestParam("dettagli") String dettagli, @RequestParam("costoprev") String costoprev, @RequestParam("idprev") String idprev)
	{

		Preventivo p = preventivoRepository.findById(Integer.parseInt(idprev));
		p.setStato(1);
		p.setCosto(Float.parseFloat(costoprev));
		p.setRisposta(dettagli);

		preventivoRepository.save(p);
	}

	@RequestMapping(value = "/rispondiappuntamento", method = RequestMethod.POST)
	public void rispondiappuntamento(@RequestParam("emailapp") String email, @RequestParam("dettagliapp") String dettagli, @RequestParam("idapp") String idapp, @RequestParam("selectapp") String stato)
	{
		Utente u = IUtente.selectByEmail(email);

		Officina o = u.getOfficina();
		Appuntamento a = appuntamentoRepository.findById(Integer.parseInt(idapp));

		a.setStato(Integer.parseInt(stato));
		a.setRisposta(dettagli);

		appuntamentoRepository.save(a);
	}

	@RequestMapping(value = "/setrisoltoguasto", method = RequestMethod.POST)
	public void setrisoltoguasto(@RequestParam("idguasto") String idguasto)
	{
		Guasto g = guastoRepository.findById(Integer.parseInt(idguasto));

		g.setStatoRisoluzione("Risolto");


		guastoRepository.save(g);
	}


	//! Ritorno Lista auto per singolo Utente
	@RequestMapping(value = "/listaautoutente", method = RequestMethod.POST)
	public GenericResponse<List<Noleggio>> listaautoutente(@RequestParam("id") int id){

		Utente u = utenteRepository.findById(id);
		List<Noleggio> n = noleggioRepository.findByGuidatore(u);

		return new GenericResponse<List<Noleggio>>(n);
	}





	//! Ritorno Lista dispositivi della singola officina
	@RequestMapping(value = "/listaDispositiviOfficina", method = RequestMethod.POST)
	public GenericResponse<List<Dispositivo>> listaDispositiviOfficina(@RequestParam("idOfficina") int idOfficina){

		List<Dispositivo> lista = new ArrayList();

		Officina o = officinaRepository.findById(idOfficina);

		lista = dispositivoRepository.findByOfficina(o);

		return new GenericResponse<List<Dispositivo>>(lista);
	}

	//! Inserimento Noleggio
	@RequestMapping(value = "/inserisciNoleggio", method = RequestMethod.POST)
	public void inserisciNoleggio(@RequestParam("idOfficina") int idOfficina, @RequestParam("idAuto") int idAuto, @RequestParam("CapLuogoDiRiconsegna") int CapLuogoDiRiconsegna,
			@RequestParam("CapLuogoDiRitiro") int CapLuogoDiRitiro, @RequestParam("DataInizioNoleggio") @DateTimeFormat(pattern = "dd/MM/yyyy") Date DataInizioNoleggio, 
			@RequestParam("DataFineNoleggio") @DateTimeFormat(pattern = "dd/MM/yyyy") Date DataFineNoleggio, @RequestParam("idUtente") int idUtente) {

		Noleggio n = new Noleggio();
		//Noleggio a = new Noleggio();

		n.setAuto(autoRepository.findById(idAuto));
		n.setCapLuogoDiRiconsegna(CapLuogoDiRiconsegna);
		n.setCapLuogoDiRitiro(CapLuogoDiRitiro);
		n.setDataInizioNoleggio(DataInizioNoleggio);
		n.setDataFineNoleggio(DataFineNoleggio);
		n.setOfficina(officinaRepository.findById(idOfficina));
		n.setGuidatore(utenteRepository.findById(idUtente));

		noleggioService.insert(n);

	}

	//! Inserimento Cliente
	@RequestMapping(value = "/inserisciCliente", method = RequestMethod.POST)
	public void inserisciCliente(@RequestParam("cognome") String cognome, @RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("idOfficina") int idOfficina, @RequestParam("telefono") String telefono) {

		Utente u = new Utente();

		u.setCognome(cognome);
		u.setNome(nome);
		u.setEmail(email);
		u.setPassword(password);
		u.setDataRegistrazione(new Date(System.currentTimeMillis()));
		u.setOfficina(officinaRepository.findById(idOfficina));
		u.setRuolo(0);
		u.setTelefono(telefono);
		u.setStato(0);

		IUtente.insert(u);

	}

	//?! Inserimento Azienda (Cliente Business)
	@RequestMapping(value = "/inserisciAzienda", method = RequestMethod.POST)
	public void inserisciAzienda(@RequestParam("denominazione") String denominazione, @RequestParam("nomeReferente") String nomeReferente, @RequestParam("cognomeReferente") String cognomeReferente,
			@RequestParam("partitaIva") String partitaIva, @RequestParam("indirizzo") String indirizzo, @RequestParam("citta") String citta) {

		Azienda a = new Azienda();

		a.setDenominazione(denominazione);
		a.setNomeReferente(nomeReferente);
		a.setCognomeReferente(cognomeReferente);
		a.setPartitaIva(partitaIva);
		a.setIndirizzo(indirizzo);
		a.setCitta(citta);

		IAzienda.insert(a);

	}

	//?! Inserimento Utente Amministratore Azienda (colui che controllerà l'account aziendale)
	@RequestMapping(value = "/inserisciUtenteAzienda", method = RequestMethod.POST)
	public void inserisciUtenteAzienda(@RequestParam("idAzienda") int idAzienda, @RequestParam("cognome") String cognome, @RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("idOfficina") int idOfficina, @RequestParam("telefono") String telefono) {

		Utente u = new Utente();

		u.setCognome(cognome);
		u.setNome(nome);
		u.setEmail(email);
		u.setPassword(password);
		u.setDataRegistrazione(new Date(System.currentTimeMillis()));
		u.setOfficina(officinaRepository.findById(idOfficina));
		u.setRuolo(2);
		u.setTelefono(telefono);
		u.setStato(0);

		u.setAzienda(aziendaRepository.findById(idAzienda));

		IUtente.insert(u);

	}

	//?! Inserimento Dipendente Aziendale 
	@RequestMapping(value = "/inserisciDipendenteAzienda", method = RequestMethod.POST)
	public void inserisciDipendenteAzienda(@RequestParam("idAzienda") int idAzienda, @RequestParam("cognome") String cognome, @RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("idOfficina") int idOfficina, @RequestParam("telefono") String telefono) {

		Utente u = new Utente();

		u.setCognome(cognome);
		u.setNome(nome);
		u.setEmail(email);
		u.setPassword(password);
		u.setDataRegistrazione(new Date(System.currentTimeMillis()));
		u.setOfficina(officinaRepository.findById(idOfficina));
		u.setRuolo(0);
		u.setTelefono(telefono);
		u.setStato(0);

		u.setAzienda(aziendaRepository.findById(idAzienda));

		IUtente.insert(u);

	}

	//! Inserimento Auto
	@RequestMapping(value = "/inserisciAuto", method = RequestMethod.POST)
	public void inserisciAuto(@RequestParam("marca") String marca, @RequestParam("modello") String modello, @RequestParam("targa") String targa,
			@RequestParam("numeroTelaio") String numeroTelaio, @RequestParam("cilindrata") int cilindrata, @RequestParam("cambio") String cambio, @RequestParam("potenza") int potenza, @RequestParam("tipologiaAuto") String tipologiaAuto, 
			@RequestParam("alimentazione") String alimentazione, @RequestParam("numeroPorte") int numeroPorte, @RequestParam("kmAttuali") int kmAttuali,
			@RequestParam("idOfficina") int idOfficina, @RequestParam("scadenzaAssicurazione") @DateTimeFormat(pattern = "dd/MM/yyyy") Date scadenzaAssicurazione, 
			@RequestParam("scadenzaBollo") @DateTimeFormat(pattern = "dd/MM/yyyy") Date scadenzaBollo, @RequestParam("scadenzaRevisione") @DateTimeFormat(pattern = "dd/MM/yyyy") Date scadenzaRevisione,
			@RequestParam("scadenzaTagliando") @DateTimeFormat(pattern = "dd/MM/yyyy") Date scadenzaTagliando) {

		Auto a = new Auto();

		a.setMarca(marca);
		a.setModello(modello);
		a.setTarga(targa);
		a.setNumeroTelaio(numeroTelaio);
		a.setCilindrata(cilindrata);
		a.setTipologiaAuto(tipologiaAuto);
		a.setAlimentazione(alimentazione);
		a.setDaNoleggio(1);
		a.setNumeroPorte(numeroPorte);
		a.setKmAttuali(kmAttuali);
		a.setKmInizioNoleggio(0);
		a.setOfficina(officinaRepository.findById(idOfficina));

		a.setScadenzaAssicurazione(scadenzaAssicurazione);
		a.setScadenzaBollo(scadenzaBollo);
		a.setScadenzaRevisione(scadenzaRevisione);
		a.setScadenzaTagliando(scadenzaTagliando);
		
		a.setCambio(cambio);
		a.setPotenza(potenza);

		IAuto.insert(a);

	}

	//! Inserimento Dispositivo
	@RequestMapping(value = "/inserisciDispositivo", method = RequestMethod.POST)
	public void inserisciDispositivo(@RequestParam("idOfficina") int idOfficina, @RequestParam("codice") String codice) {

		Dispositivo d = new Dispositivo();

		d.setOfficina(officinaRepository.findById(idOfficina));
		d.setCodice(codice);
		// Non serve inserire data di installazione se non si installa su nessuna auto
		//	d.setDataInstallazione(new Date(System.currentTimeMillis()));

		IDispositivo.insert(d);

	}

	//! Associazione Dispositivo ad Auto
	@RequestMapping(value = "/installazioneDispositivo", method = RequestMethod.POST)
	public void installazioneDispositivo(@RequestParam("idDispositivo") int idDispositivo, @RequestParam("idAuto") int idAuto) {

		Dispositivo d = dispositivoRepository.findById(idDispositivo);

		d.setAuto(autoRepository.findById(idAuto));
		// in fase di installazione dispositivo inserirsco la data di installazione
		d.setDataInstallazione(new Date(System.currentTimeMillis()));


		//  Faccio solo aggiornamento senza bisogno di cancellare e reinserire 
		//	dispositivoRepository.delete(d);
		dispositivoRepository.save(d);

	}


	//?! Accettazione/Rifiuto preventivo da parte di cliente
	@RequestMapping(value = "/accettapreventivo", method = RequestMethod.POST)
	public void accettapreventivo( @RequestParam("stato") String stato, @RequestParam("idprev") String idprev)
	{

		Preventivo p = preventivoRepository.findById(Integer.parseInt(idprev));
		p.setStato(Integer.parseInt(stato));

		preventivoRepository.save(p);
	}



	//! Lista Auto Officina
	@RequestMapping(value = "/autoSenzaDispositivo", method = RequestMethod.POST)
	public GenericResponse<List<Auto>> getAutoSenzaDisp(@RequestParam("id") int idOfficina) {

		List<Auto> listaAuto = autoRepository.findByOfficina(officinaRepository.findById(idOfficina));

		List<Dispositivo> listaDispositiviOfficina = listaDispositiviOfficina(idOfficina).getData();

		List<Auto> listaAutoConDisp = new ArrayList();
		for(int i = 0; i<listaDispositiviOfficina.size(); i++) if(!(listaDispositiviOfficina.get(i).getAuto() == null))listaAutoConDisp.add(listaDispositiviOfficina.get(i).getAuto());

		for (int i=0; i<listaAuto.size(); i++) {
			for(int e = 0; e<listaAutoConDisp.size(); e++) if(listaAuto.get(i).equals(listaAutoConDisp.get(e))) listaAuto.remove(listaAuto.get(i));
		}

		return new GenericResponse<List<Auto>>(listaAuto);
	}

	//! LISTA TICKET OFFICINA
	@RequestMapping(value = "/ticketOfficina", method = RequestMethod.POST)
	public GenericResponse<List<TicketDTO>> getTicketOfficina(@RequestParam("id") int idOfficina) {
		List<TicketDTO> listaTicketDTO = new ArrayList<TicketDTO>();
		List<Ticket> listaTicket =  ticketRepository.findByOfficina(officinaRepository.findById(idOfficina));
		for (int i=0; i<listaTicket.size(); i++) {
			List<MessaggioTicket> listaMessaggi = messaggioTicketRepository.findByTicket(listaTicket.get(i));
			listaTicketDTO.add( new TicketDTO(listaTicket.get(i),listaMessaggi));
		}


		return new GenericResponse<List<TicketDTO>>(listaTicketDTO);
	}



}


