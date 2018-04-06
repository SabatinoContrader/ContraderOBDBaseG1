package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import com.contrader.contraderOBDSpringboot.model.OfficinaEntity;
import com.contrader.contraderOBDSpringboot.model.PreventivoEntity;
import com.contrader.contraderOBDSpringboot.service.AutoService;
import com.contrader.contraderOBDSpringboot.service.DriverService;
import com.contrader.contraderOBDSpringboot.service.OfficinaService;
import com.contrader.contraderOBDSpringboot.service.PreventivoService;
import com.contrader.contraderOBDSpringboot.util.GenericResponse;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class PreventivoController {

    private PreventivoService preventivoService;
    private OfficinaService officinaService;
    private DriverService driverService;

    @Autowired
    public PreventivoController(PreventivoService preventivoService, OfficinaService officinaService,
                                DriverService driverService) {
        this.preventivoService = preventivoService;
        this.officinaService = officinaService;
        this.driverService = driverService;
    }

    @RequestMapping(value = "/countPreventivoOfficina", method = RequestMethod.POST)
    public GenericResponse<Integer> countPreventivoOfficina(@RequestParam(name = "id") int id) {
        OfficinaEntity officinaEntity = officinaService.findByIdOfficina(id);
        Integer countAll = (int) (long) preventivoService.countByOfficinaEntity(officinaEntity);
        return new GenericResponse(countAll);
    }

    @RequestMapping(value = "/listPreventivo", method = RequestMethod.POST)
    public GenericResponse<List<PreventivoEntity>> listPreventivo(@RequestParam(name = "id") int id,
                                                                  @RequestParam(name = "ruolo") int ruolo) {
        List<PreventivoEntity> listaPreventivi = null;
        switch (ruolo) {
            case 2:
                OfficinaEntity officinaEntity = officinaService.findByIdOfficina(id);
                listaPreventivi = preventivoService.findByOfficinaEntity(officinaEntity);
                break;

            case 4:
                DriverEntity driverEntity = driverService.findByIdDriver(id);
                listaPreventivi = preventivoService.findByDriverEntity(driverEntity);
                break;
        }

        return new GenericResponse(listaPreventivi);
    }

}
