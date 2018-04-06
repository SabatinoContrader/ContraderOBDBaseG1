package com.contrader.contraderOBDSpringboot.DTO;


import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.DatiEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutoDatiDTO {

	AutoEntity autoEntity;
	List<DatiEntity> datiEntityList;
}
