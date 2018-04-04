package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.*;
import com.contrader.contraderOBDSpringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class LoginController {

    private LoginService loginService;
    private AziendaService aziendaService;
    private AutoService autoService;
    private OfficinaService officinaService;
    private DriverService driverService;
    private DatiService datiService;
    private AppuntamentoService appuntamentoService;
    private PreventivoService preventivoService;

    @Autowired
    public LoginController(LoginService loginService, OfficinaService officinaService, AziendaService aziendaService,
                           AutoService autoService, DriverService driverService, AppuntamentoService appuntamentoService,
                           DatiService datiService, PreventivoService preventivoService) {
        this.loginService = loginService;
        this.officinaService = officinaService;
        this.aziendaService = aziendaService;
        this.autoService = autoService;
        this.driverService = driverService;
        this.datiService = datiService;
        this.appuntamentoService = appuntamentoService;
        this.preventivoService = preventivoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username", required = true) String username,
                        @RequestParam(name = "password", required = true) String password,
                        HttpServletRequest request,
                        Map<String, Object> model) {
        LoginEntity loginEntity = loginService.login(username, password);
        if (loginEntity != null) {
            if (loginEntity.getRuolo() == 1) {
                long countOfficinaAll = officinaService.countAll();
                model.put("countOfficinaAll", countOfficinaAll);
                long countAziendeAll = aziendaService.countAll();
                model.put("countAziendeAll", countAziendeAll);
                long countAutoAll = autoService.countAll();
                model.put("countAutoAll", countAutoAll);
            } else if (loginEntity.getRuolo() == 2) {
                OfficinaEntity officinaEntity = officinaService.findByIdOfficina(loginEntity.getId());
                long countAppuntamentoOfficina = appuntamentoService.countByOfficinaEntity(officinaEntity);
                model.put("countAppuntamentoOfficina", countAppuntamentoOfficina);
                long countPreventivoOfficina = preventivoService.countByOfficinaEntity(officinaEntity);
                model.put("countPreventivoOfficina", countPreventivoOfficina);
            } else if (loginEntity.getRuolo() == 3) {
                AziendaEntity aziendaEntity = aziendaService.findByIdAzienda(loginEntity.getId());
                long countAutoAzienda = autoService.countByProprietario(loginEntity.getUsername());
                model.put("countAutoAzienda", countAutoAzienda);
                long countDriverAzienda = driverService.countByAziendaEntity(aziendaEntity);
                model.put("countDriverAzienda", countDriverAzienda);
                long countAutoAziendaError = datiService.countAutoAziendaError(loginEntity.getUsername());
                model.put("countAutoAziendaError", countAutoAziendaError);

            } else if (loginEntity.getRuolo() == 4) {
                DriverEntity driver = driverService.findByIdDriver(loginEntity.getId());
                model.put("driver", driver);
                model.put("color",colorPanel(driver.getAutoEntitySet()));
            }
            model.put("user", loginEntity);
            HttpSession session = request.getSession(true);
            session.setAttribute("model", model);
            return "home";
        } else {
            return "index";
        }

    }

    public HashMap colorPanel(List<AutoEntity> autoEntitySet)
    {
        HashMap color = new HashMap();
        for (AutoEntity autoEntity:autoEntitySet) {
            List<DatiEntity> listaDati = autoEntity.getDatiEntitySet();
            DatiEntity dato = listaDati.get(listaDati.size()-1);
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

            if (data - revisione > 365 + 365 / 12 * 11) {
                color.put(autoEntity.getCodDispositivo(), "yellow");
            }
            else if (((data - tagliando) > 365 + 365 / 12 * 11) || km > 14500) {
                color.put(autoEntity.getCodDispositivo(), "yellow");
            }
            else {
                color.put(autoEntity.getCodDispositivo(), "primary");
            }
            for (DatiEntity datiEntity:autoEntity.getDatiEntitySet()) {
                if(datiEntity.getCodErrore() != null && datiEntity.isStato() == false)
                    color.put(autoEntity.getCodDispositivo(), "red");
            }

        }
        return color;
    }

}
