package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.util.List;

/**
 * Business Logic Layer for management of Animals
 *
 * @author Emir Bronja
 */
public class AnimalsManager {

    public void validateAnimalsName(String name) throws FarmVetException {
        if (name == null || name.length() > 45 || name.length() < 3) {
            throw new FarmVetException("Animal's name must be between 3 and 45 chars");
        }
    }


    public Animals add(Animals animal) throws FarmVetException {
        if (animal.getId() != 0) {
            throw new FarmVetException("Can't add category with ID. ID is autogenerated");
        }
        validateAnimalsName(animal.getName());

        try {
            return DaoFactory.animalsDao().add(animal);
        } catch (FarmVetException e) {
            if (e.getMessage().contains("UQ_NAME")) {
                throw new FarmVetException("Category with same name exists");
            }
            throw e;
        }
    }

    public void delete(int animalsId) throws FarmVetException {
        try {
            DaoFactory.animalsDao().delete(animalsId);
        } catch (FarmVetException e) {
            if (e.getMessage().contains("FOREIGN KEY")) {
                throw new FarmVetException("Cannot delete animal which is related to medicines. First delete related meidicnes before deleting animal.");
            }
            throw e;
        }
    }


    public Animals update(Animals animal) throws FarmVetException{
        validateAnimalsName(animal.getName());
        return DaoFactory.animalsDao().update(animal);
    }
}