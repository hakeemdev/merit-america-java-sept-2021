package com.techelevator.dao;

import com.techelevator.model.Reservation;

import java.util.List;

public interface UpcomingReservationDao {

    public List<Reservation> viewUpcomingReservations(int parkId);

}
