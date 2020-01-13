package com.server.dao;

import com.server.pojo.User;

import java.util.Collection;

public interface UserDao {
    boolean addUser(User user);

    User getUserById(Integer id);

    boolean updateUserById(User mobile);

    boolean deleteUserById(Integer id);

    void createTable();

    Collection<User> getAllUsers();
}
