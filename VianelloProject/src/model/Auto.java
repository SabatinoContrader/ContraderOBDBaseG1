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

public class Auto {
	
	  private String marca;
	  private String modello;
	  private String targa;
	  private String numeroTelaio;
	  private int kmAttuali;
	  private int kmInizioNoleggio;
	  private Date scadenzaRevisione;
	  private Date sadenzaTagliando;
	  private Date scadenzaAssicurazione;
	  private Date scadenzaBollo;
	  private String tipologiaAuto;
	  private int daNoleggio;
}
