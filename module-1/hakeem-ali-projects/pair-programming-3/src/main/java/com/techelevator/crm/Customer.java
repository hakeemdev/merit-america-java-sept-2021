package com.techelevator.crm;

import com.techelevator.Billable;
import com.techelevator.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer extends Person implements Billable {
    private String phoneNumber;
    private List<String> pets = new ArrayList<String>();

    public Customer(String firstName, String lastName, String phoneNumber){
        this.phoneNumber = phoneNumber;
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

    public Customer(String firstName, String lastName){
        this(firstName, lastName, "");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }

    @Override
    public double getBalanceDue(Map<String, Double> servicesRendered) {
        double total = 0;

        for(String key : servicesRendered.keySet()){
            total += servicesRendered.get(key);
        }

        return total;
    }
}
