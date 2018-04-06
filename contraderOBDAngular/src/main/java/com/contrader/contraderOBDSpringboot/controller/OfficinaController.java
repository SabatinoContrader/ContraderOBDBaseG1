package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.DTO.AutoDatiDTO;
import com.contrader.contraderOBDSpringboot.model.*;
import com.contrader.contraderOBDSpringboot.service.*;
import com.contrader.contraderOBDSpringboot.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;


@RestController
public class OfficinaController {

    private AziendaService aziendaService;
    private AutoService autoService;
    private OfficinaService officinaService;
    private LoginService loginService;
    private DriverService driverService;
    private DatiService datiService;
    private AppuntamentoService appuntamentoService;
    private PreventivoService preventivoService;

    @Autowired
    public OfficinaController(OfficinaService officinaService, AziendaService aziendaService, AutoService autoService,
                              LoginService loginService, DriverService driverService, DatiService datiService,
                              AppuntamentoService appuntamentoService, PreventivoService preventivoService) {
        this.officinaService = officinaService;
        this.aziendaService = aziendaService;
        this.autoService = autoService;
        this.loginService = loginService;
        this.driverService = driverService;
        this.datiService = datiService;
        this.appuntamentoService = appuntamentoService;
        this.preventivoService = preventivoService;
    }

    @RequestMapping(value = "/countAllOfficina", method = RequestMethod.POST)
    public GenericResponse<Integer> countAllOfficina() {
        Integer countAll = (int) (long) officinaService.countAll();
        return new GenericResponse(countAll);
    }

    @RequestMapping(value = "listOfficina", method = RequestMethod.POST)
    public GenericResponse<List<OfficinaEntity>> listOfficina() {
        List<OfficinaEntity> officinaEntityList = officinaService.findAll();
        return new GenericResponse(officinaEntityList);
    }

