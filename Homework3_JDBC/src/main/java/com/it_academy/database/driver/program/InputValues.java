package com.it_academy.database.driver.program;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.*;

public class InputValues {
    private static final double TRANSACTION_LIMIT = 100_000_000;
    private static final double BALANCE_LIMIT = 2_000_000_000;

    public static int getIdNumber() {
        out.println("Enter your id number:");
        Scanner scanner = new Scanner(in);
        return scanner.nextInt();
    }

    public static String getName() {
        out.println("Enter your name:");
        Scanner scanner = new Scanner(in);
        return scanner.next();
    }

    public static String getAddress() {
        out.println("Enter your address:");
        Scanner scanner = new Scanner(in);
        return scanner.next();
    }

    public static int getBalance(Connection connection) throws SQLException {
        out.println("Enter amount:");
        Scanner scanner = new Scanner(in);
        int value = scanner.nextInt();
        if (value > BALANCE_LIMIT) {
            out.println("Sorry, balance size is exceeded (The limit is 2'000`000`000)\n" +
                    "Please rerun the program");
            connection.close();
            exit(0);
        }
        return value;
    }

    public static int getBalanceForPopUpOrWithdraw(Connection connection) throws SQLException {
        out.println("Enter amount:");
        Scanner scanner = new Scanner(in);
        int value = scanner.nextInt();
        if (value > TRANSACTION_LIMIT) {
            out.println("Sorry, transaction size is exceeded (The limit is 100`000`000)\n" +
                    "Please rerun the program");
            connection.close();
            exit(0);
        }
        return value;
    }

    public static String getCurrency() {
        out.println("Enter account currency (e.g. EUR, USD, BYN)");
        Scanner scanner = new Scanner(in);
        return scanner.next();
    }
}
