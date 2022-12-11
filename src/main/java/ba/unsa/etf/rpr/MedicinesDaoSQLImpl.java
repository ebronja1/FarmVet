package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.DriverManager;
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
