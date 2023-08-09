package COM.TY.SpringBoot_FoodApp.exception;

public class UserIdNotFoundException extends RuntimeException {

	private String message="user id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public UserIdNotFoundException (String message) {
		this.message=message;
	}
	
	}
	

	

