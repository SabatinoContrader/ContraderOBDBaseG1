package com.vianelloProjectJsp.services;


import com.vianelloProjectJsp.dao.LoginDAO;
import com.vianelloProjectJsp.model.Utente;

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

    public Utente login (String email, String password) {
        return this.loginDAO.logIn(email, password);
    }
}
	