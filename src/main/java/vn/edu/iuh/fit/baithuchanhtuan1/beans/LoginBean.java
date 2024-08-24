package vn.edu.iuh.fit.baithuchanhtuan1.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginBean {
    public int loginValidation(String us, String pw) {

        try (Connection conn = ConnectDB.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM logindb");

            while (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");

                if (us.equals(user) && pw.equals(pass)) {
                    return 1;
                } else if (us.equals(user) && !pw.equals(pass)) {
                    return 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Database connection problem: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
