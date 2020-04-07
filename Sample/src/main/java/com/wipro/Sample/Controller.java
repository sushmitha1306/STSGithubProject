package com.wipro.Sample;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="products", description="Operations on products")
public class Controller {

	@Autowired
	ProductRepository repository;
	
	Logger logger=(Logger) LoggerFactory.getLogger(Controller.class);

	 @ApiOperation(value = "View a list of available products",response = Iterable.class)
   	@GetMapping("/get")
	public List<Product> getAll(){
     	 logger.info("list of products method");
		 return repository.findAll();
	}
	 @ApiOperation(value = "Add a product")
	@PostMapping("/post")
	public  void saveproduct(@RequestBody Product product) {
		 logger.trace("save method accessed");
		repository.save(product);
	}
	 @ApiOperation(value = "Delete a product")
	@DeleteMapping("/deletebyid/{id}")
	 public void deleteProduct(@PathVariable(name="id")Long id){
		 if(repository.findById(id).isPresent()!=false)
			 logger.warn("deleting product");
		 else
		    logger.error("id doesn't exists");
	  repository.deleteById(id);
	 }
	 @ApiOperation(value = "Update a product")
	@PutMapping("/updatebyid/{id}")
	 public void updateProduct(@RequestBody Product product,@PathVariable(name="id")Long id){
	  logger.trace("update method accessed");
	  Product p1=repository.getOne(id);
	  if(p1 == null){
		  logger.error("product with given id not found");;
	  }
	  else {
		  logger.info("updating to be done");
      p1.setBrand(product.getBrand());
      p1.setName(product.getName());
      p1.setMadein(product.getMadein());
      p1.setPrice(product.getPrice());
      repository.save(p1);
	  }
 }
}
