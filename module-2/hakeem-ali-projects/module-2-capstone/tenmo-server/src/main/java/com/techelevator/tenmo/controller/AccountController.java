package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {
    AccountDao accountDao;
    UserDao userDao;

    public AccountController(AccountDao accountDao, UserDao userDao){
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/balance/{id}", method = RequestMethod.GET)
    public BigDecimal returnBalance(@PathVariable int id){
        return accountDao.returnBalance(id);
    }

    @RequestMapping(path = "/listUsers", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    @RequestMapping(path = "/getUserName/{id}", method = RequestMethod.GET)
    public String getUserNameByAccountId(@PathVariable int id){
        return userDao.getUserNameByAccountId(id);
    }

    @RequestMapping(path = "/listAccounts", method = RequestMethod.GET)
    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }

    @RequestMapping(path = "/decreaseBalance/{id}", method = RequestMethod.PUT)
    public int decreaseBalance(@RequestBody Account account, @PathVariable int id){
        return accountDao.decreaseBalance(account.getBalance(), id);
    }

    @RequestMapping(path = "/increaseBalance/{id}", method = RequestMethod.PUT)
    public int increaseBalance(@RequestBody Account account, @PathVariable int id) {
        return accountDao.increaseBalance(account.getBalance(), id);
    }
}
