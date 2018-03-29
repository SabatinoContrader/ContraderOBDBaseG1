package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.*;
import com.contrader.contraderOBDSpringboot.service.*;
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
    private LoginService loginService;
    private DriverService driverService;

    @Autowired
    public OfficinaController(OfficinaService officinaService, AziendaService aziendaService, AutoService autoService, LoginService loginService, DriverService driverService) {
        this.officinaService = officinaService;
        this.aziendaService = aziendaService;
        this.autoService = autoService;
        this.loginService = loginService;
        this.driverService = driverService;
    }

    @RequestMapping(value = "/addAuto", method = RequestMethod.POST)
    public String addAuto(Map<String, Object> model,
                          @ModelAttribute AutoEntity autoEntity,
                          @RequestParam(name = "idOfficina") long idOfficina,
                          @RequestParam(name = "codDispositivo") int codDispositivo) {
        if (autoService.findByCodDispositivo(codDispositivo) == null) {
            OfficinaEntity officinaEntity = officinaService.findByIdOfficina(idOfficina);
            autoEntity.setOfficinaEntity(officinaEntity);
            if (autoService.save(autoEntity) != null) {
                model.put("success", "Auto registrata con successo");
            } else {
                model.put("error", "Errore nella registrazione dell'auto");
            }
        } else {
            model.put("error", "Codice dispositivo già registrato");
        }
        return "home";
    }

    @RequestMapping(value = "/addAzienda", method = RequestMethod.POST)
    public String addAzienda(Map<String, Object> model,
                             @ModelAttribute AziendaEntity aziendaEntity) {
        aziendaEntity.setDriverEntitySet(null);
        AziendaEntity result = aziendaService.save(aziendaEntity);
        if ( result != null) {
            int id = result.getIdAzienda();
            LoginEntity loginEntity = new LoginEntity();
            loginEntity.setUsername("A_0" + id);
            loginEntity.setPassword("A_0" + id);
            loginEntity.setRuolo(3);
            loginEntity.setId(id);
            loginService.save(loginEntity);
            model.put("success", "Azienda registrata con successo");
        } else {
            model.put("error", "Errore nella registrazione dell'azienda");
        }
        return "home";
    }

    @RequestMapping(value = "/resetAuto", method = RequestMethod.POST)
    public String resetAuto(Map<String, Object> model,
                            @RequestParam(name = "codDispositivo") int codDispositivo) {


        autoService.deleteByCodDispositivo(codDispositivo);

        model.put("success", "Dispositivo resettato con successo");

        return "home";
    }

    @RequestMapping(value = "/addDriver", method = RequestMethod.POST)
    public String addDriver(Map<String, Object> model,
                            @ModelAttribute DriverEntity driverEntity,
                            @RequestParam(name = "idDriver") int idDriver) {
        if (driverService.findByIdDriver(idDriver) == null) {

            if (driverService.save(driverEntity) != null) {
                model.put("success", "Driver registrato con successo");
            } else {
                model.put("error", "Errore nella registrazione del driver");
            }
        } else {
            model.put("error", "Patente già registrata nel sistema");
        }
        return "home";
    }

    @RequestMapping(value = "/findAuto", method = RequestMethod.POST)
    public String findAuto(Map<String, Object> model,
                            @RequestParam(name = "codDispositivo") int codDispositivo) {

        AutoEntity autoEntity = autoService.findByCodDispositivo(codDispositivo);
        model.put("findAuto", autoEntity);
        return "findAuto";
    }
}
