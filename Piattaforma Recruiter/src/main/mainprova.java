package main;

import java.util.List;



public class mainprova
{

	public static void main (String[] args) 
	{
		
		List<Utente> lista = UtenteDAO.ritornaTuttiUtenti();
		
		for(int i = 0; i < lista.size(); i++) 
		{
			System.out.println("Tupla "+i+": "+lista.get(i).getId()+" "+lista.get(i).getUsername()+" "+lista.get(i).getPassword());
		}
			
	List<Candidati> list = CandidatiDAO.ritornaTuttiCandidati();
		
		for(int i = 0; i < list.size(); i++)
			{
				System.out.println("Tupla "+i+": "+list.get(i).getNome()+" "+list.get(i).getCognome());
			}
		
		List<Tabella> liste = TabellaDao.ritornaTuttiTabella();
	
	for(int i = 0; i < liste.size(); i++) System.out.println("Tupla 1: "+liste.get(i).getID()+" "+liste.get(i).getUsername()+" "+liste.get(i).getPassword());

	}


}
