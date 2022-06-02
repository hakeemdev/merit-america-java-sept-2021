package com.techelevator;


import com.techelevator.search.SearchDomain;
import com.techelevator.search.SearchEngine;
import com.techelevator.util.TELog;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		try {

			// Step Two: Create TELog, and log the start of the application.
			//
			new TELog().log("Search application started.");
			
			
			
			// Step Four: Instantiate a Search Domain
			//
			SearchDomain sD = new SearchDomain("data");
			TELog.log(sD.toString());



			// Step Six: Single word search
			//
			SearchEngine sE = new SearchEngine(sD);
			sE.indexFiles();
			List<String> searchResults = sE.search("squirrel");

			//Lists the files that contains the search phrase
			List<String> fileName = new ArrayList<>();
			for(String result : searchResults){
				fileName.add(result);
			}
			TELog.log("Keyword 'squirrel' found in: " + fileName);
			
			
			// Step Seven: Multiple word search
			//
			searchResults = sE.search("telephone line");

			//Lists the files that contains the search phrase
			fileName = new ArrayList<>();
			for(String result : searchResults){
				fileName.add(result);
			}
			TELog.log("Keyword 'telephone line' found in: " + fileName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
