package it.contrader.automative.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tipologia_guasto")
public class TipologiaGuasto implements Serializable {

	@Id
	private String codice;
	
	@Column
	private String descrizione;
	
}
