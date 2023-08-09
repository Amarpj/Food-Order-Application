package COM.TY.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import COM.TY.SpringBoot_FoodApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer> 
{

}
