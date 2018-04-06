package com.contrader.contraderOBDSpringboot.service;

import com.contrader.contraderOBDSpringboot.dao.PreventivoRepository;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import com.contrader.contraderOBDSpringboot.model.OfficinaEntity;
import com.contrader.contraderOBDSpringboot.model.PreventivoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PreventivoService {

    private PreventivoRepository preventivoRepository;

    @Autowired
    public PreventivoService(PreventivoRepository preventivoRepository) {
        this.preventivoRepository = preventivoRepository;
    }

    public long countAll() {
        return this.preventivoRepository.count();
    }

    public long countByOfficinaEntity(OfficinaEntity officinaEntity) {
        return this.preventivoRepository.countByOfficinaEntity(officinaEntity);
    }

    public PreventivoEntity save(PreventivoEntity preventivoEntity) {
        return this.preventivoRepository.save(preventivoEntity);
    }

    public List<PreventivoEntity> findByOfficinaEntity(OfficinaEntity officinaEntity) {
        return this.preventivoRepository.findByOfficinaEntity(officinaEntity);
    }

    public List<PreventivoEntity> findByDriverEntity(DriverEntity driverEntity) {
        return this.preventivoRepository.findByDriverEntity(driverEntity);
    }

    public void setCosto(float costo, int idPreventivo) {
        this.preventivoRepository.setCosto(costo, idPreventivo);
    }

    public void conferma(int idPreventivo) {
        this.preventivoRepository.conferma(idPreventivo);
    }

    public void rifiuta(int idPreventivo) {
        this.preventivoRepository.rifiuta(idPreventivo);
    }
}
