package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class RichiestaPreventivo {
	private int id;
	private String descrizione;
	private int idUtente;
	private int idAuto;
	private int idAzienda;
}
