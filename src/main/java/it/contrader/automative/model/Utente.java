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
@Table(name = "utente")
public class Utente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private int stato;
	
//	@Column
//	private int idOfficina;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idOfficina")
	private Officina officina;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idAzienda")
	private Azienda azienda;
	
	@Column
	private Date dataRegistrazione;
	
	@Column
	private int ruolo;			//0: cliente normale/dipendente azienda; 1: Officina; 2: Admin Azienda/Cliente Business; 3: Admin/Owner
	
	@Column
	private String telefono;
	
	@Column
	private String citta;
	
//
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name = "noleggio_IdUtente")
//	private Noleggio noleggio;

}