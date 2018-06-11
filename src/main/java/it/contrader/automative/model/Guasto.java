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
@Table(name = "guasto")
public class Guasto implements Serializable {

	@Id
	private int id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "codice")
	private TipologiaGuasto tipologiaGuasto;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idTelemetria")
	private DatiTelemetria telemetria;
	
	@Column
	private Date Data;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idDispositivo")
	private Dispositivo dispositivo;
	
	@Column 
	private String statoRisoluzione;
}
