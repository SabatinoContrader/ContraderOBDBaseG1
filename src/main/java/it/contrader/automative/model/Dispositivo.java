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
@Table(name = "dispositivo")
public class Dispositivo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String codice;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idAuto")
	private Auto auto;
	
	@Column
	private Date dataInstallazione;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idOfficina")
	private Officina officina;
}
