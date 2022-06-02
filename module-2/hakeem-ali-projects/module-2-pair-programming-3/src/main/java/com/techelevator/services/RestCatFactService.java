package com.techelevator.services;

import com.techelevator.model.CatPic;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	@Override
	public CatFact getFact() {
		String url = "https://cat-data.netlify.app/api/facts/random";
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, CatFact.class);
	}

}
