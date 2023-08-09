package COM.TY.SpringBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import COM.TY.SpringBoot_FoodApp.config.ResponseStructure;
import COM.TY.SpringBoot_FoodApp.dao.ItemDao;
import COM.TY.SpringBoot_FoodApp.dto.Item;
import COM.TY.SpringBoot_FoodApp.exception.UserIdNotFoundException;

@Service
public class ItemService {

	@Autowired
	private ItemDao dao;
	
	public ResponseEntity<ResponseStructure<Item>> saveitem(Item item) {
		ResponseStructure<Item> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveItem(item));
		return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<Item>> updateitem(int iid,Item item ) {
		Item item2=dao.updateItem(iid, item);
		ResponseStructure<Item> responseStructure=new ResponseStructure<>();
		if(item2 !=null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(item);	
			return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.CREATED);

		}else {
			throw new UserIdNotFoundException("user id not found");
		}
	}
	
	public ResponseStructure<Item> deleteItem(int iid) {		
		Item item = dao.deleteitem(iid);
		ResponseStructure<Item> responseStructure=new ResponseStructure<>();
		if(item !=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(item);	
			return responseStructure;
		}else {
			throw new UserIdNotFoundException("user id not found");
		}
	}
	 public  ResponseEntity<ResponseStructure<Item>> getitembuid(int iid) {
		Item item =dao.getitembyid(iid);
		ResponseStructure<Item> responseStructure=new ResponseStructure<>();
		if(item !=null) {
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("found");
		responseStructure.setData(item);	
			return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.FOUND);

		}else {
			throw new UserIdNotFoundException("user id not found"); 
		}
	}
	 public Item getItemByName(String name) {
			Item item=dao.getItemByName(name);
			if(item!=null) {
				return item;
			}else {
				return null;
			}
			}
}
