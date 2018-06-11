package it.contrader.automative.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;


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
@Table(name = "officina")
public class Officina implements Serializable {

	@Id
	private int id;
	
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
	private String indirizzo;
	
	@Column
	private Date dataInserimento;
	
	@Column
	private String citta;
	

}
