package COM.TY.SpringBoot_FoodApp.exception;

public class FoodOrderIdNotFoundException extends RuntimeException {

	private String message="user id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public FoodOrderIdNotFoundException (String message) {
		this.message=message;
	}
	
}
	

