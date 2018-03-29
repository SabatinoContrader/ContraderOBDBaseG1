package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.LoginEntity;
import com.contrader.contraderOBDSpringboot.service.AutoService;
import com.contrader.contraderOBDSpringboot.service.AziendaService;
import com.contrader.contraderOBDSpringboot.service.LoginService;
import com.contrader.contraderOBDSpringboot.service.OfficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class LoginController {

    private LoginService loginService;
    private AziendaService aziendaService;
    private AutoService autoService;
    private OfficinaService officinaService;

    @Autowired
    public LoginController(LoginService loginService, OfficinaService officinaService, AziendaService aziendaService, AutoService autoService) {
        this.loginService = loginService;
        this.officinaService = officinaService;
        this.aziendaService = aziendaService;
        this.autoService = autoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username", required = true) String username,
                        @RequestParam(name = "password", required = true) String password,
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

            } else if (loginEntity.getRuolo() == 3) {

            } else if (loginEntity.getRuolo() == 4) {

            }
            model.put("user", loginEntity);
            return "home";
        } else {
            return "index";
        }

    }

}
