package com.project.gestore;

import com.project.model.Azienda;
import com.project.model.Utente;

public interface IController {
 
	public void showAlerts(Utente u);
	
	public void showAlertsKm(Utente u);

	public void alertsScadenzaRevisione(Utente u);
	
	public void showCarList(Utente u);

	public void showUserList(Utente u);
	
	public void showAllDevice(Utente u);
	
	public boolean signUpAziende(Azienda a);
	
	public boolean signUpUser(String nome, String cognome, String email, String password, String telefono, int idAzienda);
	
	public void alertsRevisioneGarageAdmin(Utente u);

	public void inserisciAutoAzienda(int idAzienda);

	public void showAllAlertsKm(Utente u);

} 
 