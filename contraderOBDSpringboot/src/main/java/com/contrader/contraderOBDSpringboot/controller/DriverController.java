package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.*;
import com.contrader.contraderOBDSpringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Driver;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


@Controller
public class DriverController {

    private AziendaService aziendaService;
    private AutoService autoService;
    private OfficinaService officinaService;
    private LoginService loginService;
    private DriverService driverService;
    private DatiService datiService;
    private AppuntamentoService appuntamentoService;
    private PreventivoService preventivoService;

    @Autowired
    public DriverController(AutoService autoService, DriverService driverService, AppuntamentoService appuntamentoService, PreventivoService preventivoService) {
        this.autoService = autoService;
        this.driverService = driverService;
        this.appuntamentoService = appuntamentoService;
        this.preventivoService = preventivoService;
    }

    @RequestMapping(value = "/viewNotificheDriver", method = RequestMethod.POST)
    public String viewAuto(Map<String, Object> model,
                           @RequestParam(name = "codDispositivo") int codDispositivo) {

        AutoEntity autoEntity = autoService.findByCodDispositivo(codDispositivo);
        model.put("viewAuto", autoEntity);
        model.put("scadenze", scadenze(autoEntity));
        return "viewNotificheDriver";
    }

    @RequestMapping(value = "/chiediAppuntamento", method = RequestMethod.POST)
    public String chiediAppuntamento(Map<String, Object> model,
                                     @ModelAttribute AppuntamentoEntity appuntamentoEntity,
                                     @RequestParam(name = "codDispositivo") int codDispositivo) {

        AutoEntity autoEntity = autoService.findByCodDispositivo(codDispositivo);
        appuntamentoEntity.setAutoEntity(autoEntity);
        appuntamentoEntity.setDriverEntity(autoEntity.getDriverEntity());
        appuntamentoEntity.setOfficinaEntity(autoEntity.getOfficinaEntity());
        if (appuntamentoService.save(appuntamentoEntity) != null) {
            model.put("success", "Appuntamento richiesto");
        } else {
            model.put("error", "Errore nella richiesta di appuntamento");
        }
        model.put("viewAuto", autoEntity);
        model.put("scadenze", scadenze(autoEntity));
        return "viewNotificheDriver";
    }

    @RequestMapping(value = "/chiediPreventivo", method = RequestMethod.POST)
    public String chiediPreventivo(Map<String, Object> model,
                                   @ModelAttribute PreventivoEntity preventivoEntity,
                                   @RequestParam(name = "codDispositivo") int codDispositivo) {
        AutoEntity autoEntity = autoService.findByCodDispositivo(codDispositivo);
        preventivoEntity.setAutoEntity(autoEntity);
        preventivoEntity.setDriverEntity(autoEntity.getDriverEntity());
        preventivoEntity.setOfficinaEntity(autoEntity.getOfficinaEntity());

        if (preventivoService.save(preventivoEntity) != null) {
            model.put("success", "Preventivo richiesto");
        } else {
            model.put("error", "Errore nella richiesta del preventivo");
        }
        model.put("viewAuto", autoEntity);
        model.put("scadenze", scadenze(autoEntity));
        return "viewNotificheDriver";
    }

    @RequestMapping(value = "/viewAppuntamentiDriver", method = RequestMethod.POST)
    public String viewAppuntamentiDriver(Map<String, Object> model,
                                         @RequestParam(name = "idDriver") int idDriver) {
        DriverEntity driverEntity = driverService.findByIdDriver(idDriver);
        List<AppuntamentoEntity> listaAppuntamenti = appuntamentoService.findByDriverEntity(driverEntity);
        model.put("listaAppuntamenti", listaAppuntamenti);
        return "viewAppuntamenti";
    }

    @RequestMapping(value = "/viewPreventiviDriver", method = RequestMethod.POST)
    public String viewPreventivi(Map<String, Object> model,
                                 @RequestParam(name = "idDriver") int idDriver) {
        DriverEntity driverEntity = driverService.findByIdDriver(idDriver);
        List<PreventivoEntity> listaPreventivi = preventivoService.findByDriverEntity(driverEntity);
        model.put("listaPreventivi", listaPreventivi);
        return "viewPreventivi";
    }

    @RequestMapping(value = "/confermaPreventivo", method = RequestMethod.POST)
    public String confermaPreventivo(Map<String, Object> model,
                                     @RequestParam(name = "idPreventivo") int idPreventivo,
                                     @RequestParam(name = "idDriver") int idDriver) {
        preventivoService.conferma(idPreventivo);
        DriverEntity driverEntity = driverService.findByIdDriver(idDriver);
        List<PreventivoEntity> listaPreventivi = preventivoService.findByDriverEntity(driverEntity);
        model.put("listaPreventivi", listaPreventivi);
        return "viewPreventivi";
    }

    @RequestMapping(value = "/rifiutaPreventivo", method = RequestMethod.POST)
    public String rifutaPreventivo(Map<String, Object> model,
                                     @RequestParam(name = "idPreventivo") int idPreventivo,
                                     @RequestParam(name = "idDriver") int idDriver) {
        preventivoService.rifiuta(idPreventivo);
        DriverEntity driverEntity = driverService.findByIdDriver(idDriver);
        List<PreventivoEntity> listaPreventivi = preventivoService.findByDriverEntity(driverEntity);
        model.put("listaPreventivi", listaPreventivi);
        return "viewPreventivi";
    }

    public String scadenze(AutoEntity autoEntity) {
        List<DatiEntity> listaDati = autoEntity.getDatiEntitySet();
        DatiEntity dato = listaDati.get(listaDati.size() - 1);
        Scanner scanner = new Scanner(autoEntity.getRevisione()).useDelimiter("/");
        int gg_revisione = scanner.nextInt();
        int mm_revisione = scanner.nextInt();
        int aa_revisione = scanner.nextInt();
        scanner = new Scanner(autoEntity.getTagliandoData()).useDelimiter("/");
        int gg_tagliando = scanner.nextInt();
        int mm_tagliando = scanner.nextInt();
        int aa_tagliando = scanner.nextInt();
        scanner = new Scanner(dato.getData()).useDelimiter("/");
        int gg_dato = scanner.nextInt();
        int mm_dato = scanner.nextInt();
        int aa_dato = scanner.nextInt();
        int revisione = gg_revisione + mm_revisione * 365 / 12 + aa_revisione * 365;
        int tagliando = gg_tagliando + mm_tagliando * 365 / 12 + aa_tagliando * 365;
        int data = gg_dato + mm_dato * 365 / 12 + aa_dato * 365;

        int km = dato.getKm() - autoEntity.getTagliandoKm();
        String scad;

        if (data - revisione > 365 + 365 / 12 * 11) {
            scad = "revisione";
        } else if (((data - tagliando) > 365 + 365 / 12 * 11) || km > 14500) {
            scad = "tagliando";
        } else {
            scad = "ok";
        }
        return scad;
    }
}
