package com.contrader.contraderOBDSpringboot.dao;

import com.contrader.contraderOBDSpringboot.model.AziendaEntity;
import com.contrader.contraderOBDSpringboot.DTO.AziendaErroriDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AziendaRepository extends CrudRepository<AziendaEntity, Long> {

    long count();

    AziendaEntity findByIdAzienda(int id);

    List<AziendaEntity> findAll();

    List<AziendaEntity> findByCitta(String citta);

    AziendaEntity save(AziendaEntity aziendaEntity);


 //   @Query(value="select new AziendaErroriDTO (dd.codErrore, dd.codDispositivo, dd.livelloOlio, dd.km) from DatiEntity dd, AutoEntity a   where dd.codDispositivo=a.codDispositivo and dd.codErrore is not null")
 //   List<AziendaErroriDTO> getAziendaErrori();

}
