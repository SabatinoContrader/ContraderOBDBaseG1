package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.*;
import com.contrader.contraderOBDSpringboot.service.*;
import com.contrader.contraderOBDSpringboot.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AutoController {

    private AutoService autoService;
    private AziendaService aziendaService;
    private DatiService datiService;

    @Autowired
    public AutoController(AutoService autoService, AziendaService aziendaService, DatiService datiService) {
        this.autoService = autoService;
        this.aziendaService = aziendaService;
        this.datiService = datiService;
    }

    @RequestMapping(value = "/countAllAuto", method = RequestMethod.POST)
    public GenericResponse<Integer> countAllAuto() {
        Integer count = (int) (long) autoService.countAll();
        return new GenericResponse(count);
    }

    @RequestMapping(value = "/countAutoAzienda", method = RequestMethod.POST)
    public GenericResponse<Integer> countAutoAzienda(@RequestParam(name="id") int id) {
        Integer count = (int) (long) autoService.countByProprietario("a_0" + id);
        return new GenericResponse(count);
    }

    @RequestMapping(value = "/countAutoAziendaError", method = RequestMethod.POST)
    public GenericResponse<Integer> countAutoAziendaError(@RequestParam(name="id") int id) {
        Integer count = (int) (long) datiService.countAutoAziendaError("a_0" + id);
        return new GenericResponse(count);
    }

}
