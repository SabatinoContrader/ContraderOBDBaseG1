package com.contrader.contraderOBDSpringboot.dao;

import com.contrader.contraderOBDSpringboot.model.AppuntamentoEntity;
import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import com.contrader.contraderOBDSpringboot.model.OfficinaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AppuntamentoRepository extends CrudRepository<AppuntamentoEntity, Long> {

    long count();

    long countByOfficinaEntity(OfficinaEntity officinaEntity);

    AppuntamentoEntity save(AppuntamentoEntity appuntamentoEntity);

    List<AppuntamentoEntity> findByOfficinaEntity(OfficinaEntity officinaEntity);

    List<AppuntamentoEntity> findByDriverEntity(DriverEntity driverEntity);

    @Modifying
    @Query("UPDATE AppuntamentoEntity SET stato = 1 WHERE idAppuntamento=?1")
    void conferma(int idAppuntamento);

    @Modifying
    @Query("UPDATE AppuntamentoEntity SET stato = 0 WHERE idAppuntamento=?1")
    void rifiuta(int idAppuntamento);

}
