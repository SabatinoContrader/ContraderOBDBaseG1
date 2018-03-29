package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.AziendaDAO;
import com.virtualpairprogrammers.domain.Azienda;

import java.util.List;

public class AziendaService {

    private AziendaDAO aziendaDAO;
    private static AziendaService reference;

    public static AziendaService getService()
    {
        if (reference == null)
            reference = new AziendaService();
        return reference;
    }

    public AziendaService() {
        this.aziendaDAO = new AziendaDAO();
    }

    public int insertAzienda (Azienda azienda) {
        return this.aziendaDAO.insertAzienda(azienda);
    }

    public List<Azienda> listAzienda () {
        return this.aziendaDAO.listAzienda();
    }
}
