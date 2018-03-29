package it.contrader.automative.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "noleggio")
public class Noleggio implements Serializable{

	@Id
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idutente")
	private Utente utente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idauto")
	private Auto auto;
	
//	@Id
//	private int IdUtente;
	
//	@Id
//	private int IdAuto;
	
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
