package COM.TY.SpringBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import COM.TY.SpringBoot_FoodApp.dto.Item;
import COM.TY.SpringBoot_FoodApp.repo.ItemRepo;

@Repository
public class ItemDao {

	@Autowired
	private ItemRepo repo;
	
	public Item saveItem(Item item) {
		return repo.save(item);
	}
	public Item updateItem(int iid,Item item) {
		Optional<Item> item2 = repo.findById(iid);
		if(item2.isPresent()) {
			item.setItem_id(iid);
			repo.save(item);
			return item2.get();
		}
		return null;
	}
	
	public Item deleteitem(int iid) {
		Optional<Item> item =repo.findById(iid);
		if(item.isPresent()) {
			repo.deleteById(iid);
			return item.get();			
		}
		else {
			return null;
		}
	}
	  public Item  getitembyid(int iid) {
		Optional<Item> item=repo.findById(iid);
		if(item.isPresent()) {
			return item.get();
		}else {
			return null;
		}
	}
	  public Item getItemByName(String name) {
			Item item=repo.getItemByName(name);
			if(item !=null) {
				return item;
			}else {
				return null;
			}
}
}
