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


public class Guasto {
	
	  private int id;
	  private String codice;
	  private String idTelemetria;
	  private Date dateTime;
	  private int idDispositivo;

}
