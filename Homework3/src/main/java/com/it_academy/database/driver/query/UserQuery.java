package com.it_academy.database.driver.query;
import com.it_academy.database.driver.tables.User;

import java.sql.*;
import java.util.ArrayList;

import static com.it_academy.database.driver.service.DriverConnection.*;

public class UserQuery {

    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;

    public void addUserToDataBase(User user, Connection connection) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO Users (userId, name, address) VALUES ( ?, ?, ?)");
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStatement(preparedStatement);
        }
    }

    public ArrayList<String> checkUserId(Connection connection) throws SQLException {
        ArrayList<String> userIdList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT userId FROM Users");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            userIdList = new ArrayList<>(columnCount);
            while (resultSet.next()) {
                int i = 1;
                while (i <= columnCount) {
                    userIdList.add(resultSet.getString(i++));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStatement(statement);
        }
        return (userIdList);
    }
}
