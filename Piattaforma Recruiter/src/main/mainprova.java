package main;

import java.util.List;
import java.util.Scanner;



public class mainprova

{

	public static void main (String[] args) 
	{
		
		boolean loggato = false;
		
		while(!loggato) if(Login.login() != null) loggato = true;
		
		
		while(true) {
			
			System.out.println("Premi 1 per la lista degli utenti");
			System.out.println("Premi 2 per la lista dei candidati ");
			System.out.println("Premi 3 per cercare un candidato");
			Scanner input = new Scanner(System.in);
			
			
			
			switch(input.nextInt()) {
			
			case 1 : stampaUtenti();
			break;
			
			case 2 : stampaCandidati();
			break;		
			
			case 3 : ricerca.Ricerca();
			}
		}
	
	}
	private static void stampaUtenti() {
		
		List<Utente> lista = UtenteDAO.ritornaTuttiUtenti();
		
		System.out.println("Lista Utenti");
		for(int i = 0; i < lista.size(); i++) 
		{
			System.out.println("Utente "+i+": ID "+lista.get(i).getId()+" - Nome: "+lista.get(i).getNome()+" - Cognome: "+lista.get(i).getCognome()+" - Posizione: "+lista.get(i).getPosizione() );
		}
		
		
	}
	
	
	private static void stampaCandidati() {
		System.out.println("Lista Candidati");
		
		List<Candidati> list = CandidatiDAO.ritornaTuttiCandidati();
			
			for(int i = 0; i < list.size(); i++)
				{
					System.out.println("Candidato "+i+": Nome: "+list.get(i).getNome()+" - Cognome: "+list.get(i).getCognome()+" - Indirizzo: "+list.get(i).getIndirizzo()+" - Email: "+list.get(i).getTelefono()+" - Tel. "+list.get(i).getEmail());
			}
	
			
				
				
				
	
	
	
	}
	

}
