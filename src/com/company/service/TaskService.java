package com.company.service;

import com.company.MariaDbConstant;
import com.company.user.task.Task;

import java.sql.*;

public class TaskService {
    public static final TaskService instance = new TaskService();

    private TaskService() {
    }

    public void create(Task task) {
        try (Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL, MariaDbConstant.USER, MariaDbConstant.PASS)) {
            if (conn != null){
                String query = "INSERT INTO task(name,state,user_id) VALUES (?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1,task.getName());
                preparedStatement.setString(2,task.getState());
                preparedStatement.setInt(3,task.getUserId());
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            System.out.println("!!!!!!");
        }
    }

    public Task findTaskById(int id){
        Task task = new Task();
        try(Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL,MariaDbConstant.USER,MariaDbConstant.PASS)){
            if(conn != null){
                String query = "SELECT * FROM task WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    task.setName(resultSet.getString("name"));
                    task.setState(resultSet.getString("state"));
                    task.setUserId(resultSet.getInt("user_id"));
                }
                resultSet.close();
                return task;
            }
        }catch (SQLException ex){
            System.out.println("!!!!!!");
        }
        return null;
    }

    public void update(int id,Task task){
        try (Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL, MariaDbConstant.USER, MariaDbConstant.PASS)) {
            if (conn != null) {
                String query = "UPDATE task SET name = ?,state = ?,user_id = ? WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, task.getName());
                preparedStatement.setString(2, task.getState());
                preparedStatement.setInt(3,task.getUserId());
                preparedStatement.setInt(4, id);
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            System.out.println("!!!!!");
        }
    }

    public void delete(int id){
        try(Connection conn = DriverManager.getConnection(MariaDbConstant.DB_URL,MariaDbConstant.USER,MariaDbConstant.PASS)){
            if (conn != null){
                String query = "DELETE FROM task WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            }
        }catch (SQLException ex){
            System.out.println("!!!!!");
        }
    }
}
