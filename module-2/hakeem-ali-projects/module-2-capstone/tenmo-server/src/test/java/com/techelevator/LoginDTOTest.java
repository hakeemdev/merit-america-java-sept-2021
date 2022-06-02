package com.techelevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.techelevator.tenmo.model.LoginDTO;

public class LoginDTOTest {
    LoginDTO login = new LoginDTO();

    @Test
    public void getUsername_equals_Michael() {
        login.setUsername("Michael");
        Assertions.assertEquals(login.getUsername(), "Michael");
    }

    @Test
    public void getPassword_equals_Password() {
        login.setPassword("Password");
        Assertions.assertEquals(login.getPassword(), "Password");
    }
}

