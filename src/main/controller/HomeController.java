package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

import java.util.HashMap;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        if ((request != null) && ((request.get("role") == null))) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            HashMap hash = loginService.login(nomeUtente, password);
            if ( !hash.isEmpty()){
                request.put("role", hash.get("role"));
                request.put("id", hash.get("id"));
                MainDispatcher.getInstance().callView("Home", request);
            }

            else
                MainDispatcher.getInstance().callView("Login",  null);
        }
        else MainDispatcher.getInstance().callView("Home", request);

    }
}
