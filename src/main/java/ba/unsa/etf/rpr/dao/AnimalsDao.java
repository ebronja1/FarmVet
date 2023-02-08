package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.util.List;

/**
 * Dao interface for Vets bean
 *
 * @author Emir Bronja
 */
public interface AnimalsDao extends Dao<Animals> {
    /**
     * Returns all animals that equals given text.
     *
     * @param text search string for vets
     * @return list of vets
     */
    List<Animals> searchByName(String text) throws FarmVetException;
}
