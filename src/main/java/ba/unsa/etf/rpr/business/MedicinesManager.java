package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.util.Date;
import java.util.List;

/**
 * Business Logic Layer for Medicines
 *
 * @author Emir Bronja
 */
public class MedicinesManager {

    public List<Medicines> getAll() throws FarmVetException {
        return DaoFactory.medicinesDao().getAll();
    }

    public List<Medicines> searchMedicines(String text) throws FarmVetException {
        return DaoFactory.medicinesDao().searchByText(text);
    }


}
