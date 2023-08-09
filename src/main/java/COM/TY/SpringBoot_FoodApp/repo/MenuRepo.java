package COM.TY.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import COM.TY.SpringBoot_FoodApp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer> 
{

	@Query("select m from Menu m where m.mname=?1")
	public Menu getMenuByName(String name);
    
	
	}

