/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.University;

/**
 *
 * @author AN
 */
public class UniversityDAO extends DBContext {

    public ArrayList<University> getAll() {
        ArrayList<University> result = new ArrayList<>();
        connection = getConnection();
        String sql = "SELECT *\n"
                + "  FROM [PRJ30x_DB1].[dbo].[tblUniversity]\n"
                + "Where status = 1";
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String shortName = resultSet.getString("shortName");
                String description = resultSet.getString("description");
                int foundedYear = resultSet.getInt("foundedYear");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String region = resultSet.getString("region");
                String type = resultSet.getString("type");
                int totalStudents = resultSet.getInt("totalStudents");
                int totalFaculties = resultSet.getInt("totalFaculties");
                boolean Draft = resultSet.getBoolean("isDraft");
                University u = new University(id, name, shortName, description, foundedYear, address, city, region, type, totalStudents, totalFaculties, Draft);
                result.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniversityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<University> searchByColum(String colum, String value) {
        ArrayList<University> result = new ArrayList<>();
        connection = getConnection();
        String sql = "SELECT *\n"
                + "  FROM [PRJ30x_DB1].[dbo].[tblUniversity]\n"
                + "  where " + colum + " = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String shortName = resultSet.getString("shortName");
                String description = resultSet.getString("description");
                int foundedYear = resultSet.getInt("foundedYear");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String region = resultSet.getString("region");
                String type = resultSet.getString("type");
                int totalStudents = resultSet.getInt("totalStudents");
                int totalFaculties = resultSet.getInt("totalFaculties");
                boolean Draft = resultSet.getBoolean("isDraft");
                University u = new University(id, name, shortName, description, foundedYear, address, city, region, type, totalStudents, totalFaculties, Draft);
                result.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniversityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<University> filterByColum(String colum, String value) {
        ArrayList<University> result = new ArrayList<>();
        connection = getConnection();
        String sql = "SELECT *\n"
                + "  FROM [PRJ30x_DB1].[dbo].[tblUniversity]\n"
                + "  where status = 1" + colum + " like ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + value + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String shortName = resultSet.getString("shortName");
                String description = resultSet.getString("description");
                int foundedYear = resultSet.getInt("foundedYear");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String region = resultSet.getString("region");
                String type = resultSet.getString("type");
                int totalStudents = resultSet.getInt("totalStudents");
                int totalFaculties = resultSet.getInt("totalFaculties");
                boolean Draft = resultSet.getBoolean("isDraft");
                University u = new University(id, name, shortName, description, foundedYear, address, city, region, type, totalStudents, totalFaculties, Draft);
                result.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniversityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<University> searchByID(String ID) {
        return searchByColum("id", ID);
    }

    public ArrayList<University> searchByName(String name) {
        return searchByColum("name", name);
    }

    public ArrayList<University> searchByShortName(String shortName) {
        return searchByColum("shortName", shortName);
    }

    public ArrayList<University> filterByName(String name) {
        return filterByColum("name", name);
    }

    public boolean softDelete(String id) {
        int resultSet = 0;
        connection = getConnection();
        String sql = "UPDATE [dbo].[tblUniversity]\n"
                + "   SET [status] = 0\n"
                + " WHERE id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniversityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet > 0;
    }
}
