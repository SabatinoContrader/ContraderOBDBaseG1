package view;

import controller.ControllerSingleton;
import model.Utente;
import utility.Utility;

public class VistaGarageAdmin {


    public void runVistaCliente(Utente user) {
        //this is an admin;
        System.out.println("BENVENUTO " + user.getNome());
        System.out.println("//////MENU ADMIN OFFICINA\\\\\\");
        showAlertsKm(user);
        System.out.println("SELEZIONA UN'OPZIONE");
        System.out.println("1) VISUALIZZA AUTO CON GUASTI");
        System.out.println("2) VISUALIZZA LISTA UTENTI");
        System.out.println("3) VISUALIZZA LISTA AUTO DELL'AZIENDA");
        System.out.println("4) VISUALIZZA TUTTI I DISPOSITIVI");
		System.out.println("5) VISUALIZZA AUTO CON REVISIONE IN SCADENZA");
        System.out.println("6) AGGIUNGI NUOVA AUTO DELL'AZIENDA");
        System.out.println("7) TORNA INDIETRO");


        String opzioneSelezionata = Utility.getInput();
        switch (opzioneSelezionata) {
            case "1":
            	Utility.clearConsole();
                showAlerts(user);
                break;
            case "2":
                showUserList(user);
                break;
            case "3":
                showCarList(user);
                break;
            case "4":
                showAllDevice(user);
                break;
    		case "5":Utility.clearConsole();
    		alertsRevisioneGarageAdmin(user);
    		break;
            case "6": addAutoAzienda(user.getIdAzienda());
            case "7": Utility.clearConsole();
                    break;
            //default: Utility.clearConsole();
        }
    }

    private void showAlerts(Utente u) {
        ControllerSingleton.getIstance().showAlerts(u);
    }
    
    private void showAlertsKm(Utente u){
        ControllerSingleton.getIstance().showAlertsKm(u);
    }

    private void showCarList(Utente u) {
        ControllerSingleton.getIstance().showCarList(u);
    }
    private void showUserList(Utente u) { ControllerSingleton.getIstance().showUserList(u); }
    private void showAllDevice(Utente u) { ControllerSingleton.getIstance().showAllDevice(u); }
	private void alertsRevisioneGarageAdmin(Utente u){
		ControllerSingleton.getIstance().alertsRevisioneGarageAdmin(u);
	}
    private void addAutoAzienda(int idAzienda ){
        ControllerSingleton.getIstance().inserisciAutoAzienda(idAzienda);
    }

}
