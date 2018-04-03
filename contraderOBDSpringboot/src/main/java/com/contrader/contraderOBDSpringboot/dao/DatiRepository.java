package com.contrader.contraderOBDSpringboot.dao;


import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.DatiEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DatiRepository extends CrudRepository<DatiEntity, Long> {

    List<DatiEntity> findByAutoEntity(AutoEntity autoEntity);

    void deleteByAutoEntity(AutoEntity autoEntity);

    @Modifying
    @Query("UPDATE DatiEntity SET stato = 1 WHERE n=?1")
    void fixError(int n);

}
