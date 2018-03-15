package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        if ((request != null) && ((request.get("role") == null))) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            String role = loginService.login(nomeUtente, password);
            if ( role != ""){
                request.put("role", role);
                MainDispatcher.getInstance().callView("Home", request);
            }

            else
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
        else MainDispatcher.getInstance().callView("Home", request);

    }
}
