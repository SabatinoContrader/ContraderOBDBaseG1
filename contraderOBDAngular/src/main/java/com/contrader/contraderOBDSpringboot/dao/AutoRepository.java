package com.contrader.contraderOBDSpringboot.dao;

import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AutoRepository extends CrudRepository<AutoEntity, Long> {

    long count();

    long countByProprietario(String proprietario);

    AutoEntity save(AutoEntity autoEntity);

    AutoEntity findByCodDispositivo(int codDispositivo);

    List<AutoEntity> findByProprietario(String proprietario);

    List<AutoEntity> findByDriverEntity (DriverEntity driverEntity);

    AutoEntity findByTarga(String targa);

    void deleteByCodDispositivo(int codDispositivo);

    @Modifying
    @Query("UPDATE AutoEntity SET noleggiabile = 1 WHERE codDispositivo=?1")
    void setNoleggiabile(int codDispositivo);

    @Modifying
    @Query("UPDATE AutoEntity SET noleggiabile = 0 WHERE codDispositivo=?1")
    void setNonNoleggiabile(int codDispositivo);

}
