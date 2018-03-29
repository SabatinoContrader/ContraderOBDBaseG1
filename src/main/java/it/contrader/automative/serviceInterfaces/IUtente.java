package it.contrader.automative.serviceInterfaces;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Utente;


public interface IUtente {

	Utente selectByEmail(String email);
	
//    UserDTO getUser(String userEmail);
	
	Utente insert(Utente utente);
	
}
