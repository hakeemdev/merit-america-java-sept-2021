package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {

    boolean sendMoney(int status, int type, int from, int to, BigDecimal amount);

    List<Transfer> findAll();

    List<Transfer> findById(int id);

    List<Transfer> findAllPending(int id);

    int updateRequest(int transferId, int statusId);
}
