package com.techelevator.dao;

import com.techelevator.model.Site;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JdbcSiteDaoTests extends BaseDaoTests {

    private SiteDao dao;
    private AvailableSiteDao dao2;

    @Before
    public void setup() {
        dao = new JdbcSiteDao(dataSource);
        dao2 = new JdbcAvailableSiteDao(dataSource);
    }

    @Test
    public void getSitesThatAllowRVs_Should_ReturnSites() {
        List<Site> sites = dao.getSitesThatAllowRVs(1);

        assertEquals(2,sites.size());
    }

    @Test
    public void getAvailableSites_Should_ReturnSites() {
        List<Site> sites = dao2.viewAvailableSites(1);

        assertEquals(2, sites.size());
    }

    public void getAvailableSitesDateRange_Should_ReturnSites() {

    }
}
