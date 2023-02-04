package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.util.List;

/**
 * Dao interface for Vets bean
 *
 * @author Emir Bronja
 */
public interface VetsDao extends Dao<Vets> {
    /**
     * Returns all names that contains given text.
     *
     * @param text search string for vets
     * @return list of vets
     */
    List<Vets> searchByName(String text) throws FarmVetException;
}
