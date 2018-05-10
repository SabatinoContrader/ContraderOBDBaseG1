package main;

import java.sql.SQLException;
import java.util.List;



public class mainprova {

	public static void main (String[] args) throws SQLException {
		
		List<Utente> lista = UtenteDAO.ritornaTuttiUtenti();
		
		for(int i = 0; i < lista.size(); i++) System.out.println("Tupla "+i+": "+lista.get(i).getId()+" "+lista.get(i).getUsername()+" "+lista.get(i).getPassword());
		
		
		List<Candidati> list = CandidatiDAO.ritornaTuttiCandidati();
		
		for(int i = 0; i < list.size(); i++) System.out.println("Tupla "+i+": "+list.get(i).getNome()+" "+list.get(i).getCognome());
		


	}

	
}
