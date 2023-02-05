package ba.unsa.etf.rpr.dao;

import java.sql.Connection;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Emir Bronja
 */
public class DaoFactory {

    private static final AnimalsDao animalsDao = new AnimalsDaoSQLImpl();
    private static final MedicinesDao medicinesDao = MedicinesDaoSQLImpl.getInstance();
    private static final VetsDao vetsDao = VetsDaoSQLImpl.getInstance();


    private DaoFactory() {
    }
    public static AnimalsDao animalsDao(){
        return animalsDao;
    }
    public static MedicinesDao medicinesDao(){
        return medicinesDao;
    }

    public static VetsDao vetsDao(){
        return vetsDao;
    }
}
