package main;

import java.util.List;

public class CandidatiDAO {

   private final String QUERY_ALL = "select * from candidati";
   private final String QUERY_INSERT = "insert into candidati (nome, cognome, codice_fiscale, indirizzo, email, telefono) values (?,?,?)";

	
   public CandidatiDAO() {
	
}


public static List<Candidati> ritornaTuttiCandidati() {
	// TODO Auto-generated method stub
	return null;
}

	
   
	
}
