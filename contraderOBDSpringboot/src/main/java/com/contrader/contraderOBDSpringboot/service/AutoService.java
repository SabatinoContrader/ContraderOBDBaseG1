package com.contrader.contraderOBDSpringboot.service;

import com.contrader.contraderOBDSpringboot.dao.AutoRepository;
import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public long countByProprietario(String proprietario) {
        return this.autoRepository.countByProprietario(proprietario);
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

    public List<AutoEntity> findByProprietario (String proprietario) {
        return this.autoRepository.findByProprietario(proprietario);
    }

    public void deleteByCodDispositivo(int codDispositivo) {
        this.autoRepository.deleteByCodDispositivo(codDispositivo);
    }

    public void setNoleggiabile(int codDispositivo) {
        this.autoRepository.setNoleggiabile(codDispositivo);
    }

    public void setNonNoleggiabile(int codDispositivo) {
        this.autoRepository.setNonNoleggiabile(codDispositivo);
    }
}
