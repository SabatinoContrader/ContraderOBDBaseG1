package it.contrader.automative.utils;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Guasto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class StatoAuto {

	private Auto auto;
	private String status; //Danger, Warning, Success
	
}
