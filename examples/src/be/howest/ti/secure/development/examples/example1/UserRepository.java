package be.howest.ti.secure.development.examples.example1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static class User{
        String id, name;
        int age;
        User(String id, String name, int age){}
        /*....*/
    }
    public List<User> getUserById(String id){
        try{
            Connection conn = MySqlConnection.getConnection();
            Statement stmt = conn.createStatement();
            String query = "Select * From users WHERE id = '%s'";
            ResultSet rs = stmt.executeQuery(String.format(query, id));
            List<User> res = new ArrayList<>();
            while(rs.next()){
                res.add(rs2u(rs));
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException("getUserById failed", ex);
        }
    }

    public User rs2u(ResultSet rs) throws SQLException {
        return new User(rs.getString("id"), rs.getString("name"), rs.getInt("age"));
    }
}
