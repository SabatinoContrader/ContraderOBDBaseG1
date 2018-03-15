package view;

import controller.ControllerSingleton;
import model.Utente;

public class VistaCliente {
	
	public void runVistaCliente(Utente user) {
		//this is A user;
		System.out.println("SEI LOGGATO COME USER:"+"\n" +user.getNome().toUpperCase());
		System.out.println();
		showAlerts(user);
		System.out.println();
		System.out.println("//////DRIVER MENU\\\\\\");
	}

	private void showAlerts(Utente u){
		ControllerSingleton.getIstance().showAlerts(u);
	}
	
	private void showCarList(Utente u) {
		
		ControllerSingleton.getIstance().showCarList(u);
		
	}
	
}
