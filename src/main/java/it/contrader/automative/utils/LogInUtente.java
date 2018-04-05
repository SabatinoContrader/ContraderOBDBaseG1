package it.contrader.automative.utils;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import it.contrader.automative.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LogInUtente implements Serializable {

	private int ruolo;				//0: Cliente; 1: Officina
	
	private Utente utente;	
	
	private List<Noleggio> listaNoleggi;			//se è un Cliente ci saranno le sue auto altrimenti solo i noleggi dell'officina
	private List<AutoScadenze> autoScadenze;
	private List<Noleggio> listaKmInScadenza;
	
	private List<Guasto> listaGuasto;
	private int numGuastiNonRisolti;
	
	private List<Appuntamento> listaAppuntamenti;
	private List<Preventivo> listaPreventivi;
	
	private List<Auto> listaAutoOfficina;
	private List<Utente> listaClientiOfficina;
	
}
