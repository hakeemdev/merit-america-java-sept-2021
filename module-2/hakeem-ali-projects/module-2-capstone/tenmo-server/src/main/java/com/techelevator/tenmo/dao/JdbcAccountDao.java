package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal returnBalance(int userId) {
        String sqlString = "SELECT balance FROM accounts WHERE user_id = ?;";
        BigDecimal balance = null;
        balance = jdbcTemplate.queryForObject(sqlString, BigDecimal.class, userId);

        return balance;
    }

    @Override
    public int decreaseBalance(BigDecimal amount, int userId) {
        String sqlString = "UPDATE accounts SET balance = ? WHERE user_id = ?;";
        return jdbcTemplate.update(sqlString, amount, userId);
    }


    @Override
    public int increaseBalance(BigDecimal amount, int userId) {
        String sqlString = "UPDATE accounts SET balance = ? WHERE user_id = ?;";
        return jdbcTemplate.update(sqlString, amount, userId);
    }

    @Override
    public List<Account> findAll(){
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, user_id, balance FROM accounts;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Account account = mapRowToAccount(results);
            accounts.add(account);
        }
        return accounts;
    }


    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setUserId(rs.getInt("user_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        return account;
    }



}
