package it.contrader.automative.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "preventivo")
public class Preventivo implements Serializable {

	@Id
	private int id;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idauto")
	private Auto auto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idUtente")
	private Utente utente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idOfficina")
	private Officina officina;
	
	@Column
	private Date Data;

	@Column 
	private String Dettagli;
	
	@Column
	private int Stato;
	
	@Column 
	private float Costo;
	
	@Column
	private String Risposta;
}
