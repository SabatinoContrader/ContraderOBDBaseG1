package com.contrader.contraderOBDSpringboot.dao;

import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AutoRepository extends CrudRepository<AutoEntity, Long> {

    long count();

    AutoEntity save(AutoEntity autoEntity);

    AutoEntity findByCodDispositivo(int codDispositivo);

    AutoEntity findByTarga(String targa);

    void deleteByCodDispositivo(int codDispositivo);

}
