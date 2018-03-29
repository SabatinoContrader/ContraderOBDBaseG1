package com.virtualpairprogrammers.services;

import java.util.List;

import com.virtualpairprogrammers.dao.DriverDAO;
import com.virtualpairprogrammers.domain.Driver;

public class DriverService {

	
	private DriverDAO driverDAO;
    private static DriverService reference ;

    public DriverService(){
    	this.driverDAO = new DriverDAO();
    }
    
    public static DriverService getService()
    {
        if (reference == null)
            reference = new DriverService();
        return reference;
    }

    public List<Driver> getAllDriver(int id_azienda){
    	
    	return this.driverDAO.getAllDriver(id_azienda);
    	
    }

    public boolean insertDriver(Driver driver) {
        return this.driverDAO.insertDriver(driver);
    }

}
