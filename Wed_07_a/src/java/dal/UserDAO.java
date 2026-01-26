/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author AN
 */
public class UserDAO extends DBContext {

    public boolean login(User user) {
        User userDB = findUserByUserID(user.getUserID());
        if(userDB == null){
            return false;
        }
        if(user.getPassword().equals(userDB.getPassword())){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean checkStatus(User user){
        User userDB = findUserByUserID(user.getUserID());
        if(login(user) && userDB.isStatus()){
            return true;
        }else{
            return false;
        }
    }
    public User findUserByUserID(String userID) {
        User user = null;
        connection = getConnection();
        String sql = "SELECT *\n"
                + "  FROM [dbo].[tblUsers]\n"
                + "  Where userID=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userID);
            resultSet = statement.executeQuery();           
            while(resultSet.next()){
                String username = resultSet.getString("userID");
                String fullName = resultSet.getString("fullName");
                String password = resultSet.getString("password");
                boolean status = resultSet.getBoolean("status");
                user = new User(username, fullName, password, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
