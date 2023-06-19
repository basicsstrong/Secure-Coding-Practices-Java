package com.basicsstrong.securecoding;

import java.sql.*;

public class Injection {
    public static void main(String[] args) {
        String email = getInput("Enter the email: ");
        Object[] userData = getUserData(email);
        System.out.println(userData);
    }

    public static String getInput(String message) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(message);
        String username = scanner.nextLine();
        scanner.close();
        return username;
    }

    public static Object[] getUserData(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        Object[] userData = null;

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/<db_name>", "<username>", "<password>");
             PreparedStatement statement = conn.prepareStatement(query)) {
        	statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                userData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    userData[i - 1] = resultSet.getObject(i);
                }
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userData;
    }
}

/*
 * 
secure_coding=> -- Create User table
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  age INTEGER
);

-- Insert five users
INSERT INTO users (name, email, age) VALUES
  ('John Doe', 'john.doe@example.com', 25),
  ('Jane Smith', 'jane.smith@example.com', 30),
  ('Michael Johnson', 'michael.johnson@example.com', 35),
  ('Emily Davis', 'emily.davis@example.com', 28),
  ('David Wilson', 'david.wilson@example.com', 32);
  
  */
