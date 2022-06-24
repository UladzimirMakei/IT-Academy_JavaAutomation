package com.it_academy.database.driver.program;

import com.it_academy.database.driver.query.AccountQuery;
import com.it_academy.database.driver.query.UserQuery;
import com.it_academy.database.driver.tables.Account;
import com.it_academy.database.driver.tables.User;

import java.sql.Connection;
import java.sql.SQLException;

import static com.it_academy.database.driver.program.InputValues.*;
import static java.lang.System.*;

public class InputProgramLogic {
    private static final double BALANCE_LIMIT = 2_000_000_000;

    User user = new User();
    Account account = new Account();
    UserQuery userQuery = new UserQuery();
    AccountQuery accountQuery = new AccountQuery();

    public User createNewUser(Connection connection) throws SQLException {
        user.setUserId(getIdNumber());
        isUserExist(user, connection);
        user.setName(getName());
        user.setAddress(getAddress());
        return user;
    }

    public Account createNewAccount(Connection connection) throws SQLException {
        account.setUserId(getIdNumber());
        account.setCurrency(getCurrency());
        isAccountExist(account, connection);
        account.setBalance(
                Math.round((getBalance(connection)) *
                        (int) Math.pow(10.0, 3)) / Math.pow(10.0, 3));
        return account;
    }

    public Account popUpBalance(Connection connection) throws SQLException {
        account.setUserId(getIdNumber());
        account.setCurrency(getCurrency());
        account.setBalance(
                Math.round((getBalanceForPopUpOrWithdraw(connection)) *
                        (int) Math.pow(10.0, 3)) / Math.pow(10.0, 3));
        isBalanceWithinLimit(account, connection);
        return account;
    }

    public Account withdrawalCash(Connection connection) throws SQLException {
        account.setUserId(getIdNumber());
        account.setCurrency(getCurrency());
        account.setBalance(
                Math.round((getBalanceForPopUpOrWithdraw(connection)) *
                        (int) Math.pow(10.0, 3)) / Math.pow(10.0, 3));
        isBalanceWithinLimit(account, connection);
        return account;
    }
    private void isUserExist(User user, Connection connection) throws SQLException {
        if (userQuery.checkUserId(connection).contains(String.valueOf(user.getUserId()))) {
            out.println("You already have account\n" +
                    "Please rerun the program");
            connection.close();
            exit(0);
        }
    }

    private void isAccountExist(Account account, Connection connection) throws SQLException {
        if (accountQuery.checkCurrency(account.getUserId(), connection)
                .contains(account.getCurrency())) {
            out.println("You already have account in " + account.getCurrency() +
                    "\nPlease rerun the program");
            connection.close();
            exit(0);
        }
    }

    private void isBalanceWithinLimit(Account account, Connection connection) throws SQLException {
        if ((account.getBalance() + accountQuery.checkBalance(account, connection))
                > BALANCE_LIMIT || (account.getBalance() > accountQuery.checkBalance(account, connection))) {
            out.println("Sorry, your balance limit is exceeded. \n" +
                    "Please check our balance and rerun the program");
            connection.close();
            exit(0);
        }
    }
}
