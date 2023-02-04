package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Vets;
import ba.unsa.etf.rpr.exceptions.FarmVetException;

import java.sql.*;
import java.util.*;

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
            vet.setPassword(rs.getString("password"));
            return vet;
        } catch (SQLException e) {
            throw new FarmVetException(e.getMessage(), e);
        }
    }
    @Override
    public List<Vets> searchByName(String text) throws FarmVetException{
        return executeQuery("SELECT name FROM vets WHERE name LIKE concat('%', ?, '%')", new Object[]{text});
    }
    @Override
    public Map<String, Object> object2row(Vets object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("vet_id", object.getId());
        row.put("name", object.getName());
        return row;
    }

}
