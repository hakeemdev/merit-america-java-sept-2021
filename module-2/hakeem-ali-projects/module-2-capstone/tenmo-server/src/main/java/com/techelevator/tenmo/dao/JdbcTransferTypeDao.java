package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTransferTypeDao implements  TransferTypeDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTransferTypeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String retrieveType(int typeId){
        String sql = "SELECT transfer_type_desc FROM transfer_types WHERE" +
                " transfer_type_id = ?;";
        return jdbcTemplate.queryForObject(sql, String.class, typeId);
    }
}
