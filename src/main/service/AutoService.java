package main.service;

import main.dao.AutoDAO;
import main.model.Auto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public boolean updateAuto (Auto auto) {
        return this.autoDAO.updateAuto(auto);
    }

    public boolean resetAuto (int cod_Dispositivo) {
        return this.autoDAO.resetAuto(cod_Dispositivo);
    }

    public HashMap findAuto (int cod_Dispositivo) {
        return this.autoDAO.findAuto(cod_Dispositivo);
    }
}


