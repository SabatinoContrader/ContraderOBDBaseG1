package com.contrader.contraderOBDSpringboot.service;

import com.contrader.contraderOBDSpringboot.dao.AutoRepository;
import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutoService {

    private AutoRepository autoRepository;

    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public long countAll() {
        return this.autoRepository.count();
    }

    public AutoEntity save(AutoEntity autoEntity) {
        return this.autoRepository.save(autoEntity);
    }

    public AutoEntity findByCodDispositivo(int codDispositivo) {
        return this.autoRepository.findByCodDispositivo(codDispositivo);
    }

    public AutoEntity findByTarga(String targa) {
        return this.autoRepository.findByTarga(targa);
    }

    public void deleteByCodDispositivo(int codDispositivo) {
        this.autoRepository.deleteByCodDispositivo(codDispositivo);
    }
}
