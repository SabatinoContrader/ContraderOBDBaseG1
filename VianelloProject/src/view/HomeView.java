package view;


import java.io.IOException;

import model.Utente;
import utility.Utility;


public class HomeView {

	public static void runHomeView (Utente user) {
		
		VistaCliente vc = new VistaCliente();
		VistaGarageAdmin vg = new VistaGarageAdmin();


		switch(user.getRuolo()){
		case 1:
			Utility.clearConsole();
			vg.runVistaCliente(user);
			break;
		case 0: 
			Utility.clearConsole();
			vc.runVistaCliente(user);
			break;
		case 2:
			try {
				VistaAmministratore.runVistaCliente(user);
			} catch (IOException e) {
				System.out.println("Errore di I-O");
			}
			break;
		}
	}
}
