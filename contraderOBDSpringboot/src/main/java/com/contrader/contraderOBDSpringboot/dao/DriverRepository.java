package com.contrader.contraderOBDSpringboot.dao;

import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DriverRepository extends CrudRepository<DriverEntity, Long> {

    long count();

    DriverEntity save(DriverEntity driverEntity);

    DriverEntity findByIdDriver(int idDriver);

    void deleteByIdDriver(int idDriver);

}
