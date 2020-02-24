package com.company.service;

import com.company.MariaDbConstant;
import com.company.user.task.User;

import java.sql.*;

public class UserService {
    public static UserService instance = new UserService();

    private UserService() {
    }

    public void create(User user) {
        try (Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL, MariaDbConstant.USER, MariaDbConstant.PASS)) {
            if (conn != null) {
                String query = "INSERT INTO user(name,surname) VALUES (?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            System.out.println("!!!!!!");
        }
    }

    public User findUserById(int id) {
        User user = new User();
        try (Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL, MariaDbConstant.USER, MariaDbConstant.PASS)) {
            if (conn != null) {
                String query = "SELECT * FROM user WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    user.setName(resultSet.getString("name"));
                    user.setUsername(resultSet.getString("surname"));
                }
                resultSet.close();
                return user;
            }
        } catch (SQLException ex) {
            System.out.println("!!!!!");
        }
        return null;
    }

    public void update(int id, User user) {
        try (Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL, MariaDbConstant.USER, MariaDbConstant.PASS)) {
            if (conn != null) {
                String query = "UPDATE user SET name = ?,surname = ? WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setInt(3, id);
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            System.out.println("!!!!!");
        }
    }

    public void delete(int id){
        try(Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL,MariaDbConstant.USER,MariaDbConstant.PASS)){
            if (conn != null){
                String query = "DELETE FROM user WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            }
        }catch (SQLException ex){
            System.out.println("!!!!!");
        }
    }
}
