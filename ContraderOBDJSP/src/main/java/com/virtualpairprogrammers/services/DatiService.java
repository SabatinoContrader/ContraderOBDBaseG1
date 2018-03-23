package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.DatiDAO;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.domain.Dati_dispositivo;

import java.util.List;

public class DatiService {

    private DatiDAO datiDAO;

    public DatiService(){
       datiDAO = new DatiDAO();
   }

    public List<Dati_dispositivo> listaAllDatiDispositivo (int cod_dispositivo) {
        System.out.println("Sei nella service dati");
        return this.datiDAO.listaAllDatiDispositivo(cod_dispositivo);
    }

    public List<String> listaDatiDispositivo (int cod_dispositivo) {
        return this.datiDAO.listaDatiDispositivo(cod_dispositivo);
    }

}
