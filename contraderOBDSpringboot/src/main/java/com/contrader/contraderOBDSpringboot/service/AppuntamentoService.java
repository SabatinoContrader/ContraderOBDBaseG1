package com.contrader.contraderOBDSpringboot.service;

import com.contrader.contraderOBDSpringboot.dao.AppuntamentoRepository;
import com.contrader.contraderOBDSpringboot.model.AppuntamentoEntity;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import com.contrader.contraderOBDSpringboot.model.OfficinaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppuntamentoService {

    private AppuntamentoRepository appuntamentoRepository;

    @Autowired
    public AppuntamentoService(AppuntamentoRepository appuntamentoRepository) {
        this.appuntamentoRepository = appuntamentoRepository;
    }

    public long countAll() {
        return this.appuntamentoRepository.count();
    }

    public long countByOfficinaEntity(OfficinaEntity officinaEntity) {
        return this.appuntamentoRepository.countByOfficinaEntity(officinaEntity);
    }

    public AppuntamentoEntity save(AppuntamentoEntity appuntamentoEntity) {
        return this.appuntamentoRepository.save(appuntamentoEntity);
    }

    public List<AppuntamentoEntity> findByOfficinaEntity(OfficinaEntity officinaEntity) {
        return this.appuntamentoRepository.findByOfficinaEntity(officinaEntity);
    }

    public List<AppuntamentoEntity> findByDriverEntity(DriverEntity driverEntity) {
        return this.appuntamentoRepository.findByDriverEntity(driverEntity);
    }

    public void conferma(int idAppuntamento) {
        this.appuntamentoRepository.conferma(idAppuntamento);
    }

    public void rifiuta(int idAppuntamento) {
        this.appuntamentoRepository.rifiuta(idAppuntamento);
    }
}
