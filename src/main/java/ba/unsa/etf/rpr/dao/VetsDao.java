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
     * Returns all names that equals given text.
     *
     * @param text search string for vets
     * @return list of vets
     */
    List<Vets> searchByName(String text) throws FarmVetException;
    /**
     * Returns all name that equals given text.
     *
     * @param text search string for vets
     * @return list of vets
     */
    List<Vets> searchByPassword(String text) throws FarmVetException;
}
