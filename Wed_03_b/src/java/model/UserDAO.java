/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBContext;

/**
 *
 * @author AN
 */
public class UserDAO extends DBContext {

    ArrayList<UserDTO> list = new ArrayList<>();

    public UserDTO searchByUsername(String username) {
        connection = getConnection();
        String sql = "SELECT * FROM [dbo].[tblUsers]\n"
                + "  where userID = ?";
        UserDTO user = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String userId = resultSet.getString("userID");
                String fullname = resultSet.getString("fullName");
                String password = resultSet.getString("password");
                String role = resultSet.getString("roleID");
                boolean status = resultSet.getBoolean("status");
                user = new UserDTO(userId, fullname, password, role, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return user;
    }

    public UserDTO login(String username, String password) {
        UserDTO u = searchByUsername(username);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        } else {
            return null;
        }
    }
}
