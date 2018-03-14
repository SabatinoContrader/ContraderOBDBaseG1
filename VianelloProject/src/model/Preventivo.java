package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Preventivo {
	
	private int id;
	 private int idRichiestaPreventivo;
	 private String dettagli;
	 private float costo;

}
