package com.aralimankulov.spring.mvc_hibernate.dao;

import com.aralimankulov.spring.mvc_hibernate.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
