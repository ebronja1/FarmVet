package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.Animals;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalsDaoSQLImpl implements AnimalsDao {
    private Connection connection;

    public AnimalsDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582258", "sql7582258", "m6JTHrdhjw");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public Animals getById(int id) {
        String query = "SELECT * FROM animals WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Animals animal = new Animals();
                animal.setId(rs.getInt("id"));
                animal.setName(rs.getString("name"));
                rs.close();
                return animal;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    @Override
    public Animals add(Animals item) {
        String insert = "INSERT INTO animals(name) VALUES(?)";
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
    public Animals update(Animals item) {
        String insert = "UPDATE animals SET name = ? WHERE id = ?";
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

    }

    @Override
    public List<Animals> getAll() {
        return null;
    }
}
