package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * MySQL Implementation of DAO
 * @author Emir Bronja
 */
public class MedicinesDaoSQLImpl extends AbstractDao<Medicines> implements MedicinesDao {
    public MedicinesDaoSQLImpl() {
        super("medicines");
    }

    @Override
    public Medicines row2object(ResultSet rs) throws FarmVetException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Medicines object) {
        return null;
    }

    @Override
    public List<Medicines> searchByAnimals(Animals animal) {
        return null;
    }

    @Override
    public List<Medicines> searchByVets(Vets vet) {
        return null;
    }
}
