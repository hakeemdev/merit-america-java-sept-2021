package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.TransferStatusDao;
import com.techelevator.tenmo.dao.TransferTypeDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class TransferController {
    TransferDao transferDao;
    TransferStatusDao transferStatusDao;
    TransferTypeDao transferTypeDao;

    public TransferController(TransferDao transferDao, TransferStatusDao transferStatusDao,
                              TransferTypeDao transferTypeDao){
        this.transferDao = transferDao;
        this.transferStatusDao = transferStatusDao;
        this.transferTypeDao = transferTypeDao;
    }

    @RequestMapping(path = "/postTransfer/{id}", method = RequestMethod.POST)
    public boolean sendMoney(@RequestBody Transfer transfer, @PathVariable int id){
        return transferDao.sendMoney(id, id, transfer.getFromAccount(), transfer.getToAccount(), transfer.getAmount());
    }

    @RequestMapping(path = "/updateRequest/{id}", method = RequestMethod.PUT)
    public int updatePendingRequest(@RequestBody Transfer transfer, @PathVariable int id){
        return transferDao.updateRequest(transfer.getId(), id);
    }

    @RequestMapping(path = "/listTransfers", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers(){
        return transferDao.findAll();
    }

    @RequestMapping(path = "/listIdTransfers/{id}", method = RequestMethod.GET)
    public List<Transfer> getTransfersByID(@PathVariable int id){
        return transferDao.findById(id);
    }

    @RequestMapping(path = "/listPendTransfers/{id}", method = RequestMethod.GET)
    public List<Transfer> getPendingTransfers(@PathVariable int id){
        return transferDao.findAllPending(id);
    }

    @RequestMapping(path = "/getStatus/{id}", method = RequestMethod.GET)
    public String getTransferStatus(@PathVariable int id){ return transferStatusDao.retrieveStatus(id);}

    @RequestMapping(path = "/getType/{id}", method = RequestMethod.GET)
    public String getTransferType(@PathVariable int id){ return transferTypeDao.retrieveType(id);}
}
