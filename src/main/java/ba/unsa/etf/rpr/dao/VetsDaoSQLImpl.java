package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.sql.*;
import java.util.*;

public class VetsDaoSQLImpl extends AbstractDao<Vets> implements VetsDao {
    public static VetsDaoSQLImpl instance = null;
    private VetsDaoSQLImpl() {
        super("vets");
    }
    public static VetsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new VetsDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Vets row2object(ResultSet rs) throws FarmVetException {
        try {
            Vets vet = new Vets();
            vet.setId(rs.getInt("id"));
            vet.setName(rs.getString("name"));
            vet.setPassword(rs.getString("password"));
            return vet;
        } catch (SQLException e) {
            throw new FarmVetException(e.getMessage(), e);
        }
    }
    @Override
    public List<Vets> searchByName(String text) throws FarmVetException{
        return executeQuery("SELECT * FROM vets WHERE name = ?", new Object[]{text});
    }
    @Override
    public List<Vets> searchByPassword(String text) throws FarmVetException{
        return executeQuery("SELECT * FROM vets WHERE password = ?", new Object[]{text});
    }
    @Override
    public Map<String, Object> object2row(Vets object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        row.put("password",object.getPassword());
        return row;
    }

}
