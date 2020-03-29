package daos;

import models.Cars;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DAOConc implements DAO {


    private Cars extractUserFromResultSet(ResultSet rs) throws SQLException {
        Cars cars = new Cars();
        cars.setId(rs.getInt("id"));
        cars.setColor(rs.getString("color"));
        cars.setMake(rs.getString("make"));
        cars.setModel(rs.getString("model"));
        cars.setVin(rs.getString("vin"));
        cars.setYear(rs.getInt("year"));
        return cars;
    }

    public Cars findById(int id) {
        Connection connection = getConnection.getConnection();
        try{

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars WHERE id=" + id);

            if(rs.next())
            {
                Cars cars = new Cars();
                cars.setId(rs.getInt("id"));
                cars.setColor(rs.getString("color"));
                cars.setMake(rs.getString("make"));
                cars.setModel(rs.getString("model"));
                cars.setVin(rs.getString("vin"));
                cars.setYear(rs.getInt("year"));

                return cars;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List findAll() {
        Connection connection = getConnection.getConnection();

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars");


            List<Cars> derp = new LinkedList<>();

            while(rs.next()){
                Cars cars = extractUserFromResultSet(rs);

                derp.add(cars);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
            return null;
    }


    public boolean update(Cars cars) {
        Connection connection = getConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cars SET make=?, model=?, year=? , color =?, vin =? WHERE id=?");
            ps.setString(1, cars.getMake());
            ps.setString(2, cars.getModel());
            ps.setInt(3, cars.getYear());
            ps.setString(4, cars.getColor());
            ps.setString(5,cars.getVin());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean create(Cars cars) {
        Connection connection = getConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?,?,?)");
            ps.setString(1, cars.getMake());
            ps.setString(2, cars.getModel());
            ps.setInt(3, cars.getYear());
            ps.setString(4, cars.getColor());
            ps.setString(5,cars.getVin());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void delete(int id) {
        Connection connection = getConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM user WHERE id=" + id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
