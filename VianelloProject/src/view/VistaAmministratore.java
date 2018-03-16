package view;

import java.io.Console;
import java.io.IOException;
import java.util.logging.ConsoleHandler;

import model.Utente;
import utility.Utility;

public class VistaAmministratore {

	public static void runVistaCliente(Utente user) throws IOException {
		
		Utility.clearConsole();
		
		System.out.println("Sono Amministratore del Sistema (DIO)");
		
	}
	
}
