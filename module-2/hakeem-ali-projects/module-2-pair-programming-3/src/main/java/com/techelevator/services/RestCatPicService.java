package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

	@Override
	public CatPic getPic() {
		String url = "https://cat-data.netlify.app/api/pictures/random";
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, CatPic.class);
	}

}	
