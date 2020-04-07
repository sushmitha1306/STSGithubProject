package com.wipro.sample;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {

	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/template/products")
	public Product[] getAll(){
		return restTemplate.getForObject("http://localhost:8080/get", Product[].class);
		
	}
	@PostMapping(value = "/template/products")
	   public String createProducts(@RequestBody ProductDTO product) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<ProductDTO> entity = new HttpEntity<>(product,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/post", HttpMethod.POST, entity, String.class).getBody();
	   }
	
}
