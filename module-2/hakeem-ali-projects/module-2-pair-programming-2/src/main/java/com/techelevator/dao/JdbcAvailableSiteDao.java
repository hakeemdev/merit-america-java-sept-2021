package com.techelevator.dao;

import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcAvailableSiteDao implements AvailableSiteDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAvailableSiteDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> viewAvailableSites(int parkId) {

        List<Site> availableSites = new ArrayList<Site>();

        String allAvailableSites = "SELECT * FROM site JOIN reservation ON site.site_id = reservation.site_id JOIN campground ON campground.campground_id = site.campground_id WHERE park_id = ? AND CURRENT_DATE NOT BETWEEN from_date - 1 AND to_date + 1";
        SqlRowSet results = jdbcTemplate.queryForRowSet(allAvailableSites, parkId);

        while (results.next()) {
            availableSites.add(mapRowToSite(results));
        }
        return availableSites;
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
