package com.contrader.contraderOBDSpringboot.dao;

import com.contrader.contraderOBDSpringboot.model.AziendaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AziendaRepository extends CrudRepository<AziendaEntity, Long> {

    long count();

    List<AziendaEntity> findAll();

    List<AziendaEntity> findByCitta(String citta);

}
