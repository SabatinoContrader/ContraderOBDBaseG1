package model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Appuntamento {
	
	private int id;
	  private int idUtente;
	  private Date data;
	  private int idAzienda;
	  private String dettagli;
	  private int stato;
	  private String risposta;

}
