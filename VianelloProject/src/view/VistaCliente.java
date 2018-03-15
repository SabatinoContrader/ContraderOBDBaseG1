package view;

import controller.ControllerSingleton;
import model.Utente;

public class VistaCliente {
	
	
	
	public void runVistaCliente(Utente u) {
		
		
		
	}

	private void showAlerts(Utente u){
		
		ControllerSingleton.getIstance().showAlerts(u);
		
		
	}
	
	private void showCarList(Utente u) {
		
		ControllerSingleton.getIstance().showCarList(u);
		
	}
	
}
