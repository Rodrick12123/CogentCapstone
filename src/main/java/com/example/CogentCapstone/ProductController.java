package com.example.CogentCapstone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("products/sorted/asc")
    public List<Product> getProductsSortedByPriceAsc() {
        return productService.findAllByOrderByPriceAsc();
    }
	
	@PutMapping("api/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(product);
    }

    @GetMapping("products/sorted/desc")
    public List<Product> getProductsSortedByPriceDesc() {
        return productService.findAllByOrderByPriceDesc();
    }
	
}
