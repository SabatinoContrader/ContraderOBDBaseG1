package com.contrader.contraderOBDSpringboot.controller;

import java.util.List;

import java.util.Map;

import com.contrader.contraderOBDSpringboot.model.DatiEntity;
import com.contrader.contraderOBDSpringboot.service.DatiService;
import com.contrader.contraderOBDSpringboot.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.contrader.contraderOBDSpringboot.DTO.AziendaErroriDTO;
import com.contrader.contraderOBDSpringboot.model.AutoEntity;
import com.contrader.contraderOBDSpringboot.model.AziendaEntity;
import com.contrader.contraderOBDSpringboot.model.DriverEntity;
import com.contrader.contraderOBDSpringboot.service.AziendaService;
import com.contrader.contraderOBDSpringboot.service.AutoService;

@Controller
public class AziendaController {

    private AziendaService aziendaService;
    private AutoService autoService;
    private DriverService driverService;
    private DatiService datiService;

    @Autowired
    public AziendaController(AziendaService aziendaService, AutoService autoService, DriverService driverService,
                             DatiService datiService) {
        this.aziendaService = aziendaService;
        this.autoService = autoService;
        this.driverService = driverService;
        this.datiService = datiService;
    }

    @RequestMapping(value = "/noleggio", method = RequestMethod.POST)
    public String noleggia(@RequestParam(name = "codDispositivo", required = true) int codDispositivo,
                           @RequestParam(name = "idDriver", required = true) int idDriver,
                           Map<String, Object> model) {
        if (aziendaService.noleggio(codDispositivo, idDriver)) {
            model.put("success", "Noleggio registrato con successo");
        } else {
            model.put("error", "Errore nel noleggio");
        }
        return "home";
    }

    @RequestMapping(value = "/viewAutoAzienda", method = RequestMethod.POST)
    public String viewAutoAzienda(@RequestParam(name = "proprietario", required = true) String proprietario,
                                  Map<String, Object> model) {
        List<AutoEntity> listaAutoAzienda = autoService.findByProprietario(proprietario);
        model.put("listaAutoAzienda", listaAutoAzienda);
        return "viewAuto";
    }

    @RequestMapping(value = "/terminaNoleggio", method = RequestMethod.POST)
    public String termina(@RequestParam(name = "codDispositivo", required = true) int codDispositivo,
                          Map<String, Object> model) {
        if (aziendaService.terminaNoleggio(codDispositivo)) {
            model.put("success", "Noleggio terminato con successo");
        } else {
            model.put("error", "Errore nel termine del noleggio");
        }
        return "home";
    }

    @RequestMapping(value = "/listaDriver", method = RequestMethod.GET)
    public String update(Map<String, Object> model) {
        List<DriverEntity> driver = aziendaService.getAllDriver();
        model.put("allDriver", driver);
        model.put("aziendaOp", "listaDriver");
        return "listaAutoAzienda";
    }

    @RequestMapping(value = "/viewDriverAzienda", method = RequestMethod.POST)
    public String viewDriverAzienda(@RequestParam(name = "idAzienda", required = true) int idAzienda,
                                    Map<String, Object> model) {
        AziendaEntity aziendaEntity = aziendaService.findByIdAzienda(idAzienda);
        List<DriverEntity> listaDriverAzienda = driverService.findByAziendaEnity(aziendaEntity);
        model.put("listaDriverAzienda", listaDriverAzienda);
        return "viewDriver";
    }

    @RequestMapping(value = "/viewAutoError", method = RequestMethod.POST)
    public String viewAutoError(@RequestParam(name = "proprietario", required = true) String proprietario,
                                Map<String, Object> model) {
        List<DatiEntity> listaErroriAzienda = datiService.findAutoAziendaError(proprietario);
        model.put("listaErroriAzienda", listaErroriAzienda);
        return "viewError";
    }

    @RequestMapping(value = "/preSetDisponibilita", method = RequestMethod.GET)
    public String preDisponibilita(Map<String, Object> model) {
        model.put("aziendaOp", "preDisponibilita");
        return "listaAutoAzienda";
    }

    @RequestMapping(value = "/setDisponibilita", method = RequestMethod.POST)
    public String disponibilita(@RequestParam(name = "id_auto", required = true) int cod_dispositivo,
                                @RequestParam(name = "disponibilita", required = true) boolean disponibilita,
                                Map<String, Object> model) {
        model.put("aziendaOp", "setDisponibilita");
        return "listaAutoAzienda";
    }

    @RequestMapping(value = "/setNoleggiabile", method = RequestMethod.POST)
    public String setNoleggiabile(@RequestParam(name = "codDispositivo", required = true) int codDispositivo,
                                  @RequestParam(name = "proprietario", required = true) String proprietario,
                                  Map<String, Object> model) {
        autoService.setNoleggiabile(codDispositivo);
        List<AutoEntity> listaAutoAzienda = autoService.findByProprietario(proprietario);
        model.put("listaAutoAzienda", listaAutoAzienda);
        return "viewAuto";
    }

    @RequestMapping(value = "/setNonNoleggiabile", method = RequestMethod.POST)
    public String setNonNoleggiabile(@RequestParam(name = "codDispositivo", required = true) int codDispositivo,
                                     @RequestParam(name = "proprietario", required = true) String proprietario,
                                     Map<String, Object> model) {
        autoService.setNonNoleggiabile(codDispositivo);List<AutoEntity> listaAutoAzienda = autoService.findByProprietario(proprietario);
        model.put("listaAutoAzienda", listaAutoAzienda);
        return "viewAuto";
    }

}
