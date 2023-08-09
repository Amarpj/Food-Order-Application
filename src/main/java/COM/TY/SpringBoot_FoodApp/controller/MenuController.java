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
import COM.TY.SpringBoot_FoodApp.dto.Menu;
import COM.TY.SpringBoot_FoodApp.dto.Product;
import COM.TY.SpringBoot_FoodApp.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService service;
	
	@PostMapping("/savemenu")
	public ResponseEntity<ResponseStructure<Menu>> savemenu(@RequestBody Menu menu) {
		return service.savemenu(menu);
		
	}
	@PutMapping("/updatemenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu( @RequestParam int mid,@RequestBody Menu menu) {
		return service.savemenu(menu);
	}
	
	@DeleteMapping("/deletemenu")
	public ResponseStructure<Menu> deleteMenu(@RequestParam int mid)
	{
		return service.deletemenu(mid);
	}
	
	@GetMapping("/getmenubyid")
	public ResponseEntity<ResponseStructure<Menu>> getmenubyiid(@RequestParam int mid) {
		return service.getmenubyid(mid);
	}
	@PutMapping("/addproducttomenu")
	public Menu addproducttomenu(@RequestBody Product product,@RequestParam int mid) {
		return service.addproductMenu(product, mid);
	}
	@GetMapping("/getmenubyname")
	public Menu getMenuByName(@RequestParam String name) {
		return service.getMenuByName(name);
	}
}
