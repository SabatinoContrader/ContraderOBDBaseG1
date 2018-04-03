package it.contrader.automative.serviceInterfaces;

import java.util.ArrayList;
import java.util.List;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Noleggio;

public interface INoleggio {

	Noleggio insert(Noleggio noleggio);
	
	List<Auto> autoNonPrenotate(List<Noleggio> noleggiOfficina, List<Auto> autoOfficina);
}
