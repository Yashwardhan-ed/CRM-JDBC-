package com.crm.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crm.model.User;

public class UserDAO {
    public List<User> getAllUsers(Connection conn){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";

        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                User user = new User(
                    rs.getInt("UserID"),
                    rs.getString("FullName"),
                    rs.getString("Email"),
                    rs.getInt("RoleID")
                );      
                users.add(user);     
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return users;
    }
}
