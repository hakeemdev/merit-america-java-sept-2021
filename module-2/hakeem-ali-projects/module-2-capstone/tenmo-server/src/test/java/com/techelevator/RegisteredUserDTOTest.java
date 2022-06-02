package com.techelevator;

import com.techelevator.tenmo.model.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.techelevator.tenmo.model.RegisterUserDTO;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisteredUserDTOTest {

    RegisterUserDTO user = new RegisterUserDTO();

    @Test
    public void getUsername_equals_Hello() {
        user.setUsername("Hello");
        Assertions.assertEquals(user.getUsername(), "Hello");
    }

    @Test
    public void getPassword_equals_Hello() {
        user.setPassword("Hello");
        Assertions.assertEquals(user.getPassword(), "Hello");
    }

    @Test
    public void check_Username_NotEmpty() {
        user.setUsername("Hakeem");
        Assertions.assertFalse(user.getUsername().isEmpty());
    }

    @Test
    public void check_Password_NotEmpty() {
        user.setPassword("Password");
        Assertions.assertFalse(user.getPassword().isEmpty());
    }
}
