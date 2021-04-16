package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.utils.Security;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JDBCUserService implements UserService {

    private Connection dbConnection;

    public Connection getDbConnection() {
        try {
            if (dbConnection == null) {
                dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ac", "root", "");
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database : " + ex.getMessage());
        }
        return dbConnection;
    }

    public void close() {
        try {
            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }


    @Override
    public boolean authenticate(String username, String password) {

        getDbConnection();

        try {
            String authentication = "SELECT * FROM user WHERE username=? AND password =?";

            PreparedStatement statement = dbConnection.prepareStatement(authentication);
            statement.setString(1 , username);
            statement.setString(2 , Security.getHash(password));

            ResultSet resultSet = statement.executeQuery();

            System.out.println(authentication);

            return resultSet.next();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("test");
        return false;
    }

    @Override
    public void add(User user) {

        getDbConnection();
        try {
            String insert = "INSERT INTO user (username, email, password, firstname, lastname, phone)" +
                    "VALUES(?,?,?,?,?,?)";

            PreparedStatement statement = dbConnection.prepareStatement(insert);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getPhone());

            statement.executeUpdate();

            //statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User findByName(String username) {
        getDbConnection();
        User user = null;
        try {
            String queryName = "SELECT * FROM user WHERE username=?";
            PreparedStatement statement = dbConnection.prepareStatement(queryName);

            statement.setString(1 , username);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String usernameValue = resultSet.getString("username");
                String emailValue = resultSet.getString("email");
                String passwordValue = resultSet.getString("password");
                String firstNameValue = resultSet.getString("firstname");
                String lastNameValue = resultSet.getString("lastname");
                String phoneValue = resultSet.getString("phone");

                user = new User(usernameValue, emailValue, passwordValue, firstNameValue, lastNameValue, phoneValue);
            }

            if (statement != null) {
                statement.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {

        getDbConnection();
        List<User> list = new LinkedList<>();
        User user = null;

        try {

            String query = "SELECT * FROM user;";
            PreparedStatement statement = dbConnection.prepareStatement(query);

            ResultSet resultSetFindAll = statement.executeQuery();

            while (resultSetFindAll.next()) {
                String usernameValue = resultSetFindAll.getString("username");
                String emailValue = resultSetFindAll.getString("email");
                String passwordValue = resultSetFindAll.getString("password");
                String firstNameValue = resultSetFindAll.getString("firstname");
                String lastNameValue = resultSetFindAll.getString("lastname");
                String phoneValue = resultSetFindAll.getString("phone");
                list.add(new User(usernameValue, emailValue, passwordValue, firstNameValue, lastNameValue, phoneValue));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int count() {
        getDbConnection();
        int result = 0;

        try {
            Statement statement = dbConnection.createStatement();
            String queryCount = "SELECT COUNT(*) FROM user";
            ResultSet resultSet = statement.executeQuery(queryCount);

            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
