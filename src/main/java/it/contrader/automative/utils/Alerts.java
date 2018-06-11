package it.contrader.automative.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Noleggio;

public class Alerts {
	
	//Ritorna anche le scadute
	public static List<AutoScadenze> listaAutoInScadenza(List<Auto> listaAuto){
		
		List<AutoScadenze> lista = new ArrayList();
		List<AutoScadenze> listaInScadenza = new ArrayList();
		
		lista = controlloScadenze(listaAuto);
		
		for(int i = 0; i<lista.size(); i++) if(lista.get(i).scadenzePendenti()) listaInScadenza.add(lista.get(i));
		
		return listaInScadenza;
	}
	
	private static List<AutoScadenze> controlloScadenze(List<Auto> listaAuto){
		
		List<AutoScadenze> listaConScadenze = new ArrayList();
		
		for(int i=0; i<listaAuto.size(); i++) {
			
			int bollo = giorniAllaScadenza(listaAuto.get(i).getScadenzaBollo());
			int assicurazione = giorniAllaScadenza(listaAuto.get(i).getScadenzaAssicurazione());
			int revisione = giorniAllaScadenza(listaAuto.get(i).getScadenzaRevisione());
			int tagliando = giorniAllaScadenza(listaAuto.get(i).getScadenzaTagliando());
			
			listaConScadenze.add(new AutoScadenze(listaAuto.get(i), bollo, assicurazione, tagliando, revisione));
			}
		
		return listaConScadenze;
	} 
	
	//ritona il numero di giorni rimanenti se manca meno di 1 mese, altrimenti ritorna -1, in caso di scaduta ritorna 0
	private static int giorniAllaScadenza(Date d) {
		
		if(d.before(new Date(System.currentTimeMillis()))) return 0;
		
		DiffDate tempoRimanente = Differences.diffDates(Calendar.getInstance(), d);
		
		if((tempoRimanente.getYears() == 0) && (tempoRimanente.getMonths()==0)) return tempoRimanente.getDays();
		
		return -1;	//non in scadenza
	}
	

	public static void prova(List<Auto> listaAuto) {
		
		//Mi recupero TUTTE e SOLE le auto con date in SCADENZA o che scadono tra MENO di 1 MESE...vedi la classe "AutoScadenze" per dettagli
		List<AutoScadenze> lista = listaAutoInScadenza(listaAuto);
		
		System.out.println();
		System.out.println();
		
		if(lista.size() == 0) System.out.println("Nessuna auto in scadenza");
		else for(int i = 0; i<lista.size(); i++) System.out.println("Auto in scadenza: "+lista.get(i).getAuto().getMarca()+ " Sta scadendo: "+ lista.get(i).cosaStaPerScadere().get(0));
		
		System.out.println();
		System.out.println();
	}

	public static List<Noleggio> kmNoleggioInScadenza(List<Noleggio> listaNoleggio){
		
		List<Noleggio> lista = new ArrayList();
		
		//Metto in lista tutti i noleggio dove rimangono da percorrere solo 1/10 dei km a propria disposizione
		for(int i=0; i<listaNoleggio.size(); i++) {
			int kmFatti = listaNoleggio.get(i).getAuto().getKmAttuali() - listaNoleggio.get(i).getAuto().getKmInizioNoleggio();
			if(kmFatti > ((listaNoleggio.get(i).getMaxKmNoleggio()/10)*9)) lista.add(listaNoleggio.get(i)); 
				}
		
		return lista;
		
	}
	
	
	
	public static void prova1(List<Noleggio> lista) {
		
		System.out.println();
		System.out.println();
		
		if(lista.size() == 0) System.out.println("Nessuna auto in con Km in esaurimento");
		else for(int i = 0; i<lista.size(); i++) System.out.println("Auto con Km in esaurimento: "+lista.get(i).getAuto().getMarca());
		
		System.out.println();
		System.out.println();
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
