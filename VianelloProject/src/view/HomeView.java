package view;

import java.sql.Date;
import java.util.Scanner;
import controller.ControllerImpl;
import model.Utente;
import dao.CarDAO;

import static dao.CarDAO.insertAutoUtente;
import static dao.CarDAO.removeAuto;

public class HomeView {


	public static void runHomeView (Utente user){


	/*	ControllerImpl ci = new ControllerImpl();
		ci.
*/
	/*	Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
	insertAutoUtente(1,0,"fiat","panda","aia","aioghiue",8391,8409, date,date,date,date,0,0);
*/
	//removeAuto(10);
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
