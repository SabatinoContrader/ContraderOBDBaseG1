package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.AutoDAO;
import com.virtualpairprogrammers.dao.CountDAO;
import com.virtualpairprogrammers.domain.Auto;

import java.util.List;


public class CountService {

    private CountDAO countDAO;
    private static CountService reference;

    public static CountService getService()
    {
        if (reference == null)
            reference = new CountService();
        return reference;
    }

    public CountService(){
        this.countDAO = new CountDAO();
    }

    public int countOfficina(){
        return this.countDAO.countOfficina();
    }

    public int countAuto(){
        return this.countDAO.countAuto();
    }

    public int countAzienda(){
        return this.countDAO.countAzienda();
    }

    public int countMyAuto(String username){
        return this.countDAO.countMyAuto(username);
    }

    public int countMyDriver(int id){
        return this.countDAO.countMyDriver(id);
    }

    public int countAziendaError(String username){
        return this.countDAO.countAziendaError(username);
    }
}
