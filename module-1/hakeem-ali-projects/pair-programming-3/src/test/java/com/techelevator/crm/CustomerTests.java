package com.techelevator.crm;

import com.techelevator.hr.Department;
import com.techelevator.hr.Employee;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTests extends TestCase {

    @Test
    public void testGetBalanceDue() {

        Customer customer = new Customer("Test", "Testerson");
        Map<String, Double> servicesRendered = new HashMap<>();
        double total = 0;

        servicesRendered.put("Walking", 50.00);
        servicesRendered.put("Grooming", 120.00);
        servicesRendered.put("Sitting", 100.00);

        total = customer.getBalanceDue(servicesRendered);


        assertEquals(270.00,total);
    }

}