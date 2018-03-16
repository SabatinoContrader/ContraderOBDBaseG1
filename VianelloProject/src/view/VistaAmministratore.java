package view;

import java.io.IOException;

import model.Utente;
import utility.Utility;

public class VistaAmministratore {

	public static void runVistaCliente(Utente user) {
		
		System.out.println("Sono Amministratore del Sistema (DIO)");
		
		try {
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			System.out.println("Fallito Clear Screen!");
		}
		
	}
	
}
