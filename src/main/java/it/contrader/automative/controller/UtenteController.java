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
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Utente;
import it.contrader.automative.repositories.AutoRepository;
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
	 
	 @Autowired
	    public UtenteController(IUtente IUtente, AutoRepository autoRepository, NoleggioRepository noleggioRepository) {
	        this.IUtente = IUtente;
	        this.autoRepository = autoRepository;
	        this.noleggioRepository = noleggioRepository;
	    }
	
	
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String getUser(@RequestParam("email") String email, @RequestParam("pwd") String password, Model model){
	        Utente u = IUtente.selectByEmail(email);
	        if(u!=null && u.getPassword().equals(password)) {
	        	model.addAttribute("utente", u);
	        	
	        	switch (u.getRuolo()) {
	        	case 0 :
	        		List<Noleggio> listaNoleggiUtente = noleggioRepository.findByUtente(u);
	        		model.addAttribute("autoUtente", listaNoleggiUtente);
	        		break;
	        		
	        	case 1 : 
	        		break;
	        	}
	        	
	            return "logInEffettuato";
	        }else
	            return "logInFallito";
	    }
	
	
}
