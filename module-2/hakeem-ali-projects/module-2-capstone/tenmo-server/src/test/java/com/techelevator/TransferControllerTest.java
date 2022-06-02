package com.techelevator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.tenmo.controller.TransferController;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.TransferStatusDao;
import com.techelevator.tenmo.dao.TransferTypeDao;
import com.techelevator.tenmo.model.Transfer;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransferControllerTest extends AbstractTest{

    @Before
    public void setUp() {
        super.setUp();
    }

    @WithMockUser(username = "a", password = "a")
    @Test
    public void returns_Full_List_Of_Transfers() throws Exception{
        String uri = "/listTransfers";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<Transfer> transferList = super.mapFromJson(content, ArrayList.class);
        Assertions.assertTrue(!transferList.isEmpty());
    }

    @WithMockUser(username = "a", password = "a")
    @Test
    public void successfully_Post_New_Transfer() throws Exception {
        Transfer transfer = new Transfer(2, 1, 4000, 2002, 2001, BigDecimal.valueOf(500));
        String uri = "/postTransfer/"+transfer.getId();

        String inputJson = super.mapToJson(transfer);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "true");
    }

//    @WithMockUser(username = "a", password = "a")
//    @Test
//    public void update_Status_Of_Request() throws Exception {
//        int acceptedStatus = 2;
//        int rejectedStatus = 1;
//        String uri = "/updateRequest/"+acceptedStatus;
//        Transfer transfer = new Transfer(3059, 1, rejectedStatus, 2002, 2003, BigDecimal.valueOf(500));
//
//        String inputJson = super.mapToJson(transfer);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        Assertions.assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        Assertions.assertEquals(content, "1");
//        Assertions.assertEquals(acceptedStatus, transfer.getStatus());
//    }
}
