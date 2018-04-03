package it.contrader.automative.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.automative.model.Appuntamento;
import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Guasto;
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Preventivo;
import it.contrader.automative.model.Utente;
import it.contrader.automative.repositories.AppuntamentoRepository;
import it.contrader.automative.repositories.AutoRepository;
import it.contrader.automative.repositories.DispositivoRepository;
import it.contrader.automative.repositories.GuastoRepository;
import it.contrader.automative.repositories.NoleggioRepository;
import it.contrader.automative.repositories.PreventivoRepository;
import it.contrader.automative.repositories.UtenteRepository;
import it.contrader.automative.serviceInterfaces.INoleggio;
import it.contrader.automative.serviceInterfaces.IUtente;

import it.contrader.automative.serviceInterfaces.IPreventivo;
import it.contrader.automative.serviceInterfaces.IAppuntamento;
import it.contrader.automative.utils.Alerts;
import it.contrader.automative.utils.AutoScadenze;



@Controller
//@RequestMapping("/login")
public class UtenteController {

	 private IUtente IUtente;
	 private IPreventivo IPreventivo;
	 private IAppuntamento IAppuntamento;
	 private AutoRepository autoRepository;
	 private NoleggioRepository noleggioRepository;
	 private DispositivoRepository dispositivoRepository;
	 private GuastoRepository guastoRepository;
	 private PreventivoRepository preventivoRepository;
	 private AppuntamentoRepository appuntamentoRepository;
	 private UtenteRepository utenteRepository;
	 
	 private INoleggio noleggioService;
	 
