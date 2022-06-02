package com.techelevator.dao;

import com.techelevator.model.Reservation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcUpcomingReservationDaoTests extends BaseDaoTests {

    private UpcomingReservationDao dao;

    @Before
    public void setup() {
        dao = new JdbcUpcomingReservationDao(dataSource);
    }

    @Test
    public void getUpcomingReservationsTest_Should_ReturnAllReservationsInNext30Days() {
        List<Reservation> reservations = dao.viewUpcomingReservations(1);

        assertEquals(2, reservations.size());
        assertEquals("Test Testerson", reservations.get(0).getName());
        assertEquals("Bob Robertson", reservations.get(1).getName());

    }


}
