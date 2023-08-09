package COM.TY.SpringBoot_FoodApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import COM.TY.SpringBoot_FoodApp.config.ResponseStructure;
import COM.TY.SpringBoot_FoodApp.dto.User;
import COM.TY.SpringBoot_FoodApp.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value = "Save User", notes = "API is used to save user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Save Data Successfully"),
			@ApiResponse(code = 400, message = "given user id not found") })
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveuser(@Valid @RequestBody User user) {
		return service.saveuser(user);
	}
	@ApiOperation(value = "Update User", notes = "API is used to save user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Data Update Successfully"),
			@ApiResponse(code = 404, message = "given user id not found") })
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@Valid @RequestParam int id, @RequestBody User user) {
		return service.UpdateUser(id, user);
	}
	@ApiOperation(value = "Delete User", notes = "API is used to save user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Delete user Successfully"),
			@ApiResponse(code = 404, message = "given user id not found") })
	@DeleteMapping
	public ResponseStructure<User> deleteUser(@Valid @RequestParam int id) {
		return service.deleteUser(id);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<User>> getuserbyid(@Valid @RequestParam int id) {
		return service.getuserbyid(id);
	}
}
