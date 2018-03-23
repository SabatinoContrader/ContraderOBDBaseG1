package com.virtualpairprogrammers.services;

import java.sql.ResultSet;
import java.util.List;

import com.virtualpairprogrammers.dao.Dati_DispositivoDAO;
import com.virtualpairprogrammers.dao.LoginDAO;
import com.virtualpairprogrammers.domain.Officina;

public class Dati_DispositivoService {
	
	 private Dati_DispositivoDAO dati_DispositivoDAO;
	    private static Dati_DispositivoService reference;

	    public static Dati_DispositivoService getService()
	    {
	        if (reference == null)
	            reference = new Dati_DispositivoService();
	        return reference;
	    }

	    public Dati_DispositivoService() {
	        this.dati_DispositivoDAO = new Dati_DispositivoDAO();
	    }

	    public ResultSet listaAutoErrori (String proprietario) {
	        return this.dati_DispositivoDAO.listaAutoErrori(proprietario);
	        	
	    }
}
