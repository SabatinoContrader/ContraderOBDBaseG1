package model;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Utente {

	private int id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private int stato;
	private int idAzienda;
	private Date dataRegistrazione;
	private int ruolo;
	private String telefono;
	private ArrayList <Auto> auto;
}
