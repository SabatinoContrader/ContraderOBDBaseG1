package main.service;

import main.dao.DatiDAO;
import main.model.Dati_dispositivo;
import main.model.Driver;

import java.util.List;

public class DatiService {

    private DatiDAO datiDAO;

    public DatiService(){
       datiDAO = new DatiDAO();
   }

    public List<Dati_dispositivo> listaAllDatiDispositivo (int cod_dispositivo) {
        return this.datiDAO.listaAllDatiDispositivo(cod_dispositivo);
    }

    public List<String> listaDatiDispositivo (int cod_dispositivo) {
        return this.datiDAO.listaDatiDispositivo(cod_dispositivo);
    }

}
