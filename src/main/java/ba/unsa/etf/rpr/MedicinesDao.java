package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.Vets;
import ba.unsa.etf.rpr.Animals;

import java.util.List;

/**
 * Dao interface for Medicines bean
 *
 * @author Emir Bronja
 */
public interface MedicinesDao extends Dao<Medicines> {
    /**
     * Returns all medicines that contains given text.
     *
     * @param animal search string for quotes
     * @return list of quotes
     */
    List<Medicines> searchByCategory(Animals animal);
    /**
     * Returns all medicines that contains given text.
     *
     * @param vet search string for quotes
     * @return list of quotes
     */
    List<Medicines> searchByCategory(Vets vet);
}
