package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.AutoDAO;
import com.virtualpairprogrammers.domain.Auto;


public class AutoService {

    private AutoDAO autoDAO;
    private static AutoService reference;

    public static AutoService getService()
    {
        if (reference == null)
            reference = new AutoService();
        return reference;
    }

    public AutoService(){
        this.autoDAO = new AutoDAO();
    }

    public boolean AssegnaAutoDriver(int id_driver, int id_auto){
        return this.autoDAO.updateAutoDriver(id_driver,id_auto);
    }

    public boolean InsertAuto(Auto auto){
        return this.autoDAO.insertAuto(auto);
    }

    public boolean updateAuto (Auto auto) {
        return this.autoDAO.updateAuto(auto);
    }
    public boolean resetAuto(int cod_Dispositivo) { return this.autoDAO.resetAuto(cod_Dispositivo);};

}
