package com.it_academy.database.driver.demo;

import com.it_academy.database.driver.program.InputProgramLogic;
import com.it_academy.database.driver.query.AccountQuery;
import com.it_academy.database.driver.query.TransactionQuery;
import com.it_academy.database.driver.query.UserQuery;
import com.it_academy.database.driver.tables.Account;
import java.sql.*;
import static com.it_academy.database.driver.program.InputMenuProgram.inputOperation;
import static com.it_academy.database.driver.service.DriverConnection.isJDBCDriverRegistered;
import static java.lang.System.*;

public class DatabaseProgramStarter {
    private static final String DATABASE_URL =
            "jdbc:sqlite:D:\\Projects\\DatabaseTask\\src\\main\\resources\\Homework3db.db";

    public static void main(String[] args) throws SQLException {

        InputProgramLogic inputProgramLogic = new InputProgramLogic();
        UserQuery userQuery = new UserQuery();
        AccountQuery accountQuery = new AccountQuery();
        TransactionQuery transactionQuery = new TransactionQuery();
        Account account;

        if (isJDBCDriverRegistered()) {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            int chooseOperation;
            do {
                chooseOperation = inputOperation();
                switch (chooseOperation) {
                    case 1 -> userQuery.addUserToDataBase(inputProgramLogic.createNewUser(connection), connection);
                    case 2 -> {
                        account = inputProgramLogic.createNewAccount(connection);
                        accountQuery.createNewAccount(account, connection);
                        accountQuery.showCurrentAccount(account, connection);
                        transactionQuery.createPopUpTransaction(account, connection);
                    }
                    case 3 -> {
                        account = inputProgramLogic.popUpBalance(connection);
                        accountQuery.popUpBalance(account, connection);
                        accountQuery.showCurrentAccount(account, connection);
                        transactionQuery.createPopUpTransaction(account, connection);
                    }
                    case 4 -> {
                        account = inputProgramLogic.withdrawalCash(connection);
                        accountQuery.withdrawalCash(account, connection);
                        accountQuery.showCurrentAccount(account, connection);
                        transactionQuery.createWithdrawalTransaction(account, connection);
                    }
                    case 5 -> out.println("Thank you for using the program!");
                }
            } while (chooseOperation != 5);
            connection.close();
        }
    }
}