package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Medicines;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

/**
 * MySQL Implementation of DAO
 * @author Emir Bronja
 */
public class MedicinesDaoSQLImpl extends AbstractDao<Medicines> implements MedicinesDao {
    public MedicinesDaoSQLImpl() {
        super("medicines");
    }

    public Medicines row2object(ResultSet rs) throws FarmVetException{
        try {
            Medicines m = new Medicines();
            m.setId(rs.getInt("medicine_id"));
            m.setMedicine(rs.getString("name"));
            m.setTaked(rs.getDate("taked"));
            m.setAnimal(DaoFactory.animalsDao().getById(rs.getInt("animal_id")));
            m.setVet(DaoFactory.vetsDao().getById(rs.getInt("vet_id")));
            return m;
        } catch (Exception e) {
            throw new FarmVetException(e.getMessage(), e);
        }
    }

    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
    @Override
    public Map<String, Object> object2row(Medicines object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("medicine_id", object.getId());
        item.put("name", object.getMedicine());
        item.put("taked", object.getTaked());
        item.put("animal_id", object.getAnimal().getId());
        item.put("vet_id", object.getVet().getId());
        return item;
    }


    /**
     * @param text search string for medicines
     * @return list of medicines
     * @author Emir Bronja
     */

    @Override
    public List<Medicines> searchByText(String text) throws FarmVetException{
        return executeQuery("SELECT * FROM medicines WHERE name LIKE concat('%', ?, '%')", new Object[]{text});
    }

    /**
     * @param animal search string for medicines
     * @return list of medicines
     * @author Emir Bronja
     */
    @Override
    public List<Medicines> searchByAnimals(Animals animal) throws FarmVetException{
        return executeQuery("SELECT * FROM medicines WHERE animal_id = ?", new Object[]{animal.getId()});
    }

    @Override
    public List<Medicines> searchByVets(Vets vet) {
        return null;
    }
}
