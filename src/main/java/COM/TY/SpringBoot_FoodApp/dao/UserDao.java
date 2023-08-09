package COM.TY.SpringBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import COM.TY.SpringBoot_FoodApp.dto.User;
import COM.TY.SpringBoot_FoodApp.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveuser(User user) {
		return repo.save(user);
	}

	public User UpdateUser(int id, User user) {
		Optional<User> dbuser = repo.findById(id);
		if (dbuser.isPresent()) {
			user.setId(id);
			repo.save(user);
			return dbuser.get();
		} else {
			return null;
		}
	}

	public User deleteUser(int id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			repo.deleteById(id);
			return user.get();
		} else {
			return null;
		}
	}
	
	      public User getuserbyid( int id) {
		Optional<User> user=repo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else
		{
			return null;
		}
		}
}
