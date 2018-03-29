package it.contrader.automative.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.automative.model.Utente;
import it.contrader.automative.serviceInterfaces.IUtente;


@Controller
//@RequestMapping("/login")
public class UtenteController {

	 private IUtente IUtente;
	 
	 @Autowired
	    public UtenteController(IUtente IUtente) {
	        this.IUtente = IUtente;
	    }
	
	
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String getUser(@RequestParam("email") String email, @RequestParam("pwd") String password){
	        Utente u = IUtente.selectByEmail(email);
	        if(u!=null && u.getPassword().equals(password))
	            return "logInEffettuato";
	        else
	            return "logInFallito";
	    }
	
	
}
