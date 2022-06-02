package com.techelevator.util;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TELog {

    static PrintWriter logWriter = null;
    static LocalDate date = LocalDate.now();
    static LocalTime time = LocalTime.now();

    public static void log(String message){
        try{
            if(logWriter == null){
                logWriter = new PrintWriter(new FileOutputStream("logs\\search.log", true));
            }

            logWriter.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n" + message + "\n"); //Logs message to file;
            logWriter.flush();

        }catch(TELogException | IOException e){

        }
    }
}
