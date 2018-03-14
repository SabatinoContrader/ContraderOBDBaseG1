package main.service;

import main.dao.AutoDAO;
import main.model.Auto;

import java.util.List;

public class AutoService {

    private AutoDAO autoDAO;

    public AutoService() {
        this.autoDAO = new AutoDAO();
    }

    public List<Auto> getAllAuto () {
        return this.autoDAO.getAllAuto();
    }

    public boolean insertAuto (Auto auto) {
        return this.autoDAO.insertAuto(auto);
    }
}


