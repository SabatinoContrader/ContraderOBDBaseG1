package main.service;

import main.dao.OfficinaDAO;
import main.model.Officina;

import java.util.List;

public class OfficinaService {


    private OfficinaDAO officinaDAO;

    public OfficinaService(){
        this.officinaDAO = new OfficinaDAO();
    }

    public int insertOfficina (Officina officina) {
        return this.officinaDAO.insertOfficina(officina);
    }
}
