package COM.TY.SpringBoot_FoodApp.exception;

public class ProductIdNotFoundException extends RuntimeException {

	private String message="user id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public ProductIdNotFoundException (String message) {
		this.message=message;
	}
	
	}
	


