package COM.TY.SpringBoot_FoodApp.exception;

public class ItemIdNotFoundException extends RuntimeException {

	private String message="user id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public ItemIdNotFoundException (String message) {
		this.message=message;
	}
	
	}
	


