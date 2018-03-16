package view;

import java.io.IOException;

import controller.ControllerSingleton;
import model.Utente;
import utility.Utility;

public class VistaAmministratore {

	public static void runVistaCliente(Utente user) throws IOException {

		Utility.clearConsole();

		System.out.println("SEI LOGGATO COME ADMIN DEL SISTEMA:" + user.getNome());
		System.out.println("//////SYSTEM ADMIN - MENU\\\\\\");
		System.out.println("SELEZIONA UN'OPZIONE");
		System.out.println("1) REGISTRA UTENTE");
		System.out.println("2) REGISTRA AZIENDA");
		System.out.println();
		System.out.println("9) INDIETRO");


		String opzioneSelezionata = Utility.getInput();
		switch (opzioneSelezionata) {
		case "1":
			Utility.clearConsole(); ControllerSingleton.getIstance().signUpUser();
			break;
		case "2":
			Utility.clearConsole(); ControllerSingleton.getIstance().signUpAziende();
			break;
		case "3": Utility.clearConsole();

		}
	}
}
