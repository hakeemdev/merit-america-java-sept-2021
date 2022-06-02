package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser currentUser;

    public AccountService(String baseUrl, AuthenticatedUser currentUser){
        this.baseUrl = baseUrl;
        this.currentUser = currentUser;
    }

    private HttpEntity makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }

    private HttpEntity<Account> makePutEntity(Account account){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(currentUser.getToken());
        return new HttpEntity<>(account, headers);
    }

    public void returnBalance(){
        BigDecimal balance = BigDecimal.ZERO;
        balance = restTemplate.exchange(baseUrl+"balance/"+currentUser.getUser().getId(), HttpMethod.GET,
                makeAuthEntity(), BigDecimal.class).getBody();
        String money = NumberFormat.getCurrencyInstance().format(balance);
        System.out.println("Your current account balance is: "+money);
    }

    public void updateBalance(BigDecimal amount, int toAccountId){
        Account fromAccount = getAccountFromUserId(currentUser.getUser().getId());
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        restTemplate.put(baseUrl+"decreaseBalance/"+fromAccount.getUserId(), makePutEntity(fromAccount));

        Account toAccount = getAccountFromAccountId(toAccountId);
        toAccount.setBalance(toAccount.getBalance().add(amount));
        restTemplate.put(baseUrl+"increaseBalance/"+toAccount.getUserId(), makePutEntity(toAccount));
    }

    public Account getAccountFromUserId(int userId){
        Account returnedAccount = new Account();
        Account[] accounts = restTemplate.exchange(baseUrl+"/listAccounts", HttpMethod.GET, makeAuthEntity(),
                Account[].class).getBody();
        for(Account account : accounts)
            if(account.getUserId() == userId)
                returnedAccount = account;
        return returnedAccount;
    }

    public Account getAccountFromAccountId(int accountId){
        Account returnedAccount = new Account();
        Account[] accounts = restTemplate.exchange(baseUrl+"/listAccounts", HttpMethod.GET, makeAuthEntity(),
                Account[].class).getBody();
        for(Account account : accounts)
            if(account.getAccountId() == accountId)
                returnedAccount = account;
        return returnedAccount;
    }
}
