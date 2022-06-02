package com.techelevator;

import com.techelevator.tenmo.model.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserValidationTest {

    User user = new User();

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }

    public UserValidationTest() {

    }

    @Test
    public void should_have_no_violations() {
        User user = new User(525L, "TEST_USER", "TEST_PASSWORD", "ROLE_USER");

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    public void usernameShouldNotBeBlank() {
        User user = new User(525L, "", "TEST_PASSWORD", "ROLE_USER");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assertions.assertEquals(violations.size(), 1);

        ConstraintViolation<User> violation = violations.iterator().next();
        Assertions.assertEquals("The username field should not be blank.", violation.getMessage());
        Assertions.assertEquals("username", violation.getPropertyPath().toString());
    }

    @Test
    public void passwordShouldNotBeBlank() {
        User user = new User(525L, "TEST_USER", "", "ROLE_USER");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assertions.assertEquals(violations.size(), 1);

        ConstraintViolation<User> violation = violations.iterator().next();
        Assertions.assertEquals("The password field should not be blank.", violation.getMessage());
        Assertions.assertEquals("password", violation.getPropertyPath().toString());
    }

    @Test
    public void userId_equals_9999() {
        Long id = (long) 9999;
        user.setId(id);
        assertEquals(user.getId(), id);
    }

    @Test
    public void username_equals_Hakeem() {
        user.setUsername("Hakeem");
        Assertions.assertEquals(user.getUsername(), "Hakeem");
    }

    @Test
    public void password_equals_Password() {
        user.setPassword("Password");
        Assertions.assertEquals(user.getPassword(), "Password");
    }

    @Test
    public void isActivated_equals_true() {
        user.setActivated(true);
        Assertions.assertTrue(user.isActivated());
    }
}
