package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.AziendaEntity;
import com.contrader.contraderOBDSpringboot.model.OfficinaEntity;
import com.contrader.contraderOBDSpringboot.service.AutoService;
import com.contrader.contraderOBDSpringboot.service.AziendaService;
import com.contrader.contraderOBDSpringboot.service.OfficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
public class OfficinaController {

    private AziendaService aziendaService;
    private AutoService autoService;
    private OfficinaService officinaService;

    @Autowired
    public OfficinaController(OfficinaService officinaService, AziendaService aziendaService, AutoService autoService) {
        this.officinaService = officinaService;
        this.aziendaService = aziendaService;
        this.autoService = autoService;
    }


    @RequestMapping(value = "/addAuto", method = RequestMethod.POST)
    public String addAuto(Map<String, Object> model,
                          @ModelAttribute AutoEntity autoEntity,
                          @RequestParam(name = "idOfficina") long idOfficina) {

        OfficinaEntity officinaEntity = officinaService.findByIdOfficina(idOfficina);
        autoEntity.setOfficinaEntity(officinaEntity);
        AutoEntity autoEntity2 = autoService.save(autoEntity);
        if (autoEntity2 == autoEntity) {
            model.put("success", "Auto registrata con successo");
        } else {
            model.put("error", "Errore nella registrazione dell'auto");
        }

            return "home";
    }

}
