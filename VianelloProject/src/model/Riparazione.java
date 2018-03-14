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


public class Riparazione {
	  
	  private int id;
	  private Date data;
	  private String descrizione;
	  private int idAuto;

}
