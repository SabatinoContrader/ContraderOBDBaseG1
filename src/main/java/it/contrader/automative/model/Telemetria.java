package it.contrader.automative.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
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
@Table(name = "telemetria", indexes = {@Index(columnList = "iddispositivo, iddatitelemetria")})
public class Telemetria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private Date data;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "iddispositivo")
	private Dispositivo dispositivo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "iddatitelemetria")
	private DatiTelemetria datiTelemetria;
}
