package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTransferStatusDao implements  TransferStatusDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTransferStatusDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String retrieveStatus(int statusId){
        String sql = "SELECT transfer_status_desc FROM transfer_statuses WHERE" +
                " transfer_status_id = ?;";
        return jdbcTemplate.queryForObject(sql, String.class, statusId);
    }
}
