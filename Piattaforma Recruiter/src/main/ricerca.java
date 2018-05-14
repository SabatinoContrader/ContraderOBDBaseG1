package main;

import java.util.Scanner;

public class ricerca {

public static Candidati Ricerca () {
	
	System.out.println("RICERCA CANDIDATO");
	
	  Scanner input1 = new Scanner(System.in);
	    System.out.println("Inserisci Nome : ");
	    
	    String nome = input1.next();

	   Candidati cand = new Candidati();
	    cand = ricercaquery.ricerca(nome);
	    
	    if(cand != null) {
	    	
	    	System.out.println(cand.getNome()+" "+cand.getCognome()+" -  "+cand.getIndirizzo()+" -  "+cand.getTelefono()+" -  "+cand.getEmail());
	    	
    	}
	    else System.out.println("Non esiste nessun candidato con questo nome");
	    
	    return cand;
}

	
	
	
}
