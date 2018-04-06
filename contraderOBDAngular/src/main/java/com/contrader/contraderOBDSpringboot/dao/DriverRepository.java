package com.contrader.contraderOBDSpringboot.dao;

import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.AziendaEntity;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DriverRepository extends CrudRepository<DriverEntity, Long> {

    long count();

    long countByAziendaEntity (AziendaEntity aziendaEntity);

    DriverEntity save(DriverEntity driverEntity);

    DriverEntity findByIdDriver(int idDriver);

    List<DriverEntity> findAll();

    List<DriverEntity> findByAziendaEntity(AziendaEntity aziendaEntity);

    void deleteByIdDriver(int idDriver);

}
