package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.AppuntamentoEntity;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import com.contrader.contraderOBDSpringboot.model.OfficinaEntity;
import com.contrader.contraderOBDSpringboot.model.PreventivoEntity;
import com.contrader.contraderOBDSpringboot.service.AppuntamentoService;
import com.contrader.contraderOBDSpringboot.service.DriverService;
import com.contrader.contraderOBDSpringboot.service.OfficinaService;
import com.contrader.contraderOBDSpringboot.service.PreventivoService;
import com.contrader.contraderOBDSpringboot.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AppuntamentoController {

    private AppuntamentoService appuntamentoService;
    private OfficinaService officinaService;
    private DriverService driverService;

    @Autowired
    public AppuntamentoController(AppuntamentoService appuntamentoService, OfficinaService officinaService,
                                  DriverService driverService) {
        this.appuntamentoService = appuntamentoService;
        this.officinaService = officinaService;
        this.driverService = driverService;
    }

    @RequestMapping(value = "/countAppuntamentoOfficina", method = RequestMethod.POST)
    public GenericResponse<Integer> countAppuntamentoOfficina(@RequestParam(name="id") int id) {
        OfficinaEntity officinaEntity = officinaService.findByIdOfficina(id);
        Integer countAll = (int) (long) appuntamentoService.countByOfficinaEntity(officinaEntity);
        return new GenericResponse(countAll);
    }

    @RequestMapping(value = "/listAppuntamento", method = RequestMethod.POST)
    public GenericResponse<List<AppuntamentoEntity>> listAppuntamento(@RequestParam(name = "id") int id,
                                                                      @RequestParam(name = "ruolo") int ruolo) {
        List<AppuntamentoEntity> listaAppuntamenti = null;
        switch (ruolo) {
            case 2:
                OfficinaEntity officinaEntity = officinaService.findByIdOfficina(id);
                listaAppuntamenti = appuntamentoService.findByOfficinaEntity(officinaEntity);
                break;

            case 4:
                DriverEntity driverEntity = driverService.findByIdDriver(id);
                listaAppuntamenti = appuntamentoService.findByDriverEntity(driverEntity);
                break;
        }

        return new GenericResponse(listaAppuntamenti);
    }

}