	 @Autowired
	    public UtenteController(IUtente IUtente, IPreventivo IPreventivo,IAppuntamento IAppuntamento, UtenteRepository utenteRepository ,AutoRepository autoRepository, NoleggioRepository noleggioRepository, DispositivoRepository dispositivoRepository, GuastoRepository guastoRepository, PreventivoRepository preventivoRepository, AppuntamentoRepository appuntamentoRepository, INoleggio noleggioService) {
	        this.IUtente = IUtente;
	        this.IPreventivo = IPreventivo;
	        this.IAppuntamento=IAppuntamento;
	        this.utenteRepository = utenteRepository;
	        this.autoRepository = autoRepository;
	        this.noleggioRepository = noleggioRepository;
	        this.dispositivoRepository = dispositivoRepository;
	        this.guastoRepository = guastoRepository;
	        this.preventivoRepository = preventivoRepository;
	        this.appuntamentoRepository = appuntamentoRepository;
	        
	        this.noleggioService = noleggioService;
	    }
	
	
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String getUser(@RequestParam("email") String email, @RequestParam("pwd") String password, Model model
	    		,HttpServletRequest request, HttpServletResponse response){
	        Utente u = IUtente.selectByEmail(email);
	        if(u!=null && u.getPassword().equals(password)) {
	        	 HttpSession session = request.getSession(true);
	        	//Ritorno dati sull'utente che si è loggato
	        	model.addAttribute("utente", u);
	        	int guasti=0;
	        	
	        	switch (u.getRuolo()) {
	        	case 0 :
	        		//Ritorno I Noleggi del Cliente: dati sul noleggio + Auto
	        		List<Noleggio> listaNoleggiUtente = noleggioRepository.findByUtente(u);
	        		model.addAttribute("autoUtente", listaNoleggiUtente);
	        		
	     //<Roba Nuova>   		
	        		//Mi ricavo la lista auto da lista noleggi
	        		List<Auto> listaAuto = new ArrayList();
	        		for (int i = 0; i<listaNoleggiUtente.size(); i++) listaAuto.add(listaNoleggiUtente.get(i).getAuto());
	        		
	        		//Prova con Scadenze (Spampa nella console le auto che stanno in scadenza e solo la prima scadenza che hanno)

	        		//Alerts.prova(listaAuto);
	        		// Recupero Auto che stanno in scadenza e cosa sta scadendo e li passo al model
	        		List<AutoScadenze> lista = Alerts.listaAutoInScadenza(listaAuto);
	        		model.addAttribute("autoScadenze",lista);
	        		
	        		
	        		//Ritorno lista dei noleggi con i km in scadenza
	        		List<Noleggio> listaKmInScadenza = Alerts.kmNoleggioInScadenza(listaNoleggiUtente);
	        		model.addAttribute("kmScadenza",listaKmInScadenza);
//	        		//Prendo solo i noleggio in corso - OPZIONALE
//	        		List<Noleggio> listaKmInScadNoleggiInCorso = new ArrayList();
//	        		for(int i=0; i<listaKmInScadenza.size(); i++) if(listaKmInScadenza.get(i).getDataFineNoleggio().after(new Date(System.currentTimeMillis()))) listaKmInScadNoleggiInCorso.add(listaKmInScadenza.get(i));
	        		

	     //</Roba Nuova>  		
	        		
	        		//Ritorno guasti: auto, dispositivo, tipol. guasto, dati telematrici, data --> delle auto dell'utente loggato (Non risolti)
	        		List<Guasto> listaGuasti = new ArrayList();
	        		for(int i = 0; i<listaNoleggiUtente.size(); i++) {
	        			List<Guasto> g = guastoRepository.findByDispositivo(dispositivoRepository.findByAuto(listaNoleggiUtente.get(i).getAuto()));

	        			for(int e=0; e<g.size(); e++) { 
	        				//if(!g.get(e).getStatoRisoluzione().equals("Risolto")) 
	        				if(!g.get(e).getStatoRisoluzione().equals("Risolto")) guasti++;
	        				listaGuasti.add(g.get(e));
	        				
	        			}
	        		}
	        		List<Preventivo> listaPreventivi = preventivoRepository.findByUtente(u);
	        		List<Appuntamento> listaAppuntamenti = appuntamentoRepository.findByUtente(u);
	        		//model.addAttribute("preventivi",listaPreventivi);
	        		model.addAttribute("guasti", guasti);
	        		model.addAttribute("AlertsGuasti", listaGuasti);
	        		session.setAttribute("appuntamenti", listaAppuntamenti);
	        		session.setAttribute("preventivi", listaPreventivi);
	        		session.setAttribute("sessionModel", model);

	        		return "utente_home";
	        		//return "logInEffettuato";

				case 1 : 
					//Auto dell'Officina
	        		List<Auto> listaAutoOfficina = autoRepository.findByOfficina(u.getOfficina());
	        		model.addAttribute("autoOfficina", listaAutoOfficina);
	        	
	      //<Roba Nuova> 
	        		//Prova con Scadenze (Spampa nella console le auto che stanno in scadenza e solo la prima scadenza che hanno)

	        		//Alerts.prova(listaAutoOfficina);
	        		List<AutoScadenze> listaOff = Alerts.listaAutoInScadenza(listaAutoOfficina);
	        		model.addAttribute("autoScadenze",listaOff);
	        		
	        		
	        		//Mi ricavo la lista dei noleggi dell'officina
	        		List<Noleggio> listaNoleggiOff = noleggioRepository.findByOfficina(u.getOfficina());
	        		model.addAttribute("listaNoleggi",listaNoleggiOff);
	        		
	        		//Ritorno lista dei noleggi con i km in scadenza
	        		List<Noleggio> listaKmInScadenzaAutoOfficina = Alerts.kmNoleggioInScadenza(listaNoleggiOff);
	        		model.addAttribute("kmScadenza",listaKmInScadenzaAutoOfficina);
	        		
	        		//Prova Recupero Lista Auto Disponibili al noleggio
	        		provaRecuperoListaAutoDisp(listaAutoOfficina, listaNoleggiOff, noleggioService);
	        
	      //</Roba Nuova>	
	        		
	        		//Ritorno guasti: auto, dispositivo, tipol. guasto, dati telematrici, data --> delle auto dell'officina loggata (Non risolti)
	        		List<Guasto> listaGuastiAutoOff = new ArrayList();
	        		for(int i = 0; i<listaAutoOfficina.size(); i++) {
	        			List<Guasto> g = guastoRepository.findByDispositivo(dispositivoRepository.findByAuto(listaAutoOfficina.get(i)));
	        			for(int e=0; e<g.size(); e++) {
	        				
	        				if(!g.get(e).getStatoRisoluzione().equals("Risolto"))guasti++;
	        				listaGuastiAutoOff.add(g.get(e));
	        				
	        			}
	        		}
	        		List<Preventivo> listaPreventiviOfficina = preventivoRepository.findByOfficina(u.getOfficina());
	        		List<Appuntamento> listaAppuntamentiOfficina = appuntamentoRepository.findByOfficina(u.getOfficina());
	        		List<Utente> listaUtenti = utenteRepository.findByOfficina(u.getOfficina());
	        		
	        		model.addAttribute("guasti", guasti);
	        		model.addAttribute("AlertsGuastiOfficina", listaGuastiAutoOff);
	        		model.addAttribute("listaUtenti",listaUtenti);
	        	
	        		session.setAttribute("appuntamenti", listaAppuntamentiOfficina);
	        		session.setAttribute("preventivi", listaPreventiviOfficina);
	        		session.setAttribute("sessionModel", model);
	        		return "home_officina";
	        	}
	        	
	            return "logInEffettuato";
	        }else
	            return "logInFallito";
	    }
	
	    
	    
	    @RequestMapping(value = "/inviapreventivo", method = RequestMethod.POST)
	    public String inviapreventivo(@RequestParam("email") String email,@RequestParam("dettagli") String dettagli
	    		,@RequestParam("idauto") String idauto,HttpServletRequest request, HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession(true);
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
	    	
	    	// Aggiungo nuovo preventivo alla lista salvata in sessione in modo da avere la lista aggiornata quando 
	    	// ritorna alla pagina
	    	 ((List<Preventivo>) session.getAttribute("preventivi")).add(p);
	    	return "utente_home";
	    	
	    	
	    	
	    }
	    
	    
	    
