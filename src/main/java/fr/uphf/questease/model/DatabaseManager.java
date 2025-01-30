package fr.uphf.questease.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private static final String URL = "jdbc:postgresql://aws-0-eu-west-3.pooler.supabase.com:5432/postgres";
    private static final String USER = "postgres.lqcstyauhemheccdmplu";
    private static final String PASSWORD = "Questease%1234";

    public List<String> getValuesFromColumn(String query) {
        List<String> results = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                results.add(resultSet.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }
}
