package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

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
    public List<Medicines> searchByVets(Vets vet) throws FarmVetException {
        return DaoFactory.medicinesDao().searchByVets(vet);
    }
    public void delete(int id) throws FarmVetException{
        DaoFactory.medicinesDao().delete(id);
    }

    public Medicines getById(int medicineId) throws FarmVetException{
        return DaoFactory.medicinesDao().getById(medicineId);
    }

    public void update(Medicines m) throws FarmVetException{
        DaoFactory.medicinesDao().update(m);
    }

    public Medicines add(Medicines m) throws FarmVetException{
        return DaoFactory.medicinesDao().add(m);
    }
}
