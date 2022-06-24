package com.it_academy.database.driver.query;

import com.it_academy.database.driver.tables.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.it_academy.database.driver.service.DriverConnection.*;

public class TransactionQuery {
    private static PreparedStatement preparedStatement = null;

    private void setPreparedStatement(Account account) throws SQLException {
        preparedStatement.setString(1, account.getCurrency());
        preparedStatement.setInt(2, account.getUserId());
        preparedStatement.setDouble(3, account.getBalance());
        preparedStatement.executeUpdate();
    }

    public void createPopUpTransaction(Account account, Connection connection) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO TRANSACTIONS (accountId,amount) VALUES"
                            + " ((SELECT accountId FROM ACCOUNTS WHERE currency = ? AND userId = ?),?)");
            setPreparedStatement(account);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStatement(preparedStatement);
        }
    }

    public void createWithdrawalTransaction(Account account, Connection connection) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO TRANSACTIONS (accountId,amount) VALUES"
                            + " ((SELECT accountId FROM ACCOUNTS WHERE currency = ? AND userId = ?),-?)");
            setPreparedStatement(account);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStatement(preparedStatement);
        }
    }
}
