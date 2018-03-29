package it.contrader.automative.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "auto")
public class Auto implements Serializable {

	@Id
	private int ID;
	
	@Column
	private String marca;
	
	@Column
	private String modello;
	
	@Column
	private String targa;
	
	@Column
	private String numeroTelaio;
	
	@Column
	private int cilindrata;
	
	@Column
	private int numeroPorte;
	
	@Column
	private String alimentazione;
	
	@Column
	private int kmAttuali;
	
	@Column
	private int kmInizioNoleggio;
	
	@Column
	private Date scadenzaRevisione;
	
	@Column
	private Date scadenzaTagliando;
	
	@Column
	private Date scadenzaAssicurazione;
	
	@Column
	private Date scadenzaBollo;
	
	@Column
	private String tipologiaAuto;
	
	@Column
	private int daNoleggio;

//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name = "utente_ID")
//	private Utente utente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "officina_ID")
	private Officina officina;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "noleggio_IdAuto")
	private Auto auto;
	
}
