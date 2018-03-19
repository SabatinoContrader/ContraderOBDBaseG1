package controller;

import model.Utente;

public interface IController {
 
	public void showAlerts(Utente u);
	
	public void showAlertsKm(Utente u);
	
	public void alertsScadenzaRevisione(Utente u);
	
	public void showCarList(Utente u);

	public void showUserList(Utente u);
	
	public void showAllDevice(Utente u);
	
	public void signUpAziende();
	
	public void signUpUser();
	
	public void alertsRevisioneGarageAdmin(Utente u);
} 
 