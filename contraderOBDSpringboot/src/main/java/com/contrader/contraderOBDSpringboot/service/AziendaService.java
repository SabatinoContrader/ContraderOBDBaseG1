package com.contrader.contraderOBDSpringboot.service;

import com.contrader.contraderOBDSpringboot.DTO.AziendaErroriDTO;
import com.contrader.contraderOBDSpringboot.dao.AutoRepository;
import com.contrader.contraderOBDSpringboot.dao.AziendaRepository;
import com.contrader.contraderOBDSpringboot.dao.DriverRepository;
import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.AziendaEntity;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AziendaService {

    private AziendaRepository aziendaRepository;
    private AutoRepository autoRepository;
    private DriverRepository driverRepository;

    @Autowired
    public AziendaService(AziendaRepository aziendaRepository, AutoRepository autoRepository, DriverRepository driverRepository) {
        this.aziendaRepository = aziendaRepository;
        this.autoRepository = autoRepository;
        this.driverRepository = driverRepository;
    }


    public long countAll () {

    return this.aziendaRepository.count();
    }

    public List<AziendaEntity> findAll() {
        return this.aziendaRepository.findAll();
    }

    public List<AziendaEntity> findByCitta(String citta) {
        return this.aziendaRepository.findByCitta(citta);
    }

    public AziendaEntity save(AziendaEntity aziendaEntity)
    {
        return this.aziendaRepository.save(aziendaEntity);
    }

    public boolean noleggio(int codDispositivo, int idDriver){

        boolean result = false;
        AutoEntity autoDaAggiornare = autoRepository.findByCodDispositivo(codDispositivo);
        DriverEntity driver = driverRepository.findByIdDriver(idDriver);
        if(autoDaAggiornare != null && driver != null){
            autoDaAggiornare.setDriverEntity(driver);
            autoDaAggiornare = autoRepository.save(autoDaAggiornare);
            result = true;
        }
        return result;
    }

    public List<AutoEntity> getAllAuto(String azienda){
        List<AutoEntity> auto = autoRepository.findByProprietario(azienda);
        if(auto != null) return auto;
        else return null;
    }

    public boolean terminaNoleggio(int codDispositivo){
        AutoEntity autoDaAggiornare = autoRepository.findByCodDispositivo(codDispositivo);

        if(autoDaAggiornare != null){
            autoDaAggiornare.setDriverEntity(null);
            autoDaAggiornare = autoRepository.save(autoDaAggiornare);
            return true;
        }
        return false;
    }

    public List<DriverEntity> getAllDriver(){
        List<DriverEntity> driver = driverRepository.findAll();
        if(driver != null) return driver;
        else return null;
    }

    public boolean insertDriver(DriverEntity driver){
        if(driver != null){
            driverRepository.save(driver);
        }
        return false;
    }

    public AziendaEntity findByIdAzienda(int id){
        return aziendaRepository.findByIdAzienda(id);
    }

    public boolean InsertDriver(DriverEntity driver){
        driverRepository.save(driver);
        return true;
    }

    public void setNoleggiabile(int codDispositivo) {
        this.autoRepository.setNoleggiabile(codDispositivo);
    }

    public void setNonNoleggiabile(int codDispositivo) {
        this.autoRepository.setNonNoleggiabile(codDispositivo);
    }

 /*   public List<AziendaErroriDTO> AziendaErrori(){

        List<AziendaErroriDTO> aziendaErrori= aziendaRepository.getAziendaErrori();

        if(aziendaErrori != null){
            return aziendaErrori;
        }else
            return null;
    } */
}

