package com.wipro.sample;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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
@Api(value="Operations on products")
public class Controller {

	@Autowired
	ProductRepository repository;
	
	@Autowired
    private ModelMapper modelMapper;
	Logger logger=(Logger) LoggerFactory.getLogger(Controller.class);

	 @ApiOperation(value = "View a list of available products",response = Iterable.class)
   	@GetMapping("/get")
	public List<Product> getAll(){
     	 logger.info("list of products method");
		 return repository.findAll();
	}
	 @ApiOperation(value = "Add a product")
	@PostMapping("/post")
	public  void saveproduct(@RequestBody ProductDTO product) {
		 logger.trace("save method accessed");
		 Product prod=modelMapper.map(product, Product.class);
		repository.save(prod);
	}
	 @ApiOperation(value = "Delete a product")
	@DeleteMapping("/deletebyid/{id}")
	 public void deleteProduct(@PathVariable(name="id")Long id){
		 if(repository.findById(id).isPresent())
			 logger.warn("deleting product");
		 else
		    logger.error("id doesn't exists");
	  repository.deleteById(id);
	 }
	 @ApiOperation(value = "Update a product")
	@PutMapping("/updatebyid/{id}")
	 public void updateProduct(@RequestBody ProductDTO product,@PathVariable(name="id")Long id){
	  logger.trace("update method accessed");
	  Product prod=modelMapper.map(product, Product.class);
	  Optional<Product> p2=repository.findById(id);
	  
	    Product p1=p2.get();
		  logger.info("updating to be done");
      p1.setBrand(prod.getBrand());
      p1.setName(prod.getName());
      p1.setMadein(prod.getMadein());
      p1.setPrice(prod.getPrice());
      repository.save(p1);
	  
 }
}
