package COM.TY.SpringBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import COM.TY.SpringBoot_FoodApp.dto.FoodOrder;
import COM.TY.SpringBoot_FoodApp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepo repo;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return repo.save(foodOrder);
	}

	public FoodOrder updateFoodOrder(FoodOrder foodOrder, int fid) {
		Optional<FoodOrder> foodOrder2 = repo.findById(fid);
		if (foodOrder2.isPresent()) {
			foodOrder.setFid(fid);
			foodOrder.setList(foodOrder.getList());
			repo.save(foodOrder);
			return foodOrder2.get();
		} else {
			return null;
		}
	}

	public FoodOrder getFoodOrder(int fid) {
		Optional<FoodOrder> foodOrder = repo.findById(fid);
		if (foodOrder.isPresent()) {
			return foodOrder.get();
		} else {
			return null;
		}
	}
	
	   public FoodOrder deleteFoodOrder(int fid) {
		Optional<FoodOrder> foodorder=repo.findById(fid);
		if(foodorder.isPresent()) {
			repo.deleteById(fid);
			return foodorder.get();
			
		}else {
			return null;
		}
		
	}
}
