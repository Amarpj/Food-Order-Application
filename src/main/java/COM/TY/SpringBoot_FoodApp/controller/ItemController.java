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
import COM.TY.SpringBoot_FoodApp.dto.Item;
import COM.TY.SpringBoot_FoodApp.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService service;
	
	@PostMapping("/saveitem")
	public ResponseEntity<ResponseStructure<Item>> saveitem(@RequestBody Item item) {
		return service.saveitem(item);
	}
	
	@PutMapping("/updateitem")
	public ResponseEntity<ResponseStructure<Item>> updaItem(@RequestParam int iid,@RequestBody Item item) {
		return service.saveitem(item);
	}
	
	@DeleteMapping("/deleteitem")
	public ResponseStructure<Item> deleteItem(@RequestParam int iid)
	{
		return service.deleteItem(iid);
	}
	
	@GetMapping("/getitembyid")
	public ResponseEntity<ResponseStructure<Item>> getitembuid(@RequestParam int iid) {
		return service.getitembuid(iid);
	}
	@GetMapping("/getitembyname")
	public Item getItemByName(@RequestParam String name) {
		return service.getItemByName(name);
}
}