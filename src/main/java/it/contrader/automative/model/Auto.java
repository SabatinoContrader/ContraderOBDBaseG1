package it.contrader.automative.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "auto")
public class Auto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
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
	private int potenza;
	
	@Column
	private String cambio;
	
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
//	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name = "IdAuto")
//	private Auto auto;
	
}
