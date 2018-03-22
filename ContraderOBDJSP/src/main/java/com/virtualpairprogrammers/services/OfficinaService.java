package com.virtualpairprogrammers.services;


import com.virtualpairprogrammers.dao.LoginDAO;
import com.virtualpairprogrammers.dao.OfficinaDAO;
import com.virtualpairprogrammers.domain.Officina;

import java.util.List;

public class OfficinaService {

    private OfficinaDAO officinaDAO;
    private static OfficinaService reference;

    public static OfficinaService getService()
    {
        if (reference == null)
            reference = new OfficinaService();
        return reference;
    }

    public OfficinaService() {
        this.officinaDAO = new OfficinaDAO();
    }

    public int addOfficina (Officina officina) {
        return this.officinaDAO.addOfficina(officina);
    }

    public List<Officina> listOfficina () {
        return this.officinaDAO.listOfficina();
    }

    public List<Officina> listOfficina (String citta) {
        return this.officinaDAO.listOfficina(citta);
    }
}
