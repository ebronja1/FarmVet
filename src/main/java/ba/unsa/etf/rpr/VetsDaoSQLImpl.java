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
        String query = "SELECT * FROM categories WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Vets vet = new Vets();
                vet.setId(rs.getInt("id"));
                vet.setName(rs.getString("name"));
                rs.close();
                return vet;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    @Override
    public Vets add(Vets item) {
        String insert = "INSERT INTO categories(name) VALUES(?)";
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
