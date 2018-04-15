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
@Table(name = "messaggio_ticket")
public class MessaggioTicket implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private Date data;
	//Direzione 0 da cliente ad officina, Direzione 1 da officina a cliente
	@Column
	private int direzione;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idTicket")
	private Ticket ticket;
	
	@Column
	private String testo;

}
