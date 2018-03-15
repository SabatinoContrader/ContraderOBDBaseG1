package view;

import java.util.Scanner;
import controller.ControllerImpl;
import model.Utente;

public class HomeView {


	public static void runHomeView (Utente user){


		/*ControllerImpl ci = new ControllerImpl();
		ci.showCarList(user);
*/
		switch(user.getRuolo()){
		case 1:
			//System.out.println("CIAO UTENTE DIMMERDA DI MERDA");

			//this is an admin;
			break;
		case 0: 
//			ArrayList<Guasto>guasti = getAlertsUser(user.getEmail());
//			//this is a driver;
//			if(guasti.size()>0){
//				//CI SONO ASSAI ALLERTS MOSTRIAMOLI TOP TOP TOP
//				System.out.println("-----------------");
//				for(Guasto guasto: guasti){
//					System.out.println("Attenzione");
//				}
//			}
			System.out.println("CIAO UTENTE DIMMERDA");
			break;
		}
	}

	public String getInput () {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
