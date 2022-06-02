package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findByUsername(String username);

    User findById(long id);

    int findIdByUsername(String username);

    boolean create(String username, String password);

    String getUserNameByAccountId(int id);
}
