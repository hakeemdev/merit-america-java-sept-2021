package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    BigDecimal returnBalance(int userId);

    List<Account> findAll();

    int decreaseBalance(BigDecimal amount, int userId);

    int increaseBalance(BigDecimal amount, int userId);

}
