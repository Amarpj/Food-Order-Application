package COM.TY.SpringBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import COM.TY.SpringBoot_FoodApp.config.ResponseStructure;
import COM.TY.SpringBoot_FoodApp.dao.MenuDao;
import COM.TY.SpringBoot_FoodApp.dto.Menu;
import COM.TY.SpringBoot_FoodApp.dto.Product;
import COM.TY.SpringBoot_FoodApp.exception.UserIdNotFoundException;

@Service
public class MenuService {
	@Autowired
	private MenuDao dao;

	public ResponseEntity<ResponseStructure<Menu>> savemenu(Menu menu) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Menu>> updatemenu(Menu menu, int mid) {
		Menu menu2 = dao.updatemenu(mid, menu);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu2 != null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);

		} else {
			throw new UserIdNotFoundException("user id not found");
		}
	}

	public ResponseStructure<Menu> deletemenu(int mid) {
		Menu menu = dao.deletemenu(mid);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(menu);
			return responseStructure;
		} else {
			throw new UserIdNotFoundException("user id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getmenubyid(int mid) {
		Menu menu = dao.getmenubyid(mid);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);

		} else {
			throw new UserIdNotFoundException("user id not found");
		}
	}

	public Menu addproductMenu(Product product, int mid) {
		Menu menu = dao.getmenubyid(mid);
		List<Product> list = menu.getList();
		list.add(product);
		menu.setList(list);
		return dao.updatemenu(mid, menu);
	}

	public Menu getMenuByName(String name) {
		Menu menu = dao.getMenuByName(name);
		if (menu != null) {
			return menu;
		} else {
			return null;
		}
	}
}
