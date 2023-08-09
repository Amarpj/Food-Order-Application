package COM.TY.SpringBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import COM.TY.SpringBoot_FoodApp.dto.Menu;
import COM.TY.SpringBoot_FoodApp.repo.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	private MenuRepo repo;

	public Menu saveMenu(Menu menu) {
		return repo.save(menu);
	}

	public Menu updatemenu(int mid, Menu menu) {
		Optional<Menu> menu2 = repo.findById(mid);
		if (menu2.isPresent()) {
			menu.setMid(mid);
			repo.save(menu);
			return menu2.get();
		}
		return null;

	}

	public Menu deletemenu(int mid) {
		Optional<Menu> menu = repo.findById(mid);
		if (menu.isPresent()) {
			repo.deleteById(mid);
			return menu.get();
		} else {
			return null;
		}
	}

	public Menu getmenubyid(int mid) {
		Optional<Menu> menu = repo.findById(mid);
		if (menu.isPresent()) {
			return menu.get();
		} else {
			return null;
		}
	}

	public Menu getMenuByName(String name) {
		Menu menu = repo.getMenuByName(name);
		if (menu != null) {
			return menu;
		} else {
			return null;
		}
	}

}
