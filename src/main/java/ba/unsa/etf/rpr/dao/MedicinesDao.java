package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

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
     * @param animal search string for medicines
     * @return list of medicines
     */
    List<Medicines> searchByAnimals(Animals animal) throws FarmVetException;

    /**
     * Returns all medicines that contains given text.
     *
     * @param vet search string for quotes
     * @return list of medicines
     */
    List<Medicines> searchByVets(Vets vet) throws FarmVetException;

    List<Medicines> searchByText(String text) throws FarmVetException;
}
