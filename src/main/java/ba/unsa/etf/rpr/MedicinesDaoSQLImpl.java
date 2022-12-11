package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.List;

public class MedicinesDaoSQLImpl implements MedicinesDao{
    private Connection connection;

    public MedicinesDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582258", "sql7582258", "m6JTHrdhjw");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public Medicines getById(int id) {
        String query = "SELECT * FROM medicines WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Medicines medicine = new Medicines();
                medicine.setId(rs.getInt("id"));
                medicine.setName(rs.getString("name"));
                rs.close();
                return medicine;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    @Override
    public Medicines add(Medicines item) {
        return null;
    }

    @Override
    public Medicines update(Medicines item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Medicines> getAll() {
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
