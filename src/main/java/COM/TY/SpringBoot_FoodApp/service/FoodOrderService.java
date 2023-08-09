package COM.TY.SpringBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import COM.TY.SpringBoot_FoodApp.config.ResponseStructure;
import COM.TY.SpringBoot_FoodApp.dao.FoodOrderDao;
import COM.TY.SpringBoot_FoodApp.dto.FoodOrder;
import COM.TY.SpringBoot_FoodApp.dto.Item;
import COM.TY.SpringBoot_FoodApp.exception.UserIdNotFoundException;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		List<Item> list = foodOrder.getList();
		double totalprice = 0;
		for (Item item : list) {
			totalprice += item.getCose() + item.getQuantity();
			foodOrder.setTotalprice(totalprice);
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int fid) {
		FoodOrder foodOrder2 = dao.getFoodOrder(fid);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		if (foodOrder2 != null) {
			List<Item> items = foodOrder.getList();
			double totalprice = 0;
			for (Item item : items) {
				totalprice += item.getCose() * item.getQuantity();
			}
			foodOrder.setTotalprice(totalprice);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.updateFoodOrder(foodOrder, fid));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);

		}
		throw new UserIdNotFoundException("user id not found");
	}
	
	public ResponseStructure<FoodOrder> deleteFoodOrder(int fid) {
		FoodOrder foodOrder=dao.deleteFoodOrder(fid);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		if(foodOrder!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("delete");
			responseStructure.setData(dao.deleteFoodOrder(fid));
			return responseStructure;
		}else
		{
			throw new UserIdNotFoundException("user id not found");
		}
	}
}
