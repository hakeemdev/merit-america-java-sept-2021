package com.techelevator;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.techelevator.tenmo.model.Account;


public class AccountTest {
    Account account = new Account();

    @Test
    public void accountId_equals_756() {
        account.setAccountId(756);
        Assertions.assertEquals(account.getAccountId(), 756);
    }

    @Test
    public void userId_equals_74() {
        account.setUserId(74);
        Assertions.assertEquals(account.getUserId(), 74);
    }

    @Test
    public void accountBalance_equals_87594() {
        account.setBalance(BigDecimal.valueOf(87594));
        Assertions.assertEquals(account.getBalance(), BigDecimal.valueOf(87594));
    }

}
