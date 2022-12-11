package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.Vets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class VetsDaoSQLImpl implements VetsDao{
    private Connection connection;

    public VetsDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582258", "sql7582258", "m6JTHrdhjw");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Vets getById(int id) {
        return null;
    }

    @Override
    public Vets add(Vets item) {
        return null;
    }

    @Override
    public Vets update(Vets item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Vets> getAll() {
        return null;
    }
}
