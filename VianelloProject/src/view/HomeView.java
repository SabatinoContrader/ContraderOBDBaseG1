package view;

import model.Utente;

public class HomeView {

	public static void runHomeView (Utente user){
		
		VistaCliente vc = new VistaCliente();
		VistaGarageAdmin vg = new VistaGarageAdmin();

		switch(user.getRuolo()){
		case 1:
			vg.runVistaCliente(user);
			break;
		case 0: 
			vc.runVistaCliente(user);
			break;
		}
	}
}
