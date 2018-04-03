package com.contrader.contraderOBDSpringboot.dao;


import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import com.contrader.contraderOBDSpringboot.model.OfficinaEntity;
import com.contrader.contraderOBDSpringboot.model.PreventivoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PreventivoRepository extends CrudRepository<PreventivoEntity, Long> {

    long count();

    long countByOfficinaEntity(OfficinaEntity officinaEntity);

    PreventivoEntity save(PreventivoEntity preventivoEntity);

    List<PreventivoEntity> findByOfficinaEntity(OfficinaEntity officinaEntity);

    List<PreventivoEntity> findByDriverEntity(DriverEntity driverEntity);

    @Modifying
    @Query("UPDATE PreventivoEntity SET costo = ?1 WHERE idPreventivo=?2")
    void setCosto(float costo, int idPreventivo);

    @Modifying
    @Query("UPDATE PreventivoEntity SET stato = 1 WHERE idPreventivo=?1")
    void conferma(int idPreventivo);

    @Modifying
    @Query("UPDATE PreventivoEntity SET stato = 0 WHERE idPreventivo=?1")
    void rifiuta(int idPreventivo);

}
