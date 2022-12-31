package ba.unsa.etf.rpr.dao;

import java.sql.Connection;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Emir Bronja
 */
public class DaoFactory {

    private static final AnimalsDao categoryDao = new AnimalsDaoSQLImpl();
    private static final MedicinesDao quoteDao = new MedicinesDaoSQLImpl();
    private static final VetsDao quoteHistoryDao = new VetsDaoSQLImpl();


    private DaoFactory() {
    }
}
