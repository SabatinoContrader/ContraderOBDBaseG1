package it.contrader.automative.utils;

import java.io.Serializable;
import java.util.List;

import it.contrader.automative.model.Utente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProblemiAuto implements Serializable {
	
	String key;
	String value;

}
