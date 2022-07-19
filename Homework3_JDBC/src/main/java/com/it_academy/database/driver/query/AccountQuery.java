package com.it_academy.database.driver.query;

import com.it_academy.database.driver.tables.Account;

import java.sql.*;
import java.util.ArrayList;

import static com.it_academy.database.driver.service.DriverConnection.*;
import static java.lang.System.*;

public class AccountQuery {
    private static PreparedStatement preparedStatement = null;
    private static Statement statement = null;
    private double balance;

    public void createNewAccount(Account account, Connection connection) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement
                    ("INSERT INTO ACCOUNTS (userId,balance,currency) VALUES (?,?,?)");
            preparedStatement.setInt(1, account.getUserId());
            preparedStatement.setDouble(2, account.getBalance());
            preparedStatement.setString(3, account.getCurrency());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            out.println(e.getMessage());
        } finally {
            closeStatement(preparedStatement);
        }
    }

    public void popUpBalance(Account account, Connection connection) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE ACCOUNTS SET"
                    + " balance = balance + ? WHERE userId = ? AND currency = ?");
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getUserId());
            preparedStatement.setString(3, account.getCurrency());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            out.println(e.getMessage());
        } finally {
            closeStatement(preparedStatement);
        }
    }

    public void withdrawalCash(Account account, Connection connection) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE ACCOUNTS SET"
                    + " balance = balance - ? WHERE userId = ? AND currency = ?");
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getUserId());
            preparedStatement.setString(3, account.getCurrency());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            out.println(e.getMessage());
        } finally {
            closeStatement(preparedStatement);
        }
    }
    public void showCurrentAccount(Account account, Connection connection) throws SQLException {
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM ACCOUNTS WHERE currency = " + "'" + account.getCurrency()
                            + "'" + "AND userId = " + "'" + account.getUserId() + "'");
                out.println("----------------" +
                    "\nYour account:");

            while (resultSet.next()) {
                String str = "UserID: " + resultSet.getString("userId")
                        + "\nBalance: " + resultSet.getDouble("balance")
                        + "\nCurrency: " + resultSet.getString("currency");
                out.println(str);
                out.println("----------------");
            }
            resultSet.close();
        } catch (SQLException e) {
            out.println(e.getMessage());
        } finally {
            closeStatement(preparedStatement);
        }
    }

    public double checkBalance(Account account, Connection connection) throws SQLException {
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT balance"
                    + " FROM ACCOUNTS WHERE userId =" + "'" + account.getUserId() + "'" + " AND"
                    + " currency = " + "'" + account.getCurrency() + "'");
            while (resultSet.next()) {
                balance = resultSet.getDouble(1);
            }
            resultSet.close();
        } catch (SQLException e) {
            out.println(e.getMessage());
        } finally {
            closeStatement(preparedStatement);
        }
        return (balance);
    }

    public ArrayList<String> checkCurrency(int userId, Connection connection) throws SQLException {
        ArrayList<String> userCurrencyList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT currency FROM ACCOUNTS WHERE userId = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            userCurrencyList = new ArrayList<>(columnCount);
            while (resultSet.next()) {
                int i = 1;
                while (i <= columnCount) {
                    userCurrencyList.add(resultSet.getString(i++));
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            out.println(e.getMessage());
        } finally {
            closeStatement(preparedStatement);
        }
        return (userCurrencyList);
    }
}
