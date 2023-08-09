package COM.TY.SpringBoot_FoodApp.exception;

public class MenuIdNotFoundException extends RuntimeException {

	private String message="user id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public MenuIdNotFoundException (String message) {
		this.message=message;
	}
	
	}
	
