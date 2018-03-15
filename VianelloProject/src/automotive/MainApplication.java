package automotive;

import controller.ControllerSingleton;
import dao.ConnessioneDB;
import dao.GestioneUtenteDAO;
import model.Utente;
import utility.Utility;
import view.HomeView;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Test Registrazione
		//GestioneUtenteDAO.signUp();
		
		//Test Registrazione Azienda
		//ControllerSingleton.getIstance().signUpAziende();
		
		String email;
		String password;
		
		Utente o = null;
			
		System.out.println("Benvenuto...\n");
		
		System.out.println("Log In...");
		
		
		while(o == null) {
			
			System.out.println();
			
			System.out.println("Email:");
			email = Utility.getInput();
			
			System.out.println("Password:");
			password = Utility.getInput();
			
			System.out.println("Accesso in Corso...");
			
			 o =  GestioneUtenteDAO.logIn(email, password);
			
		}
		
		
		
		for(int i = 0; i < o.getAuto().size(); i ++) System.out.println(o.getAuto().get(i).getID());
	
		
		boolean exit = false;
		
		HomeView.runHomeView(o);
		
		while(!exit) {
			System.out.println("1) Torna alla Home");
			System.out.println("9) Esci");
			
			String scelta = Utility.getInput();
			System.out.println(scelta);
			if(scelta.equals("1")) HomeView.runHomeView(o);
			else if (scelta.equals("9")) exit = true;
		}
		
		
		
		
		
		
		
		ConnessioneDB.closeConnection();
		
	}

	
}
