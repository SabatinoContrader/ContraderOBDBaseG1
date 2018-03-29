package com.contrader.contraderOBDSpringboot.service;

import com.contrader.contraderOBDSpringboot.dao.OfficinaRepository;
import com.contrader.contraderOBDSpringboot.model.OfficinaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OfficinaService {

    private OfficinaRepository officinaRepository;

    @Autowired
    public OfficinaService(OfficinaRepository officinaRepository) {
        this.officinaRepository = officinaRepository;
    }

    public long countAll() {

        return this.officinaRepository.count();
    }

    public List<OfficinaEntity> findAll() {
        return this.officinaRepository.findAll();
    }

    public List<OfficinaEntity> findByCitta(String citta) {
        return this.officinaRepository.findByCitta(citta);
    }

    public OfficinaEntity findByIdOfficina(long IdOfficina) {
        return this.officinaRepository.findByIdOfficina(IdOfficina);
    }
}
