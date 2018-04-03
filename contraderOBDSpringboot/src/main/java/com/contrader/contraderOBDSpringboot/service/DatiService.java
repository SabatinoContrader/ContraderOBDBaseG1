package com.contrader.contraderOBDSpringboot.service;

import com.contrader.contraderOBDSpringboot.dao.AutoRepository;
import com.contrader.contraderOBDSpringboot.dao.DatiRepository;
import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.DatiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DatiService {

    private DatiRepository datiRepository;

    @Autowired
    public DatiService(DatiRepository datiRepository) {
        this.datiRepository = datiRepository;
    }

    public List<DatiEntity> findByAutoEntity(AutoEntity autoEntity){
        return this.datiRepository.findByAutoEntity(autoEntity);
    }

    public void deleteByAutoEntity(AutoEntity autoEntity) {
        this.datiRepository.deleteByAutoEntity(autoEntity);
    }

    @Modifying
    public void fixError(int n) {
        this.datiRepository.fixError(n);
    }
}
