package COM.TY.SpringBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import COM.TY.SpringBoot_FoodApp.config.ResponseStructure;
import COM.TY.SpringBoot_FoodApp.dao.UserDao;
import COM.TY.SpringBoot_FoodApp.dto.User;
import COM.TY.SpringBoot_FoodApp.exception.UserIdNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveuser(User user) {
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveuser(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> UpdateUser(int id, User user) {
		User user2 = dao.UpdateUser(id, user);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (user2!= null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
		} else {
			throw new UserIdNotFoundException("user id not found");
		}
	}

	public ResponseStructure<User> deleteUser(int id) {
		User user = dao.deleteUser(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (user!= null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(user);
			return responseStructure;
		} else {
			throw new UserIdNotFoundException("user id not found");
		}
	}
	
	   public ResponseEntity<ResponseStructure<User>> getuserbyid(int id) {
		User user=dao.getuserbyid(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if(user!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(user);
			return  new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new  UserIdNotFoundException("user id not found");
		}
	}
}
