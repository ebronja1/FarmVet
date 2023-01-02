package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Animals;
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
}
