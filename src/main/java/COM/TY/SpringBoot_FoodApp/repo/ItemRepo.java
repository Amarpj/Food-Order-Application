package COM.TY.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import COM.TY.SpringBoot_FoodApp.dto.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> 
{

	@Query("select i from Item i where i.iname=?1")
	public Item getItemByName(String name);

	
}	

