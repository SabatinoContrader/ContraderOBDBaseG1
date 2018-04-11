package it.contrader.automative.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "azienda")
public class Azienda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String denominazione;
	
	@Column
	private String nomeReferente;
	
	@Column
	private String cognomeReferente;
	
	@Column
	private String partitaIva;
	
	@Column
	private String indirizzo;
	
	@Column
	private String citta;

}
