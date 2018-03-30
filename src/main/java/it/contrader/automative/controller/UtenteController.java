package it.contrader.automative.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Guasto;
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Utente;
import it.contrader.automative.repositories.AutoRepository;
import it.contrader.automative.repositories.DispositivoRepository;
import it.contrader.automative.repositories.GuastoRepository;
import it.contrader.automative.repositories.NoleggioRepository;
import it.contrader.automative.repositories.UtenteRepository;
import it.contrader.automative.serviceInterfaces.INoleggio;
import it.contrader.automative.serviceInterfaces.IUtente;


@Controller
//@RequestMapping("/login")
public class UtenteController {

	 private IUtente IUtente;
	 private AutoRepository autoRepository;
	 private NoleggioRepository noleggioRepository;
	 private DispositivoRepository dispositivoRepository;
	 private GuastoRepository guastoRepository;
	 
	 @Autowired
	    public UtenteController(IUtente IUtente, AutoRepository autoRepository, NoleggioRepository noleggioRepository, DispositivoRepository dispositivoRepository, GuastoRepository guastoRepository) {
	        this.IUtente = IUtente;
	        this.autoRepository = autoRepository;
	        this.noleggioRepository = noleggioRepository;
	        this.dispositivoRepository = dispositivoRepository;
	        this.guastoRepository = guastoRepository;
	    }
	
	
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String getUser(@RequestParam("email") String email, @RequestParam("pwd") String password, Model model){
	        Utente u = IUtente.selectByEmail(email);
	        if(u!=null && u.getPassword().equals(password)) {
	        	
	        	//Ritorno dati sull'utente che si è loggato
	        	model.addAttribute("utente", u);
	        	int guasti=0;
	        	switch (u.getRuolo()) {
	        	case 0 :
	        		//Ritorno I Noleggi del Cliente: dati sul noleggio + Auto
	        		List<Noleggio> listaNoleggiUtente = noleggioRepository.findByUtente(u);
	        		model.addAttribute("autoUtente", listaNoleggiUtente);
	        		
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
	        		model.addAttribute("guasti", guasti);
	        		model.addAttribute("AlertsGuasti", listaGuasti);
	        		return "utente_home";
	        		//return "logInEffettuato";
				case 1 : 
					//Auto dell'Officina
	        		List<Auto> listaAutoOfficina = autoRepository.findByOfficina(u.getOfficina());
	        		model.addAttribute("autoOfficina", listaAutoOfficina);
	        		
	        		//Ritorno guasti: auto, dispositivo, tipol. guasto, dati telematrici, data --> delle auto dell'officina loggata (Non risolti)
	        		List<Guasto> listaGuastiAutoOff = new ArrayList();
	        		for(int i = 0; i<listaAutoOfficina.size(); i++) {
	        			List<Guasto> g = guastoRepository.findByDispositivo(dispositivoRepository.findByAuto(listaAutoOfficina.get(i)));
	        			for(int e=0; e<g.size(); e++) if(!g.get(e).getStatoRisoluzione().equals("Risolto")) listaGuastiAutoOff.add(g.get(e));
	        		}
	        		model.addAttribute("AlertsGuastiOfficina", listaGuastiAutoOff);
	        		
	        		return "logInEffettuatoOfficina";
	        	}
	        	
	            return "logInEffettuato";
	        }else
	            return "logInFallito";
	    }
	
	
}
