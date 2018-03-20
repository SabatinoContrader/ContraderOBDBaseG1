package main.service;

import main.dao.DriverDAO;
import main.model.Driver;

public class DriverService {

    private DriverDAO driverDAO;

   public DriverService(){
       driverDAO = new DriverDAO();
   }

    public boolean insertDriver (Driver driver) {
        return this.driverDAO.insertDriver(driver);
    }



    public int updateAutoDriverDAO(int Id_Driver, int Auto){

       return this.driverDAO.updateAutoDriver(Id_Driver, Auto);
    }
}
