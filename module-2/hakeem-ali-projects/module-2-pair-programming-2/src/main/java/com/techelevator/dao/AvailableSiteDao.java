package com.techelevator.dao;

import com.techelevator.model.Site;

import java.util.List;

public interface AvailableSiteDao {

    public List<Site> viewAvailableSites(int parkId);

}