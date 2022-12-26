package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.domain.Vets;

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
    List<Medicines> searchByAnimals(Animals animal);
    /**
     * Returns all medicines that contains given text.
     *
     * @param vet search string for quotes
     * @return list of quotes
     */
    List<Medicines> searchByVets(Vets vet);
}
