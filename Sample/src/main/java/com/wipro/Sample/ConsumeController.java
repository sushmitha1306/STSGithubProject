package com.wipro.Sample;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {

	@Autowired
	RestTemplate restTemplate;
	@RequestMapping("/template/products")
	public Product[] getAll(){
		Product[] list=restTemplate.getForObject("http://localhost:8080/get", Product[].class);
		return list;
	}
//	@RequestMapping("/template/post")
//	public void create() {
//		Product pr=new Product("Mobile","Motto","Japan",15000);
//		restTemplate.postForObject("http://localhost:8080/template/products",pr, Product.class);
//	}
	
	@PostMapping(value = "/template/products")
	   public String createProducts(@RequestBody Product product) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/post", HttpMethod.POST, entity, String.class).getBody();
	   }
	@DeleteMapping(value = "/template/products/{id}")
	   public String deleteProduct(@PathVariable("id") String id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8080/deletebyid/"+id, HttpMethod.DELETE, entity, String.class).getBody();
	   }
	
	
}
