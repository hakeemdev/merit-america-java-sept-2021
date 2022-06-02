package com.techelevator.crm;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class PetTest extends TestCase {

    public void testListVaccinations() {
        Pet pet = new Pet("FakeDog", "Shih Tzu");
        List<String> vaccinations = new ArrayList<String>();
        String vaxList = "";

        vaccinations.add("Distemper");
        vaccinations.add("Parainfluenza");

        pet.setVaccinations(vaccinations);

        Assert.assertEquals("Not vaccinated.", "Distemper, Parainfluenza", pet.listVaccinations());

    }
}