package view;

import controller.ControllerSingleton;
import model.Utente;
import utility.Utility;

public class VistaCliente {

	public void runVistaCliente(Utente user) {
		//this is A user;
		System.out.println("SEI LOGGATO COME USER:"+"\n" +user.getNome().toUpperCase());
		System.out.println();
		showAlertsKm(user);
		showAlerts(user);
		System.out.println("//////DRIVER MENU\\\\\\");
		System.out.println("SELEZIONA UN'OPZIONE");

		System.out.println("1) VISUALIZZA LISTA AUTO");
		System.out.println("2) VISUALIZZA SCADENZA REVISIONE");
		System.out.println("3) BACK");
		String opzioneSelezionata = Utility.getInput();
		switch (opzioneSelezionata) {
		case "1":
			Utility.clearConsole();
			showCarList(user);
			break;
		case "2":
			alertsScadenzaRevisione(user);
		break;
		case "3": 
			Utility.clearConsole();
			break;


		}
	}

	private void showAlerts(Utente u){
		ControllerSingleton.getIstance().showAlerts(u);
	}
	private void showAlertsKm(Utente u){
		ControllerSingleton.getIstance().showAlertsKm(u);
	}

	private void showCarList(Utente u) {
		ControllerSingleton.getIstance().showCarList(u);
	}
	public void alertsScadenzaRevisione(Utente u){
		ControllerSingleton.getIstance().alertsScadenzaRevisione(u);
	}


}
