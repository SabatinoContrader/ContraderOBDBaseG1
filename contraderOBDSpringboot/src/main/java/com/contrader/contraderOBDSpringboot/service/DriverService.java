package com.contrader.contraderOBDSpringboot.service;

import com.contrader.contraderOBDSpringboot.dao.AutoRepository;
import com.contrader.contraderOBDSpringboot.dao.DriverRepository;
import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public long countAll () {

    return this.driverRepository.count();
    }

    public DriverEntity save(DriverEntity driverEntity) {
        return this.driverRepository.save(driverEntity);
    }

    public DriverEntity findByIdDriver(int idDriver){
        return this.driverRepository.findByIdDriver(idDriver);
    }

    public void deleteByIdDriver(int idDriver) {
        this.driverRepository.deleteByIdDriver(idDriver);
    }
}
