package it.contrader.automative.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "officina")
public class Officina implements Serializable {

	@Id
	private int ID;
	
	@Column
	private String denominazione;
	
	@Column
	private String nomeReferente;
	
	@Column
	private String cognomeReferente;
	
	@Column
	private String email;
	
	@Column
	private String telefono;
	
	@Column
	private String latitudine;
	
	@Column
	private String longitudine;
	
	@Column
	private String tipologia;
	
	@Column
	private Date dataInserimento;
	
	@Column
	private String citta;
	

}
