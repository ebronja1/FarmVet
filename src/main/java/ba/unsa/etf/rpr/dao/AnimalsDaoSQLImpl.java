package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Animals;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.sql.*;
import java.util.*;

public class AnimalsDaoSQLImpl extends AbstractDao<Animals> implements AnimalsDao {
    public static AnimalsDaoSQLImpl instance = null;
    private AnimalsDaoSQLImpl() {
        super("animals");
    }
    public static AnimalsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new AnimalsDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }
    @Override
    public Animals row2object(ResultSet rs) throws FarmVetException {
        try {
            Animals animal = new Animals();
            animal.setId(rs.getInt("id"));
            animal.setName(rs.getString("name"));
            animal.setKind(rs.getString("kind"));
            return animal;
        } catch (SQLException e) {
            throw new FarmVetException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Animals object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        row.put("kind", object.getKind());
        return row;
    }
}
