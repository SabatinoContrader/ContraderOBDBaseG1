package main.service;

import main.dao.LoginDAO;
import main.model.Login;


import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private LoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public HashMap login (String username, String password) {
        return this.loginDAO.login(username, password);
    }

    public boolean InsertLogin (Login login) {
        return this.loginDAO.insertLogin(login);
    }
}
