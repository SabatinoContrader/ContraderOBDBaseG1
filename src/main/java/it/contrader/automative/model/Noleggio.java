package it.contrader.automative.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "noleggio")
public class Noleggio implements Serializable{

	@Id
	private int IdUtente;
	
	@Id
	private int IdAuto;
	
	@Column
	private Date DataInizioNoleggio;
	
	@Column
	private Date DataFineNoleggio;
	
	@Column
	private int CapLuogoDiRitiro;
	
	@Column
	private int CapLuogoDiRiconsegna;
	
	@Column
	private int MaxKmNoleggio;
	
	
}
