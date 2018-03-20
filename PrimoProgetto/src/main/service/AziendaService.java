package main.service;
import main.dao.AziendaDAO;
import main.model.Azienda;


public class AziendaService {

    private AziendaDAO aziendaDAO;

    public AziendaService() {
        this.aziendaDAO = new AziendaDAO();
    }

    public int insertAzienda (Azienda azienda) {
        return this.aziendaDAO.insertAzienda(azienda);
    }
}
