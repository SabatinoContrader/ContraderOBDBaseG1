package view;

import controller.ControllerSingleton;
import model.Utente;
import utility.Utility;

public class VistaGarageAdmin {

		public void runVistaCliente(Utente user) {
			//this is an admin;
			System.out.println("SEI LOGGATO COME ADMIN:" +user.getNome());
			System.out.println("//////ADMIN MENU\\\\\\");
			System.out.println("1) VISUALIZZA AUTO CON GUASTI");
			String opzioneSelezionata = Utility.getInput();
			switch(opzioneSelezionata){
			case "1": 
				showAlerts(user);
				break;
			}
		}

		private void showAlerts(Utente u){
			ControllerSingleton.getIstance().showAlerts(u);
		}
		
		private void showCarList(Utente u) {
			
			ControllerSingleton.getIstance().showCarList(u);
			
		}
}
