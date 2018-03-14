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

public class Dispositivo {

	private int id;
	private String codice;
	private int idAuto;
	private Date dataInstallazione;
	private  int idAzienda;
}
