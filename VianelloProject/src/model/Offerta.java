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

public class Offerta {
 
	private int id;
	 private int idAzienda;
	 private Date scadenza;
	 private String dettagli;
	 private Date inizio;

}
