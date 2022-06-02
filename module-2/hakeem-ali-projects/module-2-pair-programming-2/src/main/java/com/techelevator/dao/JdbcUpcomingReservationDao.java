package com.techelevator.dao;

import com.techelevator.model.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcUpcomingReservationDao implements UpcomingReservationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcUpcomingReservationDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Reservation> viewUpcomingReservations(int parkId) {

        List<Reservation> reservations = new ArrayList<Reservation>();

        String selectAllUpcomingReservations = "SELECT * FROM reservation JOIN site ON reservation.site_id = site.site_id JOIN campground ON campground.campground_id = site.campground_id WHERE park_id = ? AND from_date BETWEEN CURRENT_DATE AND CURRENT_DATE + 30";
        SqlRowSet results = jdbcTemplate.queryForRowSet(selectAllUpcomingReservations, parkId);


        while(results.next()) {
            reservations.add(mapRowToReservation(results));
        }
        return reservations;
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }
}