    @RequestMapping(value = "/addAuto", method = RequestMethod.POST)
    public String addAuto(Map<String, Object> model,
                          @ModelAttribute AutoEntity autoEntity,
                          @RequestParam(name = "idOfficina") int idOfficina,
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

    @RequestMapping(value = "/editAuto", method = RequestMethod.POST)
    public String editAuto(Map<String, Object> model,
                           @ModelAttribute AutoEntity autoEntity,
                           @RequestParam(name = "idOfficina") int idOfficina,
                           @RequestParam(name = "codDispositivo") int codDispositivo) {

        autoEntity.setCodDispositivo(codDispositivo);
        OfficinaEntity officinaEntity = officinaService.findByIdOfficina(idOfficina);
        autoEntity.setOfficinaEntity(officinaEntity);
        if (autoService.save(autoEntity) != null) {
            model.put("success", "Auto modificata con successo");
        } else {
            model.put("error", "Errore nella modifica dell'auto");
        }
        model.put("findAuto", autoEntity);
        return "findAuto";
    }

    @RequestMapping(value = "/addAzienda", method = RequestMethod.POST)
    public String addAzienda(Map<String, Object> model,
                             @ModelAttribute AziendaEntity aziendaEntity) {
        AziendaEntity result = aziendaService.save(aziendaEntity);
        if (result != null) {
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
                            @RequestParam(name = "idDriver") int idDriver,
                            @RequestParam(name = "idAzienda") Integer idAzienda) {
        if( idAzienda != null) {
            AziendaEntity aziendaEntity = aziendaService.findByIdAzienda(idAzienda);
            driverEntity.setAziendaEntity(aziendaEntity);
        }
        if (driverService.findByIdDriver(idDriver) == null) {
            DriverEntity driver = driverService.save(driverEntity);
            if ( driver != null) {
                int id = driver.getIdDriver();
                LoginEntity loginEntity = new LoginEntity();
                loginEntity.setUsername("D_0" + id);
                loginEntity.setPassword("D_0" + id);
                loginEntity.setRuolo(4);
                loginEntity.setId(id);
                loginService.save(loginEntity);
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
    public GenericResponse<AutoDatiDTO> findAuto( @RequestParam(name = "findAuto") String findAuto) {

        AutoEntity autoEntity;
        try {
            autoEntity = autoService.findByCodDispositivo(Integer.parseInt(findAuto));
        } catch (NumberFormatException e) {
            autoEntity = autoService.findByTarga(findAuto);
        }
        List<DatiEntity> datiEntityList = datiService.findByAutoEntity(autoEntity);
        AutoDatiDTO autoDatiDTO = new AutoDatiDTO(autoEntity, datiEntityList);
        return new GenericResponse(autoDatiDTO);
    }

    @RequestMapping(value = "/fixError", method = RequestMethod.POST)
    public String fixError(Map<String, Object> model,
                           @RequestParam(name = "n") int n,
                           @RequestParam(name = "codDispositivo") int codDispositivo) {

        datiService.fixError(n);
        AutoEntity autoEntity = autoService.findByCodDispositivo(codDispositivo);
        model.put("findAuto", autoEntity);
        return "findAuto";
    }

    @RequestMapping(value = "/viewAppuntamentiOfficina", method = RequestMethod.POST)
    public String viewAppuntamentiOfficina(Map<String, Object> model,
                                           @RequestParam(name = "idOfficina") int idOfficina) {
        OfficinaEntity officinaEntity = officinaService.findByIdOfficina(idOfficina);
        List<AppuntamentoEntity> listaAppuntamenti = appuntamentoService.findByOfficinaEntity(officinaEntity);
        model.put("listaAppuntamenti", listaAppuntamenti);
        return "viewAppuntamenti";
    }

    @RequestMapping(value = "/confermaAppuntamento", method = RequestMethod.POST)
    public String confermaAppuntamento(Map<String, Object> model,
                                       @RequestParam(name = "idAppuntamento") int idAppuntamento,
                                       @RequestParam(name = "idOfficina") int idOfficina) {
        appuntamentoService.conferma(idAppuntamento);
        OfficinaEntity officinaEntity = officinaService.findByIdOfficina(idOfficina);
        List<AppuntamentoEntity> listaAppuntamenti = appuntamentoService.findByOfficinaEntity(officinaEntity);
        model.put("listaAppuntamenti", listaAppuntamenti);
        return "viewAppuntamenti";
    }

    @RequestMapping(value = "/rifiutaAppuntamento", method = RequestMethod.POST)
    public String rifiutaAppuntamento(Map<String, Object> model,
                                      @RequestParam(name = "idAppuntamento") int idAppuntamento,
                                      @RequestParam(name = "idOfficina") int idOfficina) {
        appuntamentoService.rifiuta(idAppuntamento);
        OfficinaEntity officinaEntity = officinaService.findByIdOfficina(idOfficina);
        List<AppuntamentoEntity> listaAppuntamenti = appuntamentoService.findByOfficinaEntity(officinaEntity);
        model.put("listaAppuntamenti", listaAppuntamenti);
        return "viewAppuntamenti";
    }

    @RequestMapping(value = "/viewPreventiviOfficina", method = RequestMethod.POST)
    public String viewPreventiviOfficina(Map<String, Object> model,
                                         @RequestParam(name = "idOfficina") int idOfficina) {
        OfficinaEntity officinaEntity = officinaService.findByIdOfficina(idOfficina);
        List<PreventivoEntity> listaPreventivi = preventivoService.findByOfficinaEntity(officinaEntity);
        model.put("listaPreventivi", listaPreventivi);
        return "viewPreventivi";
    }

    @RequestMapping(value = "/setCosto", method = RequestMethod.POST)
    public String setCosto(Map<String, Object> model,
                           @RequestParam(name = "idPreventivo") int idPreventivo,
                           @RequestParam(name = "idOfficina") int idOfficina,
                           @RequestParam(name = "costo") float costo) {
        preventivoService.setCosto(costo, idPreventivo);
        OfficinaEntity officinaEntity = officinaService.findByIdOfficina(idOfficina);
        List<PreventivoEntity> listaPreventivi = preventivoService.findByOfficinaEntity(officinaEntity);
        model.put("listaPreventivi", listaPreventivi);
        return "viewPreventivi";
    }

}
