package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VetsDaoSQLImpl extends AbstractDao<Vets> implements VetsDao {

    public VetsDaoSQLImpl() {
        super("vets");
    }

    @Override
    public Vets row2object(ResultSet rs) throws FarmVetException {
        try {
            Vets vet = new Vets();
            vet.setId(rs.getInt("vet_id"));
            vet.setName(rs.getString("name"));
            return vet;
        } catch (SQLException e) {
            throw new FarmVetException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Vets object) {
        return null;
    }
}
