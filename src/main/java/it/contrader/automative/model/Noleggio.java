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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idguidatore")
	private Utente guidatore;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idauto")
	private Auto auto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idofficina")
	private Officina officina;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idazienda")
	private Azienda azienda;
	
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
