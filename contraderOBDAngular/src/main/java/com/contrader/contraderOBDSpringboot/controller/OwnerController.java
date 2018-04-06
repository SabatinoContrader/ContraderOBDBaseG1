package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.AziendaEntity;
import com.contrader.contraderOBDSpringboot.model.LoginEntity;
import com.contrader.contraderOBDSpringboot.model.OfficinaEntity;
import com.contrader.contraderOBDSpringboot.service.AutoService;
import com.contrader.contraderOBDSpringboot.service.AziendaService;
import com.contrader.contraderOBDSpringboot.service.LoginService;
import com.contrader.contraderOBDSpringboot.service.OfficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
public class OwnerController {

    private AziendaService aziendaService;
    private AutoService autoService;
    private OfficinaService officinaService;

    @Autowired
    public OwnerController(OfficinaService officinaService, AziendaService aziendaService, AutoService autoService) {
        this.officinaService = officinaService;
        this.aziendaService = aziendaService;
        this.autoService = autoService;
    }

    @RequestMapping(value = "viewListOfficina", method = RequestMethod.POST)
    public String viewOfficinaCitta(Map<String, Object> model,
                                    @RequestParam(name = "citta", required = true) String citta) {

        List<OfficinaEntity> officinaEntityList = officinaService.findByCitta(citta);
        model.put("officinaEntityList", officinaEntityList);

        return "viewListOfficina";
    }

    @RequestMapping(value = "viewListAzienda", method = RequestMethod.GET)
    public String viewAziendaAll(Map<String, Object> model) {

        List<AziendaEntity> aziendaEntityList = aziendaService.findAll();
        model.put("aziendaEntityList", aziendaEntityList);

        return "viewListAzienda";
    }

    @RequestMapping(value = "viewListAzienda", method = RequestMethod.POST)
    public String viewAziendaCitta(Map<String, Object> model,
                                    @RequestParam(name = "citta", required = true) String citta) {

        List<AziendaEntity> aziendaEntityList = aziendaService.findByCitta(citta);
        model.put("aziendaEntityList", aziendaEntityList);

        return "viewListAzienda";
    }

}
