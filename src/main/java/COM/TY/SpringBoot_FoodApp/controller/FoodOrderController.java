package COM.TY.SpringBoot_FoodApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import COM.TY.SpringBoot_FoodApp.config.ResponseStructure;
import COM.TY.SpringBoot_FoodApp.dto.FoodOrder;
import COM.TY.SpringBoot_FoodApp.service.FoodOrderService;

@RestController
public class FoodOrderController {

	@Autowired
	private FoodOrderService service;
	
	@PostMapping("/savefoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@Valid @RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
		
	}
	@PutMapping("/updatefoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@Valid @RequestBody FoodOrder foodOrder, @RequestParam int fid) {
		return service.saveFoodOrder(foodOrder);
	}
	  
	@DeleteMapping("/deletefoodorder")
	public ResponseStructure<FoodOrder> deleteFoodOrder(@Valid @RequestParam int fid) {
		return service.deleteFoodOrder(fid);
	}
}

