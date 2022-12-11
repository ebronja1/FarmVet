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
        String query = "SELECT * FROM vets WHERE id = ?";
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
        String insert = "INSERT INTO vets(name) VALUES(?)";
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
        String insert = "UPDATE vets SET name = ? WHERE id = ?";
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
        String insert = "DELETE FROM vets WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Vets> getAll() {
        String query = "SELECT * FROM vets";
        List<Vets> vets = new ArrayList<Vets>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){ // result set is iterator.
                Vets vet = new Vets();
                vet.setId(rs.getInt("id"));
                vet.setName(rs.getString("name"));
                vets.add(vet);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return vets;
    }
}
