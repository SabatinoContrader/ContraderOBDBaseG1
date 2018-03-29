package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.AutoDAO;
import com.virtualpairprogrammers.domain.Auto;

import java.util.List;


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

    public boolean resetAuto(int cod_Dispositivo) {
        return this.autoDAO.resetAuto(cod_Dispositivo);
    }

    public List<Auto> listaAutoDriver(int id_driver) {
        return this.autoDAO.listaAutoDriver(id_driver);
    }

    public Auto findAuto (int cod_Dispositivo) {
        return this.autoDAO.findAuto(cod_Dispositivo);
    }

    public boolean terminaAssegnazioneAutoDriver(int cod_dispositivo, String proprietario) {
        return this.autoDAO.terminaAssegnazioneAutoDriver(cod_dispositivo, proprietario);
    }

    public List<Auto> listaAutoAzienda(String proprietario) {
        return this.autoDAO.listaAutoAzienda(proprietario);
    }
}
