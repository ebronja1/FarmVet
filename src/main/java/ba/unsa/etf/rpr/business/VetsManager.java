package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.util.List;

/**
 * Business Logic Layer for management of Medicines
 *
 * @author Emir Bronja
 */

public class VetsManager {
    public void validateVetsName(String name) throws FarmVetException {
        if (name == null || name.length() > 45 || name.length() < 3) {
            throw new FarmVetException("Vet's name must be between 3 and 45 chars");
        }
    }

    public Vets add(Vets vet) throws FarmVetException {
        if (vet.getId() != 0) {
            throw new FarmVetException("Can't add vet with ID. ID is autogenerated");
        }
        validateVetsName(vet.getName());

        try {
            return DaoFactory.vetsDao().add(vet);
        } catch (FarmVetException e) {
            if (e.getMessage().contains("UQ_NAME")) {
                throw new FarmVetException("Vet with same name exists");
            }
            throw e;
        }
    }

    public Vets update(Vets vet) throws FarmVetException{
        validateVetsName(vet.getName());
        return DaoFactory.vetsDao().update(vet);
    }

    public List<Vets> getAll() throws FarmVetException{
        return DaoFactory.vetsDao().getAll();
    }
    public List<Vets> searchByName(String text) throws FarmVetException {
        return DaoFactory.vetsDao().searchByName(text);
    }
    public List<Vets> searchByUserName(String text) throws FarmVetException {
        return DaoFactory.vetsDao().searchByUserName(text);
    }
    public List<Vets> searchByPassword(String text) throws FarmVetException {
        return DaoFactory.vetsDao().searchByPassword(text);
    }
}
