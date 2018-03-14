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

public class RichiestaNoleggio {
	  
	  private int id;
	  private int idAuto;
	  private int idUtente;
	  private String luogoRitiro;
	  private Date dataRitiro;
	  private String luogoRiconsegna;
	  private Date dataRiconsegna;

}
