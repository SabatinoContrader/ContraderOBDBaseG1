package com.virtualpairprogrammers.services;


import com.virtualpairprogrammers.dao.LoginDAO;
import com.virtualpairprogrammers.domain.Login;

import java.util.HashMap;

public class LoginService {

    private LoginDAO loginDAO;
    private static LoginService reference;

    public static LoginService getService()
    {
        if (reference == null)
            reference = new LoginService();
        return reference;
    }


    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public String login (String username, String password) {
        return this.loginDAO.login(username, password);
    }

    public boolean InsertLogin (Login login) {
        return this.loginDAO.insertLogin(login);
    }
}

