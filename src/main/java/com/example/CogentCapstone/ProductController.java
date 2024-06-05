package com.example.CogentCapstone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public Product create(@RequestBody Product product) {
		return productService.save(product);
	}
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable("id") Long id) {
		productService.deleteById(id);
	}
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	@GetMapping("/products/{sort}")
    public List<Product> getAllProductsSorted(@PathVariable("sort") String sortBy) {
        return productService.getAllProductsSorted(sortBy);
    }
	@GetMapping("/products/{category}")
	public List<Product>  getAllProductsByCategory(@PathVariable("category")String category) {
		return productService.loadProductByCategory(category);
	}
	
}
