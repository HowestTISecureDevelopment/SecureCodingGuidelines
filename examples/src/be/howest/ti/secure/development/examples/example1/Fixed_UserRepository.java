package be.howest.ti.secure.development.examples.example1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Based on the "Voorbeeld_Examen_Vraag.pdf" by Mattias

public class Fixed_UserRepository {
    public static class User{
        String id, name;
        int age;
        User(String id, String name, int age){}
        /*....*/
    }
    public List<User> getUserById(String id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = MySqlConnection.getConnection();
            /*  Dynamic SQL, SQL injection
             *  This can be attacked with input id = "' or 1=1 or id='"
             *  and return all possible statements.
             *  Fixed by using prepared statements
             *  todo fix sqlinjection
             */
            stmt = conn.createStatement();
            String query = "Select * From users WHERE id = ?";
            rs = stmt.executeQuery(String.format(query, id));
            List<User> res = new ArrayList<>();
            while(rs.next()){
                res.add(rs2u(rs));
            }
            /*  Resources are not released -> DOS attack (mem leaks)
            *   Use try with resources, close conn, stmt and rs.
            */
        } catch (SQLException e) {
            /*
             *  possible sensitive exception
             */

            //throw new RuntimeException("getUserById failed", ex);
            throw new RuntimeException("Error trying to get the user.");
        }finally{
            try {
                if(rs != null) { rs.close(); }
            } catch (SQLException e) {
                //e.printStackTrace(); //g2_01
            }finally {
                try {
                    if (stmt != null) { stmt.close(); }
                } catch (SQLException e) {
                    //e.printStackTrace(); //g2_01
                }finally {
                    try {
                        if (conn != null) { conn.close(); }
                    } catch (SQLException e) {
                        //e.printStackTrace(); //g2_01
                    }
                }
            }
        }
    }

    private User rs2u(ResultSet rs) throws SQLException {
        //  This doesn't need to be public, change to private
        return new User(rs.getString("id"), rs.getString("name"), rs.getInt("age"));
    }
}
