package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
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
        String insert = "INSERT INTO medicines(name) VALUES(?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getName());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            item.setId(rs.getInt(1)); //set id to return it back
            return item;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Medicines update(Medicines item) {
        String insert = "UPDATE medicines SET name = ? WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, item.getName());
            stmt.setObject(2, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(int id) {
        String insert = "DELETE FROM medicines WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Medicines> getAll() {
        String query = "SELECT * FROM medicines";
        List<Medicines> medicines = new ArrayList<Medicines>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){ // result set is iterator.
                Medicines medicine = new Medicines();
                medicine.setId(rs.getInt("id"));
                medicine.setName(rs.getString("name"));
                medicines.add(medicine);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return medicines;
    }

    @Override
    public List<Medicines> searchByAnimals(Animals animal) {
        String query = "SELECT * FROM medicines WHERE animal_id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, animal.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Medicines> medicinesList = new ArrayList<>();
            while (rs.next()) {
                Medicines m = new Medicines();
                m.setId(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setVet_id(rs.getInt(3));
                m.setAnimal_id(rs.getInt(4));
                medicinesList.add(m);
            }
            return medicinesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Medicines> searchByVets(Vets vet) {
        String query = "SELECT * FROM medicines WHERE vet_id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, vet.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Medicines> medicinesList = new ArrayList<>();
            while (rs.next()) {
                Medicines m = new Medicines();
                m.setId(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setVet_id(rs.getInt(3));
                m.setAnimal_id(rs.getInt(4));
                medicinesList.add(m);
            }
            return medicinesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
