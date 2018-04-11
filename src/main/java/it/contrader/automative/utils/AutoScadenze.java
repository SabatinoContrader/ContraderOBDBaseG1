package it.contrader.automative.utils;

import java.util.ArrayList;
import java.util.List;

import it.contrader.automative.model.Auto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class AutoScadenze {

	private Auto auto;
	
	private int giorniScadenzaBollo;
	private int giorniScadenzaAssicurazione;
	private int giorniScadenzaTagliando;
	private int giorniScadenzaRevisione;
	
	//Mi chiedo se c'è qualcosa in scadenza oppure di già scaduto per l'auto in questione
	public boolean scadenzePendenti() {
		if(giorniScadenzaBollo >= 0) return true;
		if(giorniScadenzaAssicurazione >= 0) return true;
		if(giorniScadenzaTagliando >= 0) return true;
		if(giorniScadenzaRevisione >= 0) return true;
		
		return false;
	}
	
	//Roba che scade fra meno di 1 mese
	public List<String> cosaStaPerScadere(){
		
		List<String> lista = new ArrayList();
		
		if(giorniScadenzaBollo > 0) lista.add("Bollo");
		if(giorniScadenzaAssicurazione > 0) lista.add("Assicurazione");
		if(giorniScadenzaTagliando > 0) lista.add("Tagliando");
		if(giorniScadenzaRevisione > 0) lista.add("Revisione");
		
		return lista;
	}
	
	//Roba scaduta
	public List<String> cosaEScaduto(){
		
		List<String> lista = new ArrayList();
		
		if(giorniScadenzaBollo == 0) lista.add("Bollo");
		if(giorniScadenzaAssicurazione == 0) lista.add("Assicurazione");
		if(giorniScadenzaTagliando == 0) lista.add("Tagliando");
		if(giorniScadenzaRevisione == 0) lista.add("Revisione");
		
		return lista;
	}
}
