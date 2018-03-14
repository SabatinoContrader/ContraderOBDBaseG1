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

public class Azienda {
	
	  private String denominazione;
	  private String nomeReferente;
	  private String cognomeReferente;
	  private String email;
	  private String telefono;
	  private String latitudine;
	  private String longitudine;
	  private String tipologia;
	  private Date dataInserimento;
	  private String città;
	  private ArrayList<Auto> listAuto;
}
