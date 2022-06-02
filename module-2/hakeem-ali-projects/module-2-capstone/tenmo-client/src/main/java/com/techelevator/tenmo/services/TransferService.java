package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import io.cucumber.java.bs.A;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class TransferService {

    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser currentUser;

    public TransferService(String baseUrl, AuthenticatedUser currentUser){
        this.baseUrl = baseUrl;
        this.currentUser = currentUser;
    }

    private HttpEntity makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }

    private HttpEntity<Transfer> makePostEntity(Transfer transfer){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(currentUser.getToken());
        return new HttpEntity<>(transfer, headers);
    }

//    private HttpEntity<Transfer> makePutEntity(Transfer transfer){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(currentUser.getToken());
//        return new HttpEntity<>(transfer, headers);
//    }


    public Transfer sendMoney(){
        Scanner scanner = new Scanner(System.in);
        User[] users = showUsers();

        Transfer transfer = new Transfer();

        int fromUserId = (int)currentUser.getUser().getId();
        transfer.setFromAccount(getAccountFromUserId(fromUserId).getAccountId());

        int toUserId = -1;
        do{
            try {
                System.out.print("\nEnter ID of user you are sending to (0 to cancel): ");
                toUserId = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }while(trueUser(users, toUserId, fromUserId)==null);

            if(toUserId!=0){
            transfer.setToAccount(getAccountFromUserId(toUserId).getAccountId());
            while(true) {
                try {
                    System.out.print("Enter amount: ");
                    transfer.setAmount(scanner.nextBigDecimal());
                    if(transfer.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                        System.err.println("Amount must be positive!");
                        continue;
                    }
                    else if(transfer.getAmount().compareTo(getAccountFromUserId(fromUserId).getBalance()) > 0){
                        System.err.println("Insufficient funds!");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Please enter a dollar amount!");
                    scanner.nextLine();
                    continue;
                }
            }
            try {
                transfer = restTemplate.exchange(baseUrl + "/postTransfer/2", HttpMethod.POST,
                        makePostEntity(transfer), Transfer.class).getBody();
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
            else
                transfer = null;
        return transfer;
    }

    public Account getAccountFromUserId(int userId){
        Account returnedAccount = new Account();
        Account[] accounts = restTemplate.exchange(baseUrl+"/listAccounts", HttpMethod.GET, makeAuthEntity(),
                Account[].class).getBody();
        for(Account account : accounts)
            if(account.getUserId() == userId)
                returnedAccount = account;
        return returnedAccount;
    }

    public User trueUser(User[] users, int userId, int fromUserId){
        User foundUser = null;
        if(userId == 0)
            foundUser = new User();
        else
            for(User user : users)
                if(user.getId() == userId)
                    foundUser = user;
        if(userId == fromUserId){
            System.err.println("Cannot make transfer to own account!");
            foundUser = null;
        }
        else if(foundUser==null)
            System.err.println("Please enter a valid User ID!");
        return foundUser;
    }

    public User[] showUsers() {
        User[] users = restTemplate.exchange(baseUrl+"/listUsers", HttpMethod.GET, makeAuthEntity(),
                User[].class).getBody();

        System.out.println("-------------------------------------------\nUsers\nID          Name" +
                "\n-------------------------------------------");
        for(User user : users){
            System.out.println(user.getId()+"\t\t"+user.getUsername());
        }
        System.out.println("---------");
        return users;
    }

    public int getAccountIdFromUserId(int userId){
        Account returnedAccount = new Account();
        Account[] accounts = restTemplate.exchange(baseUrl+"/listAccounts", HttpMethod.GET, makeAuthEntity(),
                Account[].class).getBody();
        for(Account account : accounts)
            if(account.getUserId() == userId)
                returnedAccount = account;
        return returnedAccount.getAccountId();
    }

    public String[] usersList(Transfer[] transfers, int id){
        String[] listOfUsers = new String[transfers.length];
        for(int i=0;i< listOfUsers.length;i++){
            if(transfers[i].getFromAccount()==id) {
                String username = restTemplate.exchange(baseUrl+"/getUserName/"+transfers[i].getToAccount(),
                        HttpMethod.GET, makeAuthEntity(), String.class).getBody();
                listOfUsers[i] = "To:   "+username+"\t\t\t\t\t";
            }
            if(transfers[i].getToAccount()==id){
                String username = restTemplate.exchange(baseUrl+"/getUserName/"+transfers[i].getFromAccount(),
                        HttpMethod.GET, makeAuthEntity(), String.class).getBody();
                listOfUsers[i] = "From: "+username+"\t\t\t\t\t";
            }
        }
        return listOfUsers;
    }

    public String[] pendingUsersList(Transfer[] transfers){
        String[] listOfUsers = new String[transfers.length];
        for(int i=0;i< listOfUsers.length;i++){
            String username = restTemplate.exchange(baseUrl+"/getUserName/"+transfers[i].getToAccount(),
                HttpMethod.GET, makeAuthEntity(), String.class).getBody();
            listOfUsers[i] = username+"\t\t\t\t\t";
        }
        return listOfUsers;
    }

    public String toString(Transfer transfer){
        String fromUsername = restTemplate.exchange(baseUrl+"/getUserName/"+transfer.getFromAccount(),
                HttpMethod.GET, makeAuthEntity(), String.class).getBody();
        String toUsername = restTemplate.exchange(baseUrl+"/getUserName/"+transfer.getToAccount(),
                HttpMethod.GET, makeAuthEntity(), String.class).getBody();
        String typeDesc = restTemplate.exchange(baseUrl+"/getType/"+transfer.getType(),
                HttpMethod.GET, makeAuthEntity(), String.class).getBody();
        String statusDesc = restTemplate.exchange(baseUrl+"/getStatus/"+transfer.getStatus(),
                HttpMethod.GET, makeAuthEntity(), String.class).getBody();
        String dollars = NumberFormat.getCurrencyInstance().format(transfer.getAmount());
        return "--------------------------------------------\n" +
                "Transfer Details\n" +
                "--------------------------------------------\n" +
                " Id: "+transfer.getId()+"\n" +
                " From: "+fromUsername+"\n" +
                " To: "+toUsername+"\n" +
                " Type: "+typeDesc+"\n" +
                " Status: "+statusDesc+"\n" +
                " Amount: "+dollars+"\n";
    }

    public Transfer chooseTransferToView(){
        Transfer transfer = null;
        Transfer[] transfers = showTransfersById();

        Scanner scanner = new Scanner(System.in);
        int transferId = -1;
        do{
            try {
                System.out.print("\nPlease enter transfer ID to view details (0 to cancel): ");
                transferId = scanner.nextInt();
                transfer = trueTransfer(transfers, transferId);
            } catch (InputMismatchException e) {
                System.err.println("Input Mismatch Exception!");
                scanner.nextLine();
            }
        }while(transfer==null);
        if(transfer!=null && transfer.getId()!=0)
            System.out.println(toString(transfer));
        return transfer;
    }

    public Transfer trueTransfer(Transfer[] transfers, int transferId){
        Transfer transferFound = null;
        if(transferId==0)
            transferFound = new Transfer();
        else if(transferId!=-1)
            for(Transfer transfer : transfers)
                if(transfer.getId() == transferId)
                    transferFound = transfer;
        if(transferFound==null)
            System.err.println("Transfer "+transferId+" not found. Please enter again.");
        return transferFound;
    }

    public Transfer[] showTransfersById(){
        int id = getAccountIdFromUserId((int)currentUser.getUser().getId());
        Transfer[] transfers = restTemplate.exchange(baseUrl+"/listIdTransfers/"+id, HttpMethod.GET,
                makeAuthEntity(), Transfer[].class).getBody();
        String[] listOfUsers = usersList(transfers, id);

        System.out.println("-------------------------------------------\n" +
                "Transfers\n" +
                "ID          From/To                 Amount\n" +
                "-------------------------------------------");
        int i = 0;
        for(Transfer transfer : transfers){
            System.out.print(transfer.getId()+"\t\t");

            System.out.print(listOfUsers[i]);
            i++;

            System.out.println(NumberFormat.getCurrencyInstance().format(transfer.getAmount()));
        }
        System.out.println("---------");
        return transfers;
    }

    public Transfer requestTEBucks(){
        Scanner scanner = new Scanner(System.in);
        Transfer transfer = new Transfer();
        User[] users = showUsers();

        int toUserId = (int)currentUser.getUser().getId();
        transfer.setToAccount(getAccountFromUserId(toUserId).getAccountId());

        int fromUserId = -1;
        do{
            try {
                System.out.print("\nEnter ID of user you are requesting from (0 to cancel): ");
                fromUserId = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }while(trueUser(users, fromUserId, toUserId)==null);

        if(fromUserId!=0){
            transfer.setFromAccount(getAccountFromUserId(fromUserId).getAccountId());
            while(true) {
                try {
                    System.out.print("Enter amount: ");
                    transfer.setAmount(scanner.nextBigDecimal());
                    if(transfer.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                        System.err.println("Amount must be positive!");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Please enter a dollar amount!");
                    scanner.nextLine();
                    continue;
                }
            }
            try {
                transfer = restTemplate.exchange(baseUrl + "/postTransfer/1", HttpMethod.POST,
                        makePostEntity(transfer), Transfer.class).getBody();
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else
            transfer = null;
        return transfer;
    }

    public Transfer viewAndChoosePendingRequests(){
        Transfer[] pendingTransfers = viewPendingRequests();
        Transfer transfer = new Transfer();
        if(pendingTransfers.length!=0){
            Scanner scanner = new Scanner(System.in);

            int transferId = -1;
            do{
                try {
                    System.out.println("Please enter transfer ID to approve/reject (0 to cancel): ");
                    transferId = scanner.nextInt();
                    transfer = trueTransfer(pendingTransfers, transferId);
                } catch (InputMismatchException e) {
                    System.err.println("Input Mismatch Exception!");
                    scanner.nextLine();
                }
            }while(transfer==null);
            if(transferId != 0) {
                System.out.print("1: Approve\n" +
                        "2: Reject\n" +
                        "0: Don't approve or reject\n" +
                        "---------\n");
                int choice = -1;
                do {
                    System.out.print("Please choose an option: ");
                    try {
                        choice = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.err.println("Input Mismatch Exception!");
                        scanner.nextLine();
                    }
                } while (choice < 0 || choice > 2);
                if(choice!=0)
                    transfer = approveOrReject(transfer, choice);
            }
        }
        return transfer;
    }

    public Transfer approveOrReject(Transfer transfer, int choice){
        int userId = (int) currentUser.getUser().getId();
        Transfer updatedTransfer = transfer;
        updatedTransfer.setStatus(choice+1);
        if(choice == 1){
            if(transfer.getAmount().compareTo(getAccountFromUserId(userId).getBalance()) <= 0) {
                restTemplate.put(baseUrl + "updateRequest/2", makePostEntity(transfer));
            }
            else{
                System.out.println("Insufficient funds!");
            }
        }
        else
            restTemplate.put(baseUrl + "updateRequest/3", makePostEntity(transfer));
        return updatedTransfer;
    }

    public Transfer[] viewPendingRequests(){
        int fromUserId = (int)currentUser.getUser().getId();
        int fromAccountId = getAccountFromUserId(fromUserId).getAccountId();
        Transfer[] transfers = restTemplate.exchange(baseUrl+"/listPendTransfers/"+fromAccountId,
                HttpMethod.GET, makeAuthEntity(), Transfer[].class).getBody();
        String[] listOfUsers = pendingUsersList(transfers);
        int i = 0;

        if(transfers.length!=0) {
            System.out.println("-------------------------------------------\n" +
                    "Pending Transfers\n" +
                    "ID          To                     Amount\n" +
                    "-------------------------------------------");
            for (Transfer transfer : transfers) {
                System.out.print(transfer.getId() + "\t\t");

                System.out.print(listOfUsers[i]);
                i++;

                System.out.println(NumberFormat.getCurrencyInstance().format(transfer.getAmount()));
            }
            System.out.println("---------");
        }
        else{
            System.out.println("No pending requests!");
        }
        return transfers;
    }
}