	    @RequestMapping(value = "/richiediappuntamento", method = RequestMethod.POST)
	    public String richiediappuntamento(@RequestParam("emailapp") String email,@RequestParam("dettagliapp") String dettagli
	    		,@RequestParam("ora") String ora,HttpServletRequest request, HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession(true);
	    	Utente u = IUtente.selectByEmail(email);
	    
	    	Officina o = u.getOfficina();
	    	
// create a java calendar instance
Calendar calendar = Calendar.getInstance();

// get a java date (java.util.Date) from the Calendar instance.
// this java date will represent the current date, or "now".
java.util.Date currentDate = calendar.getTime();

// now, create a java.sql.Date from the java.util.Date
java.sql.Date date = new java.sql.Date(currentDate.getTime());


	    	//Creazione nuovo appuntamento
Appuntamento a = new Appuntamento();
a.setUtente(u);
a.setOfficina(o);
a.setData(date);
a.setOra(ora);
a.setDettagli(dettagli);
a.setStato(0);
a.setRisposta("");
//	    	Appuntamento a = new Appuntamento(2,u,o,date,ora,dettagli,0,"");
	   // Inserimento appuntamento creato in database
	    	
	    	IAppuntamento.insert(a);
	    	
	    	// Aggiungo nuovo appuntamento alla lista salvata in sessione in modo da avere la lista aggiornata quando 
	    	// ritorna alla pagina
	    	 ((List<Appuntamento>) session.getAttribute("appuntamenti")).add(a);
	    	return "utente_home";
	    	
	    	
	    	
	    }
	   
	    
	    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public String logout(HttpServletRequest request, HttpServletResponse response){
	 
	        	 HttpSession session = request.getSession(true);
	        	 session.invalidate();
				return "index";
	        	 
	        	 
	        }
	    
	    
	    @RequestMapping(value = "/rispondipreventivo", method = RequestMethod.POST)
	    public String rispondipreventivo(@RequestParam("email") String email,@RequestParam("dettagli") String dettagli
	    		,@RequestParam("costoprev") String costoprev,@RequestParam("idprev") String idprev,HttpServletRequest request, HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession(true);
	    	Utente u = IUtente.selectByEmail(email);
	    	
	    	Officina o = u.getOfficina();
	    	Preventivo p = preventivoRepository.findById(Integer.parseInt(idprev));
	    	p.setStato(1);
	        p.setCosto(Float.parseFloat(costoprev));
	        p.setRisposta(dettagli);
	        
	        preventivoRepository.save(p);
	    	// Aggiungo nuovo preventivo alla lista salvata in sessione in modo da avere la lista aggiornata quando 
	    	// ritorna alla pagina
	    	 ((List<Preventivo>) session.getAttribute("preventivi")).add(p);
	    	return "home_officina";
	    	
	    	
	    	
	    }
	    
	    @RequestMapping(value = "/rispondiappuntamento", method = RequestMethod.POST)
	    public String rispondiappuntamento(@RequestParam("emailapp") String email,@RequestParam("dettagliapp") String dettagli
	    		,@RequestParam("idapp") String idapp,@RequestParam("selectapp") String stato,HttpServletRequest request, HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession(true);
	    	Utente u = IUtente.selectByEmail(email);
	    	
	    	Officina o = u.getOfficina();
	    	Appuntamento a = appuntamentoRepository.findById(Integer.parseInt(idapp));
	    	
	        a.setStato(Integer.parseInt(stato));
	        a.setRisposta(dettagli);
	        
	        appuntamentoRepository.save(a);
	    	// Aggiungo nuovo appuntamento alla lista salvata in sessione in modo da avere la lista aggiornata quando 
	    	// ritorna alla pagina
	    	 ((List<Appuntamento>) session.getAttribute("appuntamenti")).add(a);
	    	return "home_officina";
	    		    	
	    }
	    
	    @RequestMapping(value = "/setrisoltoguasto", method = RequestMethod.POST)
	    public String setrisoltoguasto(@RequestParam("idguasto") String idguasto,HttpServletRequest request, HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession(true);
	    Guasto g = guastoRepository.findById(Integer.parseInt(idguasto));
	    	
	        g.setStatoRisoluzione("Risolto");
	       
	        
	        guastoRepository.save(g);
	    	
	    	return "home_officina";
	    	
	    	
	    	
	    }
	    
	    @RequestMapping(value = "/listaautoutente", method = RequestMethod.GET)
	    public String listaautoutente(@RequestParam("id") String id,Model model){
	    		model.addAttribute(id);
	    		Utente u = utenteRepository.findById(Integer.parseInt(id));
	        	List<Noleggio> n = noleggioRepository.findByUtente(u);
	        	model.addAttribute("listaNoleggio",n);
				return "lista_auto_utente";
	        	 
	        	 
	        }
	    
	    private void provaRecuperoListaAutoDisp(List<Auto> auto, List<Noleggio> noleggi, INoleggio servizioNoleggio) {
	    	
	    	List<Auto> lista = servizioNoleggio.autoNonPrenotate(noleggi, auto);
	    	
	    	System.out.println();
	    	System.out.println();
	    	
	    	for(int i = 0; i<lista.size(); i++) System.out.println("Id Auto: "+lista.get(i).getId()+" Auto di marca: " + lista.get(i).getMarca());
	    	
	    	System.out.println();
	    	System.out.println();
	    }
	    
}
	

