package COM.TY.SpringBoot_FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import COM.TY.SpringBoot_FoodApp.config.ResponseStructure;
import COM.TY.SpringBoot_FoodApp.dto.Product;
import COM.TY.SpringBoot_FoodApp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/saveproduct")
	public ResponseEntity<ResponseStructure<Product>> saveproduct(@RequestBody Product product) {
		return service.saveproduct(product);
	}
	@PutMapping("/updateproduct")
	public ResponseEntity<ResponseStructure<Product>> updateproduct(@RequestParam int pid,@RequestBody Product product) {
		return service.updateproduct(pid, product);
	}
	
	@DeleteMapping("/deleteproduct")
	public ResponseStructure<Product> deleteproduct(@RequestParam int pid) {
		return service.deleteproduct(pid);
	}
	
	@GetMapping("/getproductbyid")
	public ResponseEntity<ResponseStructure<Product>> getproductbypid(@RequestParam int pid) {
		return service.getproductbyid(pid);
	}
}
