package com.contrader.contraderOBDSpringboot.DTO;


import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AziendaErroriDTO {

	String cod_errore;
	int cod_dispositivo;
	float livello_olio;
	int km;
}
