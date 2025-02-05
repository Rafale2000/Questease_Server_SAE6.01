package fr.uphf.questease.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    public static final String URL = "jdbc:postgresql://aws-0-eu-west-3.pooler.supabase.com:5432/postgres";
    public static final String USER = "postgres.lqcstyauhemheccdmplu";
    public static final String PASSWORD = "Questease%1234";

    public List<String> getValuesFromColumn(PreparedStatement preparedStatement) {
        List<String> results = new ArrayList<>();
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                results.add(resultSet.getString(1)); // Récupère la première colonne du résultat
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
    public boolean insert(String query, Object... params) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
