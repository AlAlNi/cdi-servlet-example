package com.server.dao;

import com.server.ConnectionManager.ConnectionManager;
import com.server.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EJB
public class UserDaoJdbcImpl implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoJdbcImpl.class);
    public static final String INSERT_INTO_USERS = "INSERT INTO users values (DEFAULT, ?, ?, ?, ?)";
    public static final String SELECT_FROM_USERS = "SELECT * FROM users WHERE id = ?";
    public static final String SELECT_ALL_FROM_USERS = "SELECT * FROM users";
    public static final String UPDATE_USERS = "UPDATE users SET name=?, age=?, email=?, phone=? WHERE id=?";
    public static final String DELETE_FROM_USERS = "DELETE FROM users WHERE id=?";
    public static final String CREATE_TABLE_USERS
            = "DROP TABLE IF EXISTS users;\n"
            + "create table mobile\n"
            + "(\n"
            + "    id bigserial not null\n"
            + "        constraint users_pkey\n"
            + "            primary key,\n"
            + "    name varchar(30) not null,\n"
            + "    age integer not null,\n"
            + "    email varchar(100) not null,\n"
            + "    phone bigserial not null\n"
            + ");\n"
            + "\n"
            + "alter table users owner to postgres;";


    private ConnectionManager connectionManager;

    @Inject
    public UserDaoJdbcImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean addUser(User user) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USERS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setLong(4, user.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in addMobile method", e);
            return false;
        }
        return true;
    }

    @Override
    public User getUserById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_USERS)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getLong(5));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in getMobileById method", e);
        }
        return null;
    }

    @Override
    public boolean updateUserById(User user) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setLong(4, user.getPhone());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in updateMobileById method", e);
        }
        return false;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_USERS)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in deleteMobileById method", e);
            return false;
        }
        return true;
    }

    @Override
    public void createTable() {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_USERS)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in createTable method", e);
        }
    }

    @Override
    public Collection<User> getAllUsers(){
        List<User> lstmb = new ArrayList<>();
        try (PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement(SELECT_ALL_FROM_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                lstmb.add(new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getLong(5)));
            }
            return lstmb;
        } catch (SQLException e) {
            LOGGER.error("Something wrong in getMobileById method", e);
        }
        return new ArrayList<>();
    }
}
